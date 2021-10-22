package EcomercePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RpageCadastro extends RbasePage{

    public RpageCadastro(WebDriver eComerce) {
    super(eComerce);
    }

    public RpageCadastro sigin(){
        eComerce.findElement(By.linkText("Sign in")).click();
        return this;
    }

    public RpageCadastro newUsuario(String email){
        eComerce.findElement(By.id("email_create")).sendKeys(email);
        return this;
    }

    public RpageCadastro criarUmaConta(){
        eComerce.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div" +
                "/div[1]/form/div/div[3]/button/span")).click();
        return this;
    }

    public RpageCadastro firstName(String firtName){
        eComerce.findElement(By.id("customer_firstname")).sendKeys(firtName);
    return this;
    }

    public RpageCadastro lastName(String lastName){
        eComerce.findElement(By.id("customer_lastname")).sendKeys(lastName);
        return this;
    }

    public RpageCadastro passWord(String passWord){
        eComerce.findElement(By.id("passwd")).sendKeys(passWord);
        return this;
    }

    public RpageCadastro address1 (String endereço){
        eComerce.findElement(By.id("address1")).sendKeys(endereço);
        return this;
    }

    public RpageCadastro city(String cidade){
        eComerce.findElement(By.id("city")).sendKeys(cidade);
        return this;
    }

    public RpageCadastro selectState(String estado){
        WebElement State = eComerce.findElement(By.id("id_state"));
        new Select(State).selectByVisibleText(estado);
        return this;
    }

    public RpageCadastro codePostal(String code){
        eComerce.findElement(By.id("postcode")).sendKeys(code);
        return this;
    }

    public RpageCadastro infAdd(String infAdd){
        eComerce.findElement(By.id("other")).sendKeys(infAdd);
        return this;
    }

    public RpageCadastro tel(String cel){
        eComerce.findElement(By.id("phone_mobile")).sendKeys(cel);
        return this;
    }

    public RpageCadastro endAlternativo(String emailAlternativo){
        eComerce.findElement(By.id("alias")).clear();
        eComerce.findElement(By.id("alias")).sendKeys(emailAlternativo);
        return this;
    }

    public RpageCadastro register(){
        eComerce.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[4]/button")).click();
        return this;
    }

    public RpageLogin clicarSignin(){
        eComerce.findElement(By.linkText("Sign in")).click();
     return new RpageLogin(eComerce);
    }
}
