package ar.steps;

import api.model.Project.ProjectResponse;
import ar.validator.ProjectValidator;
import com.crowdar.api.rest.APIManager;
import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import services.ProjectService;
import services.ProjectsService;

import java.util.Random;

public class ProjectSteps extends PageSteps {

    ProjectValidator validator = new ProjectValidator();

    @Then("se valida que el id no sea null")
    public void seValidaQueElIdNoSeaNull() { validator.valildate(); }

    @Given("obtengo mi id workspace")
    public void obtengoMiIdWorkspace() {
        ProjectsService.ID_WSPACE.set("633f5b49648048064054ae2a");
    }

    @Given("se toma el id de un projecto '(.*)'")
    public void seTomaElIdDeUnProjectoDeLaRespuesta(String operation) {
        if ("GET".equals(operation)){
            ProjectResponse[] response = (ProjectResponse[]) APIManager.getLastResponse().getResponse();
            ProjectResponse project = response[new Random().nextInt(response.length)];
            ProjectService.ID_PROJECT.set(project.getId());
        }
//        if ("POST".equals(operation)){
//            ProjectResponse project = (ProjectResponse) APIManager.getLastResponse().getResponse();
//            ProjectService.ID_PROJECT.set(project.getId());
//        }
        if ("PUT".equals(operation)){
//            ProjectResponse[] response = (ProjectResponse[]) APIManager.getLastResponse().getResponse();
//            ProjectResponse project = response[0];
//            System.out.println(project.getId());
            ProjectService.ID_PROJECT.set("634b5a3ae26bc30e1bc69812");
        }
    }

    @And("un nombre '(.*)'")
    public void unNombreName(String name) {
        ProjectService.PROJECT_NAME.set(name);
    }

    @And("se valida que el nombre fue editado '(.*)")
    public void seValidaQueElNombreFueEditadoName(String name) {
        validator.validateName(name);
    }

    @Given("un id invalido")
    public void unIdInvalido() {
        ProjectService.ID_PROJECT.set("634b5a3ae26bc30e1bc698");
    }
}
