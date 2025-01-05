package br.com.fps.portfolio.campoTreinamento;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FramesEJanelasTest {
  // iframe é utlilizado para embutir o código de uma página html dentro de outra

  @Test
  public void deveInteragirComFrame(){
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    // mudando o foco para o frame
    driver.switchTo().frame("frame1");
    driver.findElement(By.id("frameButton")).click();

    Alert alertFrame = driver.switchTo().alert();
    String msgAlert = alertFrame.getText();
    assertEquals("Frame OK!", msgAlert);
    alertFrame.accept();

    // retornando o foco para  ajanela principal
    driver.switchTo().defaultContent();
    driver.findElement(By.id("elementosForm:nome")).sendKeys(msgAlert);
    driver.quit();
  }

  @Test
  public void deveInteragirComPopUp(){
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    String windowHandle = driver.getWindowHandle();
    driver.findElement(By.id("buttonPopUpEasy")).click();
    driver.switchTo().window("Popup");
    driver.findElement(By.tagName("textarea")).sendKeys("Deu Certo!!!");
    driver.close();
    driver.switchTo().window(windowHandle);
    driver.findElement(By.tagName("textarea")).sendKeys("E agora??");
    driver.quit();

  }

  @Test
  public void deveInteragirComPopUpSemTitulo(){
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    //String windowHandle = driver.getWindowHandle();
    driver.findElement(By.id("buttonPopUpHard")).click();
    //System.out.println(driver.getWindowHandles()); // verifica as janelas atuais
    //String windowHandle = driver.getWindowHandle();//  salvanco o nome da janela atual

    driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
    driver.findElement(By.tagName("textarea")).sendKeys("Deu Certo!!!");
    driver.close();
    driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]); // mudando para a janela principal
    driver.findElement(By.tagName("textarea")).sendKeys("E agora??");
    driver.quit();

  }




}
