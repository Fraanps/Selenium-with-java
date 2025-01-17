package br.com.fps.portfolio.campoTreinamento;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class RegrasDeCadastroParametrizadosTest {

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

  private static Stream<Arguments> cenariosDeTeste(){
    return Stream.of(
//        Arguments.of("", "", "", Arrays.asList(), new String[]{}, "", "Nome eh obrigatorio")
        Arguments.of("", "Silva", "Feminino", Arrays.asList("Carne"), "Superior",new String[]{"Natacao"},  "Nome eh obrigatorio"),
        Arguments.of("Francilene", "", "Feminino", Arrays.asList("Carne"), "Superior",new String[]{"Natacao"},  "Sobrenome eh obrigatorio"),
        Arguments.of("Francilene", "Silva", "", Arrays.asList("Carne"), "Superior",new String[]{"Natacao"},  "Sexo eh obrigatorio"),
        Arguments.of("Francilene", "Silva", "Feminino", Arrays.asList("Carne", "Vegetariano"), "Superior",new String[]{"Natacao"},  "Tem certeza que voce eh vegetariano?"),
        Arguments.of("Francilene", "Silva", "Feminino", Arrays.asList("Carne"), "Superior",new String[]{"Natacao", "O que eh esporte?"},  "Voce faz esporte ou nao?")

    );
  }

  @ParameterizedTest
  @MethodSource("cenariosDeTeste")
  public void deveValidarRegras(String nome, String sobrenome,
                                String sexo, List<String> comidas,
                                String escolaridade, String[] esportes,  String msg) {

    page.setNome(nome);
    page.setSobrenome(sobrenome);

    if (sexo.equals("Masculino")){
      page.setSexoMasculino();
    } else if (sexo.equals("Feminino")){
      page.setSexoFeminino();
    }

    if(comidas.contains("Carne")) page.setComidaFavoritaCarne();
    if(comidas.contains("Pizza")) page.setComidaFavoritaPizza();
    if(comidas.contains("Frango")) page.setComidaFavoritaFrango();
    if(comidas.contains("Vegetariano")) page.setComidaFavoritaVegetariano();

    page.setEscolaridade(escolaridade);
    page.setEsporte(esportes);
    
    page.setDescricao("Sem sugestões para o formulário");
    page.cadastrar();

    Assertions.assertEquals(msg, dsl.obterTextoAlerta() );

  }



}
