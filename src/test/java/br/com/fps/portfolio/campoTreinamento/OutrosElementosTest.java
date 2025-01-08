package br.com.fps.portfolio.campoTreinamento;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OutrosElementosTest {

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
  public void interagirComBotao(){

    dsl.clicarBotao("buttonSimple");
    Assertions.assertEquals("Obrigado!",
        dsl.obterValueElemento("buttonSimple"));

  }

  @Test
  public void interagirComLinks(){
    dsl.clicarLink("Voltar");
    Assertions.assertEquals("Voltou!", dsl.obterTexto("resultado"));
  }

  @Test
  public void buscarTextosNaPagina(){
    Assertions.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
  }

  @Test
  public void interagirComSpan(){
    Assertions.assertEquals("Cuidado onde clica, muitas armadilhas...",
        dsl.obterTexto(By.cssSelector("span[class=\"facilAchar\"]")));
  }
}
