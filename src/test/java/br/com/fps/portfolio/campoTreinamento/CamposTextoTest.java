package br.com.fps.portfolio.campoTreinamento;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CamposTextoTest {
  @Test
  public void testTextField(){

    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste Escrita");
    Assertions.assertEquals("Teste Escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));

    driver.quit();
  }

  @Test
  public void interagirComTextArea(){

    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste escrita textArea");
    Assertions.assertEquals("Teste escrita textArea", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));

    driver.quit();
  }

  @Test
  public void interagirComRadioButton(){

    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    driver.findElement(By.id("elementosForm:sexo:1")).click();
    Assertions.assertTrue(driver.findElement(By.id("elementosForm:sexo:1")).isSelected());

    driver.quit();
  }
  @Test
  public void interagirComCheckBox(){
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
    Assertions.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:1")).isSelected());

    driver.quit();
  }
}
