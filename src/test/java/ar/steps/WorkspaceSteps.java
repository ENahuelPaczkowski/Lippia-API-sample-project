package ar.steps;

import ar.validator.WorkspaceValidator;
import com.crowdar.core.PageSteps;
import com.crowdar.core.PropertyManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import services.BaseService;

public class WorkspaceSteps extends PageSteps {

    @Given("Mi cuenta creada en clockify y mi X-Api-Key geneada")
    public void miCuentaCreadaEnClockifyYMiXApiKeyGeneada() {
        BaseService.API_KEY.set(PropertyManager.getProperty("api-key"));
    }

    @Then("Obtengo los datos de mi Workspace")
    public void obtengoLosDatosDeMiWorkspace() {
        WorkspaceValidator.validate();
    }

    @Given("X-Api-Key invalido")
    public void xApiKeyInvalido() {
        BaseService.API_KEY.set("NDRmZWUwYzEtOTZhMS00NDk5LWJkZWItY2FiNmY1MjQ3NGN");
    }
}
