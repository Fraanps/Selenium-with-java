package br.com.fps.portfolio.campoTreinamento;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


public class DSL {

  private WebDriver driver;
  public DSL(WebDriver driver) {
    super();
    this.driver = driver;
  }

  public void escreve(By by, String texto){
    driver.findElement(by).sendKeys(texto);
  }

  // metodos text Area e Radio Button
  public void escreve(String idCampo, String texto){
     driver.findElement(By.id(idCampo)).sendKeys(texto);
   }

   public void clicarRadioECheckbox(String idCampo){
     driver.findElement(By.id(idCampo)).click();
   }

   public String obterValorCampo(String idCampo){
     return driver.findElement(By.id(idCampo)).getAttribute("value");
   }

   public boolean isRadioECheckboxMarcado(String idRadio){
     return driver.findElement(By.id(idRadio)).isSelected();
   }

   // METODOS DROPDOWNS

  public void selecionaDropdownVisibleText(String idDropdown, String valorVisivel){
    WebElement element = driver.findElement(By.id(idDropdown));
    Select drop = new Select(element);
    drop.selectByVisibleText(valorVisivel);
  }

  public void selecionaDropdownByIndex(String idDropdown, int index){
    WebElement element = driver.findElement(By.id(idDropdown));
    Select drop = new Select(element);
    drop.selectByIndex(index);
    //drop.selectByValue("especializacao");
  }

  public void selecionaDropdownByValue(String idDropdown, String value){
    WebElement element = driver.findElement(By.id(idDropdown));
    Select drop = new Select(element);
    drop.selectByValue(value);
  }

  public String obterValorDropdown(String idDropdown){
    WebElement element = driver.findElement(By.id(idDropdown));
    Select drop = new Select(element);
    return drop.getFirstSelectedOption().getText();
  }

  public int obterQuantidadeOpcoesDropdown(String idDropdown){
    WebElement element = driver.findElement(By.id(idDropdown));
    Select drop = new Select(element);
    List<WebElement> optionsDrop = drop.getOptions();
    return optionsDrop.size();
  }

  public boolean verificaOpcoeDropdown(String idDropdown, String opcao){
    WebElement dropdowEelement = driver.findElement(By.id(idDropdown));
    Select dropdown = new Select(dropdowEelement);
    return dropdown.getOptions()
        .stream() // método que permite iterar sobre as opções do dropdown de maneira mais legível e funcional
        .anyMatch(option -> option.getText().equals(opcao)); // verificando

//    List<WebElement> optionsDrop = dropdown.getOptions();
//    boolean encontrou = false;
//    for (WebElement option : optionsDrop) {
//      if (option.getText().equals(opcao)) {
//        encontrou = true;
//        break;
//      }
//    }
//    return encontrou;
  }

  public List<String> obterOpcoesMarcadasDropdown(String idDropdown){
    WebElement dropdownElement = driver.findElement(By.id(idDropdown));
    Select dropdown = new Select(dropdownElement);

    List<WebElement> opcoesSelecionadas = dropdown.getAllSelectedOptions();
    List<String> opcoesSelecionadasTexto = new ArrayList<>();

    for (WebElement opcao : opcoesSelecionadas) {
      opcoesSelecionadasTexto.add(opcao.getText());
    }

    return opcoesSelecionadasTexto;

  }

  public void deselecionarDropdown(String idDropdown, String opcao){
    WebElement dropdownElement = driver.findElement(By.id(idDropdown));
    Select dropdown = new Select(dropdownElement);
    // desmarcando no dropdown
    dropdown.deselectByVisibleText(opcao);
//    allSelectedOptions = dropdown.getAllSelectedOptions();
//    Assertions.assertEquals(2, allSelectedOptions.size());


  }

  // BOTOES
  public void clicarBotao(String idBotao){
    driver.findElement(By.id(idBotao)).click();
  }

  public String obterValueElemento(String idElemento){
    WebElement element = driver.findElement(By.id(idElemento));
    return element.getAttribute("value");
  }

  // links
  public void clicarLink(String idLink){
    driver.findElement(By.linkText(idLink)).click();

  }

  public String obterTexto(By by){
    return driver.findElement(by).getText();
  }

  public String obterTexto(String idCampo){
    return obterTexto(By.id(idCampo));
  }

  // FRAMES E JANELAS
  public void abrirFrame(String nomeFrame, String idFrame) {
    // mudando o foco para o frame
    driver.switchTo().frame(nomeFrame);
    // abre o frame
    driver.findElement(By.id(idFrame)).click();
  }

  // ALERTAS
  public void swhitchAlert(String ... msg) {
    Alert alertFrame = driver.switchTo().alert();
  }

  public void aceitaAlerta() {
    Alert alerta = driver.switchTo().alert();
    alerta.accept();
  }

  public String getTextAlert(){
    Alert alerta = driver.switchTo().alert();
    return alerta.getText();
  }

  public String getTextEaceitaAlerta(){
    Alert alert = driver.switchTo().alert();
    String textoAlerta = alert.getText();
    alert.accept();
    return textoAlerta;
  }

  public String getTextEnegaAlerta(){
    Alert alert = driver.switchTo().alert();
    String textoAlerta = alert.getText();
    alert.dismiss();
    return textoAlerta;
  }
  public void negaAlerta(){
    Alert alert = driver.switchTo().alert();
    alert.dismiss();
  }

  public String getTextoEaceitarAlerta(){
    Alert alert = driver.switchTo().alert();
    String textoAlerta = alert.getText();
    alert.accept();
    return textoAlerta;
  }


  public void eviarTextoAlerta(String texto) {
    Alert alert = driver.switchTo().alert();
    alert.sendKeys(texto);
  }






  public void retornarPaginaPrincipal(){
    driver.switchTo().defaultContent();
  }

  public String getJanelaAtual(){
    return driver.getWindowHandle();
  }

  public void abrirPopupSemNome(String id){
    driver.findElement(By.id(id)).click();
    driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
  }


  public void abrirPopUpComNome(String idPopup, String nomePopup) {
    driver.findElement(By.id(idPopup)).click();
    driver.switchTo().window(nomePopup);
  }

  public void voltarPaginaPelaWindowHandle(){
    driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]); // mudando para a janela principal
  }

  public void fecharPopUp() {
    driver.close();
  }



}
