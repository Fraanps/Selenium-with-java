package br.com.fps.portfolio.campoTreinamento;

import org.openqa.selenium.WebDriver;

public class CampoTreinamentoPage {

  private DSL dsl;

  public CampoTreinamentoPage(WebDriver driver) {
    dsl = new DSL(driver);
  }

  public void setNome(String nome) {
    dsl.escreve("elementosForm:nome", nome);
  }

  public void setSobrenome(String sobrenome) {
    dsl.escreve("elementosForm:sobrenome", sobrenome);
  }

  // SEXO

  public void setSexoMasculino() {
    dsl.clicarRadioECheckbox("elementosForm:sexo:0");
  }

  public void setSexoFeminino() {
    dsl.clicarRadioECheckbox("elementosForm:sexo:1");
  }

  // COMIDAS
  public void setComidaFavoritaCarne() {
    dsl.clicarRadioECheckbox("elementosForm:comidaFavorita:0");
  }

  public void setComidaFavoritaFrango() {
    dsl.clicarRadioECheckbox("elementosForm:comidaFavorita:1");
  }

  public void setComidaFavoritaPizza() {
    dsl.clicarRadioECheckbox("elementosForm:comidaFavorita:2");
  }

  public void setComidaFavoritaVegetariano() {
    dsl.clicarRadioECheckbox("elementosForm:comidaFavorita:3");
  }

  // ESCOLARIDADE
  public void setEscolaridadeSuperior(){
    dsl.selecionaDropdownVisibleText("elementosForm:escolaridade", "Superior");
  }

  // ESPORTES
  public void setEsporte(String... valores){
    for (String valor : valores) {
      dsl.selecionaDropdownVisibleText("elementosForm:esportes", valor);
    }
  }

  public void setDescricao(String sugestao) {
    dsl.escreve("elementosForm:sugestoes", sugestao );
  }

  public void cadastrar(){
    dsl.clicarBotao("elementosForm:cadastrar");
  }

  public String obterResultadoCadastro(){
    return dsl.obterTexto("resultado");
  }


}
