package br.com.fps.portfolio.campoTreinamento;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegrasDeNegocioTest {

  /**
   * Campos com regras:
   * nome, sobrenome, sexo devem ser preenchidos;
   * não posso marcar a comida favorita carne e vegetariano;
   * não posso marcar algum esporte e tbm a opção "o que é esporte?"
   * */

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
  public void cadastroFormularioComNomeObrigatorio() {

    dsl.escreve("elementosForm:sobrenome", "Silva");
    dsl.clicarRadioECheckbox("elementosForm:sexo:1");
    dsl.clicarRadioECheckbox("elementosForm:comidaFavorita:2");

    dsl.selecionaDropdownVisibleText("elementosForm:escolaridade", "Superior" );

    dsl.selecionaDropdownVisibleText("elementosForm:esportes", "Corrida" );
    dsl.selecionaDropdownVisibleText("elementosForm:esportes", "Natacao" );

    dsl.escreve("elementosForm:sugestoes", "Sem sugestões para o formulário");
    dsl.clicarBotao("elementosForm:cadastrar");

    String textAlerta = dsl.getTextAlert();
    Assertions.assertEquals("Nome eh obrigatorio", textAlerta );
  }

  @Test
  public void cadastroFormularioComSobrenomeObrigatorio() {
    dsl.escreve("elementosForm:nome", "Francilene");
    dsl.clicarRadioECheckbox("elementosForm:sexo:1");
    dsl.clicarRadioECheckbox("elementosForm:comidaFavorita:2");

    dsl.selecionaDropdownVisibleText("elementosForm:escolaridade", "Superior" );

    dsl.selecionaDropdownVisibleText("elementosForm:esportes", "Corrida" );
    dsl.selecionaDropdownVisibleText("elementosForm:esportes", "Natacao" );

    dsl.escreve("elementosForm:sugestoes", "Sem sugestões para o formulário");
    dsl.clicarBotao("elementosForm:cadastrar");

    String textAlerta = dsl.getTextAlert();
    Assertions.assertEquals("Sobrenome eh obrigatorio", textAlerta );

  }

  @Test
  public void cadastroFormularioComSexoEhObrigatorio() {

    dsl.escreve("elementosForm:nome","Francilene");
    dsl.escreve("elementosForm:sobrenome", "Silva");

    //checkbox comida favorita
    dsl.clicarRadioECheckbox("elementosForm:comidaFavorita:2");

    dsl.selecionaDropdownVisibleText("elementosForm:escolaridade", "Superior" );

    dsl.selecionaDropdownVisibleText("elementosForm:esportes", "Corrida" );
    dsl.selecionaDropdownVisibleText("elementosForm:esportes", "Natacao" );

    dsl.escreve("elementosForm:sugestoes", "Sem sugestões para o formulário");
    dsl.clicarBotao("elementosForm:cadastrar");

    String textAlerta = dsl.getTextAlert();
    Assertions.assertEquals("Sexo eh obrigatorio", textAlerta );
  }

  @Test
  public void cadastroFormularioComValidacaoComidaFavorita() {

    dsl.escreve("elementosForm:nome","Francilene");
    dsl.escreve("elementosForm:sobrenome", "Silva");
    dsl.clicarRadioECheckbox("elementosForm:sexo:1");

    dsl.clicarRadioECheckbox("elementosForm:comidaFavorita:1");
    dsl.clicarRadioECheckbox("elementosForm:comidaFavorita:3");

    dsl.selecionaDropdownVisibleText("elementosForm:escolaridade", "Superior" );

    dsl.selecionaDropdownVisibleText("elementosForm:esportes", "Corrida" );
    dsl.selecionaDropdownVisibleText("elementosForm:esportes", "Natacao" );

    dsl.escreve("elementosForm:sugestoes", "Sem sugestões para o formulário");
    dsl.clicarBotao("elementosForm:cadastrar");

    String textAlerta = dsl.getTextAlert();
    Assertions.assertEquals("Tem certeza que voce eh vegetariano?", textAlerta );

  }

  @Test
  public void cadastroFormularioComValidacaoEsporte() {
    dsl.escreve("elementosForm:nome","Francilene");
    dsl.escreve("elementosForm:sobrenome", "Silva");
    dsl.clicarRadioECheckbox("elementosForm:sexo:1");

    dsl.clicarRadioECheckbox("elementosForm:comidaFavorita:1");

    dsl.selecionaDropdownVisibleText("elementosForm:escolaridade", "Superior" );

    dsl.selecionaDropdownVisibleText("elementosForm:esportes", "Corrida" );
    dsl.selecionaDropdownVisibleText("elementosForm:esportes", "O que eh esporte?" );

    dsl.escreve("elementosForm:sugestoes", "Sem sugestões para o formulário");
    dsl.clicarBotao("elementosForm:cadastrar");

    String textAlerta = dsl.getTextAlert();
    Assertions.assertEquals("Voce faz esporte ou nao?", textAlerta );

  }

}


