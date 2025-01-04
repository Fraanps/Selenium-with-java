package br.com.fps.portfolio.campoTreinamento;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OutrosElementosTest {

  @Test
  public void interagirComBotao(){
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    WebElement botao = driver.findElement(By.id("buttonSimple"));
    botao.click();

    Assertions.assertEquals("Obrigado!", botao.getAttribute("value"));
    driver.quit();

  }

  @Test
  public void interagirComLinks(){
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    driver.findElement(By.linkText("Voltar")).click();

    WebElement element = driver.findElement(By.id("resultado"));
    Assertions.assertEquals("Voltou!", element.getText());
    driver.quit();
  }

  @Test
  public void buscarTextosNaPagina(){
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    //Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
    Assertions.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
    driver.quit();
  }

  @Test
  public void interagirComSpan(){
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    Assertions.assertEquals("Cuidado onde clica, muitas armadilhas...",
        driver.findElement(By.cssSelector("span[class=\"facilAchar\"]")).getText());

    driver.quit();
  }
}
