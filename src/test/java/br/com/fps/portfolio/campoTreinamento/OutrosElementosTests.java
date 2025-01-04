package br.com.fps.portfolio.campoTreinamento;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OutrosElementosTests {

  @Test
  public void testInteragirComBotao(){
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    WebElement botao = driver.findElement(By.id("buttonSimple"));
    botao.click();

    Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
    driver.quit();

  }

  @Test
  public void testInteragirComLink(){
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    WebElement botao = driver.findElement(By.xpath(""));
    botao.click();

    Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
    driver.quit();

  }
}
