package EcomercePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RpageCheckOut extends RbasePage {
    public RpageCheckOut(WebDriver eComerce) {
        super(eComerce);
    }
    public RpageCheckOut continueToCheckOut2(){
        eComerce.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]/span")).click();
        return this;
    }
    public RpageCheckOut continueToCheckOut3(){
        eComerce.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button/span")).click();
        return this;
    }
    public RpageCheckOut terms(){
       eComerce.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div/p[2]/div/span/input")).click();
        return this;
    }
    public RpageCheckOut continueToCheckOut4(){
      eComerce.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/p/button/span")).click();
        return this;
    }
    public Rpayment checkOutFinal(){
        continueToCheckOut2();
        continueToCheckOut3();
        terms();
        continueToCheckOut4();
        return new Rpayment(eComerce);
    }
}
