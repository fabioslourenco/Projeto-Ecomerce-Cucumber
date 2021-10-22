package Tests;

import EcomercePages.RpageCadastro;
import EcomercePages.Rweb;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "src/test/java/Resources/FluxoExcessaoCadastro.csv")

public class CadastroEcomerce {

    private WebDriver eComerce;
    private String novoEmail = "fabio_l_silv" + System.nanoTime() + "@gmail.com";
    private String alternativeEmail = "fabioslouren@gmail.com";
    private String mensagem51;
    @Before
    public void acessoNavegador(){
        eComerce = Rweb.createChrome();
    }

    @Test
    public void cadastroEcomerceFluxoFeliz(){
        new RpageCadastro(eComerce)
                .sigin()
                .newUsuario(novoEmail)
                .criarUmaConta()
                .firstName("Fábio")
                .lastName("Lourenco Silva")
                .passWord("07118")
                .address1("street woodfield dr 523")
                .city("Auburn")
                .selectState("Alabama")
                .codePostal("36849")
                .infAdd("house one")
                .tel("34999998880")
                .endAlternativo(alternativeEmail)
                .register()
        ;
    }

    @Test
    public void fluxoExcessaoNomeIncorreto(@Param(name="nome")String nome, @Param(name="mensagem1")String mensagem){
        new RpageCadastro(eComerce)
                .sigin()
                .newUsuario(novoEmail)
                .criarUmaConta()
                .firstName(nome)
                .lastName("Lourenco Silva")
                .passWord("07118")
                .address1("street woodfield dr 523")
                .city("Auburn")
                .selectState("Alabama")
                .codePostal("36849")
                .infAdd("house one")
                .tel("34999998880")
                .endAlternativo(alternativeEmail)
                .register();
        WebElement msg = eComerce.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/ol/li"));
        String msgApresentada = msg.getText();
        Assert.assertEquals(mensagem, msgApresentada);
    }

    @Test
    public void fluxoExcessaoSobreNomeIncorreto(@Param(name="sobreNome")String sobreNome, @Param(name="mensagem2")String mensagem2){
        new RpageCadastro(eComerce)
                .sigin()
                .newUsuario(novoEmail)
                .criarUmaConta()
                .firstName("Fábio")
                .lastName(sobreNome)
                .passWord("07118")
                .address1("street woodfield dr 523")
                .city("Auburn")
                .selectState("Alabama")
                .codePostal("36849")
                .infAdd("house one")
                .tel("34999998880")
                .endAlternativo(alternativeEmail)
                .register();
        WebElement msg = eComerce.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/ol/li"));
        String msgApresentada = msg.getText();
        Assert.assertEquals(mensagem2, msgApresentada);
    }

    @Test
     public void fluxoExcessaoEndereçoIncorreto(@Param(name="endereço")String endereço, @Param(name="mensagem3")String mensagem3){
         new RpageCadastro(eComerce)
                 .sigin()
                 .newUsuario(novoEmail)
                 .criarUmaConta()
                 .firstName("Fábio")
                 .lastName("Lourenco Silva")
                 .passWord("07118")
                 .address1(endereço)
                 .city("Auburn")
                 .selectState("Alabama")
                 .codePostal("36849")
                 .infAdd("house one")
                 .tel("34999998880")
                 .endAlternativo(alternativeEmail)
                 .register();
         WebElement msg = eComerce.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/ol/li"));
         String msgApresentada = msg.getText();
         Assert.assertEquals(mensagem3, msgApresentada);
     }

     @Test
     public void fluxoExcessaoCidadeIncorreta(@Param(name="cidade")String cidade, @Param(name="mensagem4")String mensagem4){
         new RpageCadastro(eComerce)
                 .sigin()
                 .newUsuario(novoEmail)
                 .criarUmaConta()
                 .firstName("Fábio")
                 .lastName("Lourenco Silva")
                 .passWord("07118")
                 .address1("street woodfield dr 523")
                 .city(cidade)
                 .selectState("Alabama")
                 .codePostal("36849")
                 .infAdd("house one")
                 .tel("34999998880")
                 .endAlternativo(alternativeEmail)
                 .register();
         WebElement msg = eComerce.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/ol/li"));
         String msgApresentada = msg.getText();
         Assert.assertEquals(mensagem4, msgApresentada);

     }

     @Test
     public void fluxoExcessaoEstadoIncorreto(){
         new RpageCadastro(eComerce)
                 .sigin()
                 .newUsuario(novoEmail)
                 .criarUmaConta()
                 .firstName("Fábio")
                 .lastName("Lourenco Silva")
                 .passWord("07118")
                 .address1("street woodfield dr 523")
                 .city("Auburn")
                 .selectState("-")
                 .codePostal("36849")
                 .infAdd("house one")
                 .tel("34999998880")
                 .endAlternativo(alternativeEmail)
                 .register();
         WebElement msg = eComerce.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/ol/li"));
         String msgApresentada = msg.getText();
         Assert.assertEquals("This country requires you to choose a State.", msgApresentada);
     }

     @Test
     public void fluxoExcessaoZipCodeIncorreto(@Param(name="code")String zipCode, @Param(name="mensagem5.1")String mensagem51,@Param(name="mensagem5.2")String mensagem52){

         new RpageCadastro(eComerce)
                 .sigin()
                 .newUsuario(novoEmail)
                 .criarUmaConta()
                 .firstName("Fábio")
                 .lastName("Lourenco Silva")
                 .passWord("07118")
                 .address1("street woodfield dr 523")
                 .city("Auburn")
                 .selectState("Alabama")
                 .codePostal(zipCode)
                 .infAdd("house one")
                 .tel("34999998880")
                 .endAlternativo(alternativeEmail)
                 .register();
         WebElement msg = eComerce.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/ol/li"));
         String msgApresentada = msg.getText();
         Assert.assertEquals(mensagem51 + "'" + mensagem52, msgApresentada);
         }



    @After
    public void close(){
        eComerce.quit();
    }
}
