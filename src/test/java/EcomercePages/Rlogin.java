package EcomercePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Rlogin extends RbasePage {

    public Rlogin(WebDriver eComerce) {
        super(eComerce);
    }

    public RpageLogin clicarSignin(){
        eComerce.findElement(By.linkText("Sign in")).click();

        return new RpageLogin(eComerce);
    }



}
