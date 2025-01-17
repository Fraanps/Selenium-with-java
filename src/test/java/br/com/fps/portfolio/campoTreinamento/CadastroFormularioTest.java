package br.com.fps.portfolio.campoTreinamento;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CadastroFormularioTest {

  private WebDriver driver;
  private DSL dsl;
  private CampoTreinamentoPage page;

  @BeforeEach
  public void initDriver(){
    driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
    dsl = new DSL(driver);
    page = new CampoTreinamentoPage(driver);
  }

  @AfterEach
  public void quitDriver(){
    driver.quit();
  }


  @Test
  public void cadastroFormularioComSucesso() {

    page.setNome("Antonio Francisco");
    page.setSobrenome("Oliveira Santos");
    page.setSexoMasculino();
    page.setComidaFavoritaPizza();
    page.setEscolaridade("Superior");
    page.setEsporte("Corrida", "Natacao");
    page.setDescricao("Sem sugestões para o formulário");
    page.cadastrar();

    String resultadoTexto = page.obterResultadoCadastro();
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

  @Test
  public void textFieldDuplo(){
    page.setNome("Antonio");
    assertEquals("Antonio",  dsl.obterValueElemento("elementosForm:nome"));
    page.setNome("Raimundo");
    assertEquals("Raimundo", dsl.obterValueElemento("elementosForm:nome"));

  }
}