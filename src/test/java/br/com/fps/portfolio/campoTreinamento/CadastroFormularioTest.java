package br.com.fps.portfolio.campoTreinamento;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CadastroFormularioTest {

  @Test
  public void cadastroFormularioComSucesso() {

    WebDriver driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");

    driver.findElement(By.id("elementosForm:nome")).sendKeys("Francilene");
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

    String resultadoTexto = driver.findElement(By.id("resultado")).getText();

    Assertions.assertAll(
        () -> assertTrue(resultadoTexto.contains("Cadastrado!")),
        () -> assertTrue(resultadoTexto.contains("Francilene")),
        () -> assertTrue(resultadoTexto.contains("Silva")),
        () -> assertTrue(resultadoTexto.contains("Feminino")),
        () -> assertTrue(resultadoTexto.contains("Pizza")),
        () -> assertTrue(resultadoTexto.contains("superior")),
        () -> assertTrue(resultadoTexto.contains("Natacao Corrida")),
        () -> assertTrue(resultadoTexto.contains("Sem sugestões para o formulário"))
    );

    driver.quit();




  }
}
