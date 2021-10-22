package EcomercePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RpageLogin extends RbasePage {
    public RpageLogin(WebDriver eComerce) {
        super(eComerce);
    }

    public RpageLogin clickSignIn(){
        eComerce.findElement(By.linkText("Sing in")).click();
    return this;
    }

    public RpageLogin typeUser(String login){
        eComerce.findElement(By.id("email")).sendKeys(login);
      return this;
    }

    public RpageLogin typePasswd(String passwd){
        eComerce.findElement(By.id("passwd")).sendKeys(passwd);
    return this;
    }

    public RpageLogin clickSigin(){
        eComerce.findElement(By.id("SubmitLogin")).click();
    return this;
    }

    public RpageInicial loginUnico(String login, String passwd){
        typeUser(login);
        typePasswd(passwd);
        clickSigin();
     return new RpageInicial(eComerce);
    }


}
