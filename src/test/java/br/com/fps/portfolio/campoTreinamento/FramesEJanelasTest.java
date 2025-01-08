package br.com.fps.portfolio.campoTreinamento;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FramesEJanelasTest {

  // iframe é utlilizado para embutir o código de uma página html dentro de outra

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
  public void deveInteragirComFrame(){

    dsl.abrirFrame("frame1", "frameButton");
    dsl.swhitchAlert();
    String textAlerta = dsl.getTextAlert();
    assertEquals("Frame OK!", textAlerta  );
    dsl.getTextoEaceitarAlerta();
    dsl.retornarPaginaPrincipal();
    dsl.escreve("elementosForm:nome", textAlerta);
    driver.quit();
  }

  @Test
  public void deveInteragirComPopUp(){
    //String windowHandle = dsl.getJanelaAtual();
    dsl.abrirPopUpComNome("buttonPopUpEasy", "Popup" );
    dsl.escreve(By.tagName("textarea"), "Deu Certo!!!");
    dsl.fecharPopUp();
    dsl.voltarPaginaPelaWindowHandle();
    dsl.escreve(By.tagName("textarea"), "E agora??");
  }

  @Test
  public void deveInteragirComPopUpSemTitulo(){
    dsl.abrirPopupSemNome("buttonPopUpHard");
    dsl.escreve(By.tagName("textarea"), "Deu Certo!!!");
    dsl.fecharPopUp();
    dsl.voltarPaginaPelaWindowHandle();
    dsl.escreve(By.tagName("textarea"), "E agora??");
  }

}
