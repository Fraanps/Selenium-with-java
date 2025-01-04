package br.com.fps.portfolio;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * The type Teste google.
 */
public class TesteGoogle {

  /**
   * Test google.
   */
  @Test
  public void testGoogle(){
    //caso não tiver o driver no path do SO
    //System.setProperty("webdriver.gecko.driver", "/Users/francilenesilva/Documents/drivers/geckodriver");
    WebDriver driver = new FirefoxDriver();
//    WebDriver driver = new ChromeDriver();
//    WebDriver driver = new InternetExplorerDriver();

   // driver.manage().window().setPosition(new Point(50, 50));
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("https://www.google.com/");
    // checkando o titulo
    Assert.assertEquals("Google", driver.getTitle());
    driver.quit();
  }

}
