package EcomercePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Rpayment extends RbasePage {

    public Rpayment(WebDriver eComerce) {
        super(eComerce);
    }

    public Rpayment metodoPagamento(){
     eComerce.findElement(By.xpath("//a[@title=\"Pay by bank wire\"]")).click();
        return this;
    }
    public Rpayment confirmacaoPagamento(){
      eComerce.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button/span")).click();
        return this;
    }
}
