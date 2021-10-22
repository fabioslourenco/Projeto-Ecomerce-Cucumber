package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\fabio\\OneDrive\\Documentos\\Programação\\Projetos com Selenium" +
        "\\Workspace\\Compras Ecomerce\\src\\test\\java\\Features\\CadastroUsuárioEcomerce.feature",
                    glue = "Steps",
                    plugin = "pretty",
                    snippets = CucumberOptions.SnippetType.CAMELCASE,
                    dryRun = false)

public class RunnerCucumber {
}
