package br.com.fps.portfolio.campoTreinamento;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DropdownsTest {


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
  public void basicDropdown() {
    dsl.selecionaDropdownVisibleText("elementosForm:escolaridade","Doutorado");
    Assertions.assertEquals("Doutorado", dsl.obterValorCampo("elementosForm:escolaridade"));
  }

  @Test
  public void verificarValoresDropdown() {
    // varificando a quantidade de valores disponiveis no dropdown
    Assertions.assertEquals(8, dsl.obterQuantidadeOpcoesDropdown("elementosForm:escolaridade")); // verificando o tamanho do drop
    // verificando se existe uma determinada opção no dropdown
    assertTrue(dsl.verificaOpcoeDropdown("elementosForm:escolaridade", "Mestrado"));
  }

  @Test
  public void dropdownMultiplaEscolha() {

    dsl.selecionaDropdownVisibleText("elementosForm:esportes", "Natacao");
    dsl.selecionaDropdownVisibleText("elementosForm:esportes", "Corrida");
    dsl.selecionaDropdownVisibleText("elementosForm:esportes", "O que eh esporte?");

    List<String> opcoesMarcadas = dsl.obterOpcoesMarcadasDropdown("elementosForm:esportes");
    Assertions.assertEquals(3, opcoesMarcadas.size());

    dsl.deselecionarDropdown("elementosForm:esportes", "Natacao");
    opcoesMarcadas = dsl.obterOpcoesMarcadasDropdown("elementosForm:esportes");
    Assertions.assertEquals(2, opcoesMarcadas.size());
    assertTrue(opcoesMarcadas.containsAll(Arrays.asList("Natacao", "O que eh esporte?")));

  }

}
