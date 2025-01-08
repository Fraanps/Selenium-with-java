package br.com.fps.portfolio.campoTreinamento;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CadastroFormularioTest {

  private WebDriver driver;
  private DSL dsl;

  @BeforeEach
  public void initDriver(){
    driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
    dsl = new DSL(driver);
  }

  @AfterEach
  public void quitDriver(){
    driver.quit();
  }


  @Test
  public void cadastroFormularioComSucesso() {

    dsl.escreve("elementosForm:nome", "Antonio Francisco");
    dsl.escreve("elementosForm:sobrenome", "Oliveira Santos");

    dsl.clicarRadioECheckbox("elementosForm:sexo:0");
    dsl.clicarRadioECheckbox("elementosForm:comidaFavorita:2");

    // dropdown escolaridade

    dsl.selecionaDropdownVisibleText("elementosForm:escolaridade", "Superior");

    // dropdown esports
    dsl.selecionaDropdownVisibleText("elementosForm:esportes", "Corrida");
    dsl.selecionaDropdownVisibleText("elementosForm:esportes", "Natacao");

    dsl.escreve("elementosForm:sugestoes", "Sem sugestões para o formulário" );

    dsl.clicarBotao("elementosForm:cadastrar");


    String resultadoTexto = dsl.obterTexto("resultado");

    Assertions.assertAll(
        () -> assertTrue(resultadoTexto.contains("Cadastrado!")),
        () -> assertTrue(resultadoTexto.contains("Antonio Francisco")),
        () -> assertTrue(resultadoTexto.contains("Oliveira Santos")),
        () -> assertTrue(resultadoTexto.contains("Masculino")),
        () -> assertTrue(resultadoTexto.contains("Pizza")),
        () -> assertTrue(resultadoTexto.contains("superior")),
        () -> assertTrue(resultadoTexto.contains("Natacao Corrida")),
        () -> assertTrue(resultadoTexto.contains("Sem sugestões para o formulário"))
    );

  }
}
