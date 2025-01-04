package br.com.fps.portfolio;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * The type Teste campo treinamento.
 */
public class TesteCampoTreinamento {

  /**
   * Test google.
   */
  @Test
  public void testGoogle(){

    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    driver.quit();
  }

}
