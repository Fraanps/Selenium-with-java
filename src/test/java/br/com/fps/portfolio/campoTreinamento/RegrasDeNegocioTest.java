package br.com.fps.portfolio.campoTreinamento;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegrasDeNegocioTest {

  /**
   * Campos com regras:
   * nome, sobrenome, sexo devem ser preenchidos;
   * não posso marcar a comida favorita carne e vegetariano;
   * não posso marcar algum esporte e tbm a opção "o que é esporte?"
   * */

  private WebDriver driver;
  private DSL dsl;
  private CampoTreinamentoPage page;


  @BeforeEach
  public void initDriver(){
    driver = new FirefoxDriver();
    driver.manage().window().setSize(new Dimension(1200, 765));
    driver.get("file:" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
    dsl = new DSL(driver);
    page = new CampoTreinamentoPage(driver);

  }

  @AfterEach
  public void quitDriver(){
    driver.quit();
  }

  @Test
  public void cadastroFormularioComNomeObrigatorio() {

    page.setSobrenome("Silva");
    page.setSexoFeminino();
    page.setComidaFavoritaPizza();

    page.setEscolaridadeSuperior();
    page.setEsporte("Corrida", "Natacao");

    page.setDescricao("Sem sugestões para o formulário");
    page.cadastrar();

    String textAlerta = dsl.obterTextoAlerta();
    Assertions.assertEquals("Nome eh obrigatorio", textAlerta );
  }

  @Test
  public void cadastroFormularioComSobrenomeObrigatorio() {

    page.setNome("Francilene");
    page.setSexoFeminino();
    page.setComidaFavoritaPizza();

    page.setEscolaridadeSuperior();
    page.setEsporte("Corrida", "Natacao");

    page.setDescricao("Sem sugestões para o formulário");
    page.cadastrar();

    String textAlerta = dsl.obterTextoAlerta();
    Assertions.assertEquals("Sobrenome eh obrigatorio", textAlerta );

  }

  @Test
  public void cadastroFormularioComSexoEhObrigatorio() {

    page.setNome("Francilene");
    page.setSobrenome("Silva");
    page.setComidaFavoritaPizza();

    page.setEscolaridadeSuperior();
    page.setEsporte("Corrida", "Natacao");

    page.setDescricao("Sem sugestões para o formulário");
    page.cadastrar();

    String textAlerta = dsl.obterTextoAlerta();
    Assertions.assertEquals("Sexo eh obrigatorio", textAlerta );
  }

  @Test
  public void cadastroFormularioComValidacaoComidaFavorita() {

    page.setNome("Francilene");
    page.setSobrenome("Silva");
    page.setSexoFeminino();

    page.setComidaFavoritaCarne();
    page.setComidaFavoritaVegetariano();

    page.setEscolaridadeSuperior();
    page.setEsporte("Corrida", "Natacao");
    page.setDescricao("Sem sugestões para o formulário");
    page.cadastrar();

    String textAlerta = dsl.obterTextoAlerta();
    Assertions.assertEquals("Tem certeza que voce eh vegetariano?", textAlerta );

  }

  @Test
  public void cadastroFormularioComValidacaoEsporte() {

    page.setNome("Francilene");
    page.setSobrenome("Silva");
    page.setSexoFeminino();
    page.setComidaFavoritaPizza();
    page.setEscolaridadeSuperior();

    page.setEsporte("Corrida", "O que eh esporte?");
    page.setDescricao("Sem sugestões para o formulário");
    page.cadastrar();

    String textAlerta = dsl.obterTextoAlerta();
    Assertions.assertEquals("Voce faz esporte ou nao?", textAlerta );

  }

}


