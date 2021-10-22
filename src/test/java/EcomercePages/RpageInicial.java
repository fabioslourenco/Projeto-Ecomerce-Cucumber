package EcomercePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RpageInicial extends RbasePage {
    public RpageInicial(WebDriver eComerce) {
        super(eComerce);
    }

    public RpageInicial digitarProduto(String produto){
        eComerce.findElement(By.id("search_query_top")).sendKeys(produto);
        return this;
    }
    public RpageInicial fazerBusca(){
        eComerce.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[2]/form/button")).click();
        return this;
    }
    public RdetalheProduto pesquisarProduto(String produto){
        digitarProduto(produto);
        fazerBusca();
        return new RdetalheProduto(eComerce);
    }



}
