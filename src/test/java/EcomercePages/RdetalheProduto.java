package EcomercePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RdetalheProduto extends RbasePage {
    public RdetalheProduto(WebDriver eComerce) {
        super(eComerce);
    }

    public RdetalheProduto selecionarProduto(String AcessarProduto){
        eComerce.findElement(By.linkText(AcessarProduto)).click();
        return new RdetalheProduto(eComerce);
    }

    public RdetalheProduto selectTamanho(String tamanho){
        WebElement campoTamanho = eComerce.findElement(By.id("group_1"));
        new Select(campoTamanho).selectByVisibleText(tamanho);
        return this;
    }

    public RdetalheProduto selectColor(String color){
        eComerce.findElement(By.id(color)).click();
        return this;
    }
    public RdetalheProduto definirProduto(String tamanho, String color){
        selectTamanho(tamanho);
        selectColor(color);
        return this;
    }
    public RdetalheProduto addMoreOneProduto(){
        eComerce.findElement(By.xpath("//i[@class=\"icon-plus\"]")).click();
        return this;
    }
    public RdetalheProduto addCarrinho(){
        eComerce.findElement(By.xpath("//button[@name=\"Submit\"]")).click();
        return this;
    }
    public RpageInicial continueShopping(){
       eComerce.findElement(By.xpath("//i[@class=\"icon-chevron-left left\"]")).click();
        return new RpageInicial(eComerce);
    }
    public RpageCheckOut continueToCheckOut(){
    eComerce.findElement(By.xpath("//a[@title=\"Proceed to checkout\"]")).click();
        return new RpageCheckOut(eComerce);
    }
}
