package br.com.fps.portfolio.campoTreinamento;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertsTest {

  @Test
  public void deveInteragirComAlertSimples(){
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    driver.findElement(By.id("alert")).click();

    // alterar o foco para o alerta
    Alert alerta = driver.switchTo().alert();

    String textoAlerta = alerta.getText();

    Assertions.assertEquals("Alert Simples", alerta.getText() );
    alerta.accept();
    driver.findElement(By.id("elementosForm:nome")).sendKeys(textoAlerta);
  }

  @Test
  public void deveInteragirComAlertComConfirm(){
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    driver.findElement(By.id("confirm")).click();

    // alterar o foco para o alerta
    Alert alerta = driver.switchTo().alert();
    alerta.accept();
    Assertions.assertEquals("Confirmado", alerta.getText() );
    alerta.accept();
    driver.quit();

  }

  @Test
  public void deveInteragirComAlertComConfirmNegado(){
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    driver.findElement(By.id("confirm")).click();

    // alterar o foco para o alerta
    Alert alerta = driver.switchTo().alert();
    alerta.dismiss();
    Assertions.assertEquals("Negado", alerta.getText() );
    alerta.dismiss();
    driver.quit();

  }

  @Test
  public void deveInteragirComAlertPrompt(){
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    driver.findElement(By.id("prompt")).click();
    Alert alerta = driver.switchTo().alert();
    Assertions.assertEquals("Digite um numero", alerta.getText() );

    String textPrompt = "12";
    alerta.sendKeys(textPrompt);
    alerta.accept();
    Assertions.assertEquals("Era " + textPrompt + "?", alerta.getText() );
    alerta.accept();
    Assertions.assertEquals(":D", alerta.getText() );

    alerta.accept();


    driver.quit();

  }

  @Test
  public void deveInteragirComAlertPromptNegado(){
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    driver.findElement(By.id("prompt")).click();
    Alert alerta = driver.switchTo().alert();
    Assertions.assertEquals("Digite um numero", alerta.getText() );
    alerta.dismiss();
    Assertions.assertEquals("Era null?", alerta.getText() );
    alerta.dismiss();
    Assertions.assertEquals(":(", alerta.getText() );

    alerta.dismiss();
    driver.quit();

  }
}
