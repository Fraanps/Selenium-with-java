package br.com.fps.portfolio.campoTreinamento;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertsTest {

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
  public void deveInteragirComAlertSimples(){
    dsl.clicarBotao("alert");
    String textoAlerta = dsl.obterTextEaceitaAlerta();

    Assertions.assertEquals("Alert Simples", textoAlerta);
    dsl.escreve("elementosForm:nome", textoAlerta);
  }

  @Test
  public void deveInteragirComAlertComConfirm(){
    dsl.clicarBotao("confirm");
    String textoAlerta = dsl.obterTextEaceitaAlerta();
    Assertions.assertEquals("Confirm Simples", textoAlerta);
    dsl.getTextoEaceitarAlerta();

  }

  @Test
  public void deveInteragirComAlertComConfirmNegado(){

    dsl.clicarBotao("confirm");
    String textoAlerta = dsl.obterTextEnegaAlerta();
    Assertions.assertEquals("Confirm Simples", textoAlerta );
    textoAlerta = dsl.obterTextEaceitaAlerta();
    Assertions.assertEquals("Negado", textoAlerta );
  }

  @Test
  public void deveInteragirComAlertPrompt(){

    dsl.clicarBotao("prompt");
    String textoAlerta = dsl.obterTextoAlerta();
    Assertions.assertEquals("Digite um numero", textoAlerta );
    dsl.enviarTextoAlertaEAceita("12");
//    dsl.eviarTextoAlerta("12");
//    dsl.aceitaAlerta();
    String textoAceitaAlerta = dsl.getTextoEaceitarAlerta();
    Assertions.assertEquals("Era 12?", textoAceitaAlerta );
//    String textAlert = dsl.getTextAlert();
//    Assertions.assertEquals(":D", textAlert );
  }

  @Test
  public void deveInteragirComAlertPromptNegado(){

    dsl.clicarBotao("prompt");
    String textoAlerta = dsl.obterTextoAlerta();
    Assertions.assertEquals("Digite um numero", textoAlerta );
    dsl.negaAlerta();
    String textoAlertaNegado = dsl.obterTextoAlerta();
    Assertions.assertEquals("Era null?", textoAlertaNegado );
    dsl.negaAlerta();
//    String textoAlertaNegado2 = dsl.getTextAlert();
//    Assertions.assertEquals(":(", textoAlertaNegado2 );
//    dsl.aceitaAlerta();


  }

}
