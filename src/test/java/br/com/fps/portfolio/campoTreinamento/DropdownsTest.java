package br.com.fps.portfolio.campoTreinamento;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownsTest {
  @Test
  public void basicDropdown() {
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
    Select drop = new Select(element);
    //drop.selectByIndex(2);
    //drop.selectByValue("especializacao");
    drop.selectByVisibleText("Doutorado"); // recomendado, pois é o que o usuário vai selecionar
    String text = drop.getFirstSelectedOption().getText();
    Assertions.assertEquals("Doutorado", text);
    driver.quit();
  }

  @Test
  public void verificarValoresDropdown() {
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
    Select drop = new Select(element);

    List<WebElement> optionsDrop = drop.getOptions();

    Assertions.assertEquals(8, optionsDrop.size()); // verificando o tamanho do drop

    // verificando se existe uma determinada opção no dropdown
    boolean encontrou = false;
    for (WebElement option : optionsDrop) {
      if (option.getText().equals("Mestrado")) {
        encontrou = true;
        break;
      }
    }
    Assertions.assertTrue(encontrou);
    driver.quit();
  }

  @Test
  public void dropdownMultiplaEscolha() {
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    WebElement element = driver.findElement(By.id("elementosForm:esportes"));
    Select drop = new Select(element);

    drop.selectByVisibleText("Natacao");
    drop.selectByVisibleText("Corrida");
    drop.selectByVisibleText("O que eh esporte?");



    List<WebElement> allSelectedOptions = drop.getAllSelectedOptions();
    Assertions.assertEquals(3, allSelectedOptions.size());

    // desmarcando no dropdown
    drop.deselectByVisibleText("O que eh esporte?");
    allSelectedOptions = drop.getAllSelectedOptions();
    Assertions.assertEquals(2, allSelectedOptions.size());
    driver.quit();


  }

}
