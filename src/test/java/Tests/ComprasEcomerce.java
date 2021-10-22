package Tests;


import EcomercePages.RpageCadastro;
import EcomercePages.Rweb;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ComprasEcomerce {

    private WebDriver eComerce;

    @Before
    public void AcessoNavegador() {

        eComerce = Rweb.createChrome();
    }

    @Test
    public void comprasSite() {
        new RpageCadastro(eComerce)
        .clicarSignin()
        .loginUnico("fabioloureno412@gmail.com","071198")
        .pesquisarProduto("Printed Chiffon Dress")
        .selecionarProduto("Printed Chiffon Dress")
        .definirProduto("M","color_15")
        .addCarrinho()
        .continueShopping()
        .pesquisarProduto("Faded Short Sleeve T-shirts ")
        .selecionarProduto("Faded Short Sleeve T-shirts")
        .definirProduto("M","color_14")
        .addCarrinho()
        .continueShopping()
        .pesquisarProduto("Blouse")
        .selecionarProduto("Blouse")
        .definirProduto("M","color_8")
        .addMoreOneProduto()
        .addCarrinho()
        .continueToCheckOut()
        .checkOutFinal()
        .metodoPagamento()
        .confirmacaoPagamento();
    }
    @After
    public void close(){
        eComerce.quit();
    }
}