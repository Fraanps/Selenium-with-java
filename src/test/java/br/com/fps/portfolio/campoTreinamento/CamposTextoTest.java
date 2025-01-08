package br.com.fps.portfolio.campoTreinamento;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CamposTextoTest {

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
  public void testTextField(){
    dsl.escreve("elementosForm:nome", "Teste Escrita" );
    Assertions.assertEquals("Teste Escrita", dsl.obterValorCampo("elementosForm:nome"));
  }

  @Test
  public void interagirComTextArea(){
    dsl.escreve("elementosForm:sugestoes", "Teste escrita textArea" );
    Assertions.assertEquals("Teste escrita textArea", dsl.obterValorCampo("elementosForm:sugestoes"));
  }

  @Test
  public void interagirComRadioButton(){
    dsl.clicarRadioECheckbox("elementosForm:sexo:1");
    Assertions.assertTrue(dsl.isRadioECheckboxMarcado("elementosForm:sexo:1"));

  }

  @Test
  public void interagirComCheckBox(){
    dsl.clicarRadioECheckbox("elementosForm:comidaFavorita:1");
    Assertions.assertTrue(dsl.isRadioECheckboxMarcado("elementosForm:comidaFavorita:1"));

  }
}
