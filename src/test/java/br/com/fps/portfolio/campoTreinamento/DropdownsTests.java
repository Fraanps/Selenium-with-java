package br.com.fps.portfolio.campoTreinamento;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownsTests {
  @Test
  public void testDropdown() {
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
    Select drop = new Select(element);
    //drop.selectByIndex(2);
    //drop.selectByValue("especializacao");
    drop.selectByVisibleText("Doutorado"); // recomendado, pois é o que o usuário vai selecionar
    String text = drop.getFirstSelectedOption().getText();
    Assert.assertEquals("Doutorado", text);
    driver.quit();
  }

  @Test
  public void testVerificarValoresDropdown() {
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
    Select drop = new Select(element);

    List<WebElement> optionsDrop = drop.getOptions();

    Assert.assertEquals(8, optionsDrop.size()); // verificando o tamanho do drop

    // verificando se existe uma determinada opção no dropdown
    boolean encontrou = false;
    for (WebElement option : optionsDrop) {
      if (option.getText().equals("Mestrado")) {
        encontrou = true;
        break;
      }
    }
    Assert.assertTrue(encontrou);
    driver.quit();
  }

  @Test
  public void testDropdownMultiplaEscolha() {
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    WebElement element = driver.findElement(By.id("elementosForm:esportes"));
    Select drop = new Select(element);

    drop.selectByVisibleText("Natacao");
    drop.selectByVisibleText("Corrida");
    drop.selectByVisibleText("O que eh esporte?");



    List<WebElement> allSelectedOptions = drop.getAllSelectedOptions();
    Assert.assertEquals(3, allSelectedOptions.size());

    // desmarcando no dropdown
    drop.deselectByVisibleText("O que eh esporte?");
    allSelectedOptions = drop.getAllSelectedOptions();
    Assert.assertEquals(2, allSelectedOptions.size());
    driver.quit();


  }

}
