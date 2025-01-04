package br.com.fps.portfolio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * The type Teste campo treinamento.
 */
public class CampoTreinamentoTest {

  @Test
  public void Google2(){
    //caso não tiver o driver no path do SO
    //System.setProperty("webdriver.gecko.driver", "/Users/francilenesilva/Documents/drivers/geckodriver");
    WebDriver driver = new FirefoxDriver();
//    WebDriver driver = new ChromeDriver();
//    WebDriver driver = new InternetExplorerDriver();

    // driver.manage().window().setPosition(new Point(50, 50));
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("https://www.google.com/");
    // checkando o titulo
    Assertions.assertEquals("Google", driver.getTitle());
    driver.quit();
  }

  @Test
  public void Google(){

    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    driver.quit();
  }

}
