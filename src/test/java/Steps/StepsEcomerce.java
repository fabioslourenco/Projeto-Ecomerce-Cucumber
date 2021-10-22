package Steps;

import EcomercePages.Rlogin;
import EcomercePages.RpageCadastro;
import EcomercePages.Rweb;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StepsEcomerce {

    private WebDriver eComerce;
    private String emailCriado = "fabiosilva000@gmail.com";
    private String emailNaoCriado = "fabio_l_silva" + System.nanoTime() + "@gmail.com";



    @Given("que acessei a aplicação")
    public void queAceseiAAplicação() {
        eComerce = Rweb.createChrome();
    }

    @Given("cliquei em sign in")
    public void cliqueiEmSignIn() {
        new Rlogin(eComerce)
                .clicarSignin();
    }
    @When("digitar endereço de email_criado")
    public void digitarEndereçoDeEmailCriado() {
        new RpageCadastro(eComerce)
                .newUsuario(emailCriado);
    }

    @When("digitar endereço de email_NãoCriado")
    public void digitarEndereçoDeEmailNaoCriado() {
        new RpageCadastro(eComerce)
                .newUsuario(emailNaoCriado);
    }

    @When("digitar endereço invalido")
    public void digitarEndereçoInvalido() {
        new RpageCadastro(eComerce)
                .newUsuario("fabioslouren1245");
    }

    @When("clicar em create an account")
    public void clicarEmCreateAnAccount() {
        new RpageCadastro(eComerce)
                .criarUmaConta();
    }
    @Then("usuario é direcionado para tela de cadastro")
    public void usuarioÉDirecionadoParaTelaDeCadastro() {
        WebElement confirmacao = eComerce.findElement(By.xpath("//*[@id=\"submitAccount\"]/span"));
        String tituloConfirmacao = confirmacao.getText();
        Assert.assertEquals("Register", tituloConfirmacao);
    }

    @Then("aplicação exibe msg de erro")
    public void aplicaçãoExibeMsgDeErro() {
        WebElement msgErro = eComerce.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li"));
        String respostaMsg = msgErro.getText();
        Assert.assertEquals("Invalid email address.", respostaMsg);
    }

    @Then("aplicação acusa erro")
    public void aplicaçãoAcusaErro() {
        WebElement msgErro = eComerce.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li"));
        String respostaMsg = msgErro.getText();
        Assert.assertEquals("Invalid email address.", respostaMsg);
    }

    @When("cadastrar meus dados obrigatórios")
    public void cadastrarMeusDados() {
        new RpageCadastro(eComerce)
                .firstName("Fábio")
                .lastName("Lourenco Silva")
                .passWord("07118")
                .address1("street woodfield dr 523")
                .city("Auburn")
                .selectState("Alabama")
                .codePostal("36849")
                .infAdd("house one")
                .tel("34999998880")
                .endAlternativo("fabiolll@gmail.com")
                .register()
        ;
    }

    @Then("aplicação exibe msg de confirmação")
    public void aplicaçãoExibeMsgDeConfirmação() {
        WebElement confCadastro = eComerce.findElement(By.className("info-account"));
        String msg = confCadastro.getText();
        Assert.assertEquals(
                "Welcome to your account. Here you can manage all of your personal information and orders.", msg);
    }

    @Then("Aplicação acusa email ja cadastrado")
    public void aplicaçãoAcusaEmailJaCadastrado(){
        WebElement msgErro = eComerce.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li"));
        String respostaMsg = msgErro.getText();
        Assert.assertEquals("An account using this email address has already been registered. Please enter a valid password or request a new one.", respostaMsg);
    }

    @When("digitar {string}")
    public void digitar(String name) {
        new RpageCadastro(eComerce)
            .firstName(name)
        ;
    }
    @When("digitar outros dados obrigátorios")
    public void digitarOutrosDadosObrigátorios() {
        new RpageCadastro(eComerce)
                .lastName("Lourenco Silva")
                .passWord("07118")
                .address1("street woodfield dr 523")
                .city("Auburn")
                .selectState("Alabama")
                .codePostal("36849")
                .infAdd("house one")
                .tel("34999998880")
                .endAlternativo("fabiolll@gmail.com")
                .register()
        ;
    }

    @Then("aplicaçao exibe {string}")
    public void aplicaçaoExibe(String mensagem) {
    WebElement msg = eComerce.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/ol/li"));
    String msgApresentada = msg.getText();
    Assert.assertEquals(mensagem, msgApresentada);
    }

    @When("digitar o {string}")
    public void digitarO(String sobreNome) {
        new RpageCadastro(eComerce)
                .lastName(sobreNome);
    }

    @When("incluir outros dados")
    public void incluirOutrosDados() {
        new RpageCadastro(eComerce)
                .firstName("Fábio")
                .passWord("07118")
                .address1("street woodfield dr 523")
                .city("Auburn")
                .selectState("Alabama")
                .codePostal("36849")
                .infAdd("house one")
                .tel("34999998880")
                .endAlternativo("fabiolll@gmail.com")
                .register()
        ;
    }
    @Then("aplicaçao acusa {string}")
    public void aplicaçaoAcusa(String mensagem) {
        WebElement msg = eComerce.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/ol/li"));
        String msgApresentada = msg.getText();
        Assert.assertEquals(mensagem, msgApresentada);
    }

    @When("digitar meu {string}")
    public void digitarMeu(String endereço) {
        new RpageCadastro(eComerce)
                .address1(endereço)
        ;
    }

    @When("dados demais dados obrigatorios")
    public void dadosDemaisDadosObrigatorios() {
        new RpageCadastro(eComerce)
                .firstName("Fábio")
                .lastName("Lourenco Silva")
                .passWord("07118")
                .city("Auburn")
                .selectState("Alabama")
                .codePostal("36849")
                .infAdd("house one")
                .tel("34999998880")
                .endAlternativo("fabiolll@gmail.com")
                .register()
        ;
    }

    @Then("aplicação mostra {string}")
    public void aplicaçãoMostra(String mensagem) {
        WebElement msg = eComerce.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/ol/li"));
        String msgApresentada = msg.getText();
        Assert.assertEquals(mensagem, msgApresentada);
    }

    @When("complemento de dados")
    public void complementoDeDados() {
        new RpageCadastro(eComerce)
                .firstName("Fábio")
                .lastName("Lourenco Silva")
                .passWord("07118")
                .address1("street woodfield dr 523")
                .selectState("Alabama")
                .codePostal("36849")
                .infAdd("house one")
                .tel("34999998880")
                .endAlternativo("fabiolll@gmail.com")
        ;
    }

    @When("digitar cidade {string}")
    public void digitarCidade(String cidade) {
        new RpageCadastro(eComerce)
                .city(cidade)
                .register()
        ;
    }
    @Then("{string} é exibida")
    public void éExibida(String mensagem) {
        WebElement msg = eComerce.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/ol/li"));
        String msgApresentada = msg.getText();
        Assert.assertEquals(mensagem, msgApresentada);
    }

    @When("cadastrar informaçoes")
    public void cadastrarInformaçoes() {
        new RpageCadastro(eComerce)
                .firstName("Fábio")
                .lastName("Lourenco Silva")
                .passWord("07118")
                .address1("street woodfield dr 523")
                .city("Auburn")
                .codePostal("36849")
                .infAdd("house one")
                .tel("34999998880")
                .endAlternativo("fabiolll@gmail.com")
                .register()
        ;
    }
    @When("selecionar estado")
    public void selecionarEstado() {
        new RpageCadastro(eComerce)
            .selectState("-")
            ;
    }
    @Then("msg de erro é apresentada")
    public void msgDeErroÉApresentada() {
        WebElement msg = eComerce.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/ol/li"));
        String msgApresentada = msg.getText();
        Assert.assertEquals("This country requires you to choose a State.", msgApresentada);
    }

    @When("cadastrar informaçoes sem zipCode")
    public void cadastrarInformaçoesSemZipCode() {
        new RpageCadastro(eComerce)
                .firstName("Fábio")
                .lastName("Lourenco Silva")
                .passWord("07118")
                .address1("street woodfield dr 523")
                .city("Auburn")
                .selectState("Alabama")
                .infAdd("house one")
                .tel("34999998880")
                .endAlternativo("fabiolll@gmail.com")
                .register()
        ;
    }
    @When("cadastrar {string}")
    public void cadastrar(String zipCode) {
        new RpageCadastro(eComerce)
                .codePostal(zipCode)
        ;
    }
    @Then("aplicação apresent {string} erro zipCode")
    public void aplicaçãoApresentErroZipCode(String mensagem) {
        WebElement msg = eComerce.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/ol/li"));
        String msgApresentada = msg.getText();
        Assert.assertEquals(mensagem, msgApresentada);
    }

    @After
    public void fecharNavegador(){
        eComerce.quit();
    }

}