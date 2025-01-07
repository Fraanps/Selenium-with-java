package br.com.fps.portfolio.campoTreinamento;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegrasDeNegocioTest {

  /**
   * Campos com regras:
   * nome, sobrenome, sexo devem ser preenchidos
   * não posso marcar a comida favorita carne e vegetariano
   * não posso marcar algum esporte e tbm a opção "o que é esporte?"
   * */

  @Test
  public void cadastroFormularioComNomeObrigatorio() {
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    //driver.findElement(By.id("elementosForm:nome")).sendKeys("Francilene");
    driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Silva");
    driver.findElement(By.id("elementosForm:sexo:1")).click();
    driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();

    // dropdown escolaridade
    WebElement element;
    element = driver.findElement(By.id("elementosForm:escolaridade"));
    Select drop = new Select(element);
    drop.selectByVisibleText("Superior");

    // dropdown esports
    element = driver.findElement(By.id("elementosForm:esportes"));
    Select drop2 = new Select(element);
    drop2.selectByVisibleText("Corrida");
    drop2.selectByVisibleText("Natacao");
    driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Sem sugestões para o formulário");

    driver.findElement(By.id("elementosForm:cadastrar")).click();

    // mudando foco para o alerta de erro
    Alert alerta = driver.switchTo().alert();
    String textoAlerta = alerta.getText();
    Assertions.assertEquals("Nome eh obrigatorio", alerta.getText() );
    alerta.accept();
    driver.quit();
  }

  @Test
  public void cadastroFormularioComSobrenomeObrigatorio() {
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    driver.findElement(By.id("elementosForm:nome")).sendKeys("Francilene");
    driver.findElement(By.id("elementosForm:sexo:1")).click();
    driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();

    // dropdown escolaridade
    WebElement element;
    element = driver.findElement(By.id("elementosForm:escolaridade"));
    Select drop = new Select(element);
    drop.selectByVisibleText("Superior");

    // dropdown esports
    element = driver.findElement(By.id("elementosForm:esportes"));
    Select drop2 = new Select(element);
    drop2.selectByVisibleText("Corrida");
    drop2.selectByVisibleText("Natacao");
    driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Sem sugestões para o formulário");

    driver.findElement(By.id("elementosForm:cadastrar")).click();

    // mudando foco para o alerta de erro
    Alert alerta = driver.switchTo().alert();
    String textoAlerta = alerta.getText();
    Assertions.assertEquals("Sobrenome eh obrigatorio", alerta.getText() );
    alerta.accept();

    driver.quit();
  }

  @Test
  public void cadastroFormularioComSexoEhObrigatorio() {
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    driver.findElement(By.id("elementosForm:nome")).sendKeys("Francilene");
    driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Silva");

    //checkbox comida favorita
    driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();

    // dropdown escolaridade
    WebElement element;
    element = driver.findElement(By.id("elementosForm:escolaridade"));
    Select drop = new Select(element);
    drop.selectByVisibleText("Superior");

    // dropdown esports
    element = driver.findElement(By.id("elementosForm:esportes"));
    Select drop2 = new Select(element);
    drop2.selectByVisibleText("Corrida");
    drop2.selectByVisibleText("Natacao");
    driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Sem sugestões para o formulário");

    driver.findElement(By.id("elementosForm:cadastrar")).click();

    // mudando foco para o alerta de erro
    Alert alerta = driver.switchTo().alert();
    String textoAlerta = alerta.getText();
    Assertions.assertEquals("Sexo eh obrigatorio", alerta.getText() );
    alerta.accept();

    driver.quit();
  }

  @Test
  public void cadastroFormularioComValidacaoComidaFavorita() {
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    driver.findElement(By.id("elementosForm:nome")).sendKeys("Francilene");
    driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Silva");
    driver.findElement(By.id("elementosForm:sexo:1")).click();

    driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
    driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();

    // dropdown escolaridade
    WebElement element;
    element = driver.findElement(By.id("elementosForm:escolaridade"));
    Select drop = new Select(element);
    drop.selectByVisibleText("Superior");

    // dropdown esports
    element = driver.findElement(By.id("elementosForm:esportes"));
    Select drop2 = new Select(element);
    drop2.selectByVisibleText("Corrida");
    drop2.selectByVisibleText("Natacao");
    driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Sem sugestões para o formulário");

    driver.findElement(By.id("elementosForm:cadastrar")).click();

    // mudando foco para o alerta de erro
    Alert alerta = driver.switchTo().alert();
    String textoAlerta = alerta.getText();
    Assertions.assertEquals("Tem certeza que voce eh vegetariano?", alerta.getText() );
    alerta.accept();

    driver.quit();
  }

  @Test
  public void cadastroFormularioComValidacaoEsporte() {
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    driver.findElement(By.id("elementosForm:nome")).sendKeys("Francilene");
    driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Silva");
    driver.findElement(By.id("elementosForm:sexo:1")).click();

    //checkbox comida favorita
    driver.findElement(By.id("elementosForm:comidaFavorita:0")).click(); // marcando carne

    // dropdown escolaridade
    WebElement element;
    element = driver.findElement(By.id("elementosForm:escolaridade"));
    Select drop = new Select(element);
    drop.selectByVisibleText("Superior");

    // dropdown esports
    element = driver.findElement(By.id("elementosForm:esportes"));
    Select drop2 = new Select(element);
    drop2.selectByVisibleText("Corrida");
    drop2.selectByVisibleText("O que eh esporte?");
    driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Sem sugestões para o formulário");

    driver.findElement(By.id("elementosForm:cadastrar")).click();

    // mudando foco para o alerta de erro
    Alert alerta = driver.switchTo().alert();
    String textoAlerta = alerta.getText();
    Assertions.assertEquals("Voce faz esporte ou nao?", alerta.getText() );
    alerta.accept();

    driver.quit();
  }


}


