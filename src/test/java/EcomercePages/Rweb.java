package EcomercePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Rweb {
    public static WebDriver createChrome(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\fabio\\OneDrive\\Documentos\\Programação\\Driver\\chromedriver.exe");
        WebDriver eComerce = new ChromeDriver();
        eComerce.manage().timeouts().implicitlyWait(8 , TimeUnit.SECONDS);
        eComerce.manage().window().maximize();
        eComerce.get("http://automationpractice.com/index.php");
        return eComerce;
    }
}
