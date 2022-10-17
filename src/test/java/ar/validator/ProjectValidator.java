package ar.validator;

import api.model.Project.ProjectResponse;
import com.crowdar.api.rest.APIManager;
import org.testng.Assert;
import services.ProjectService;

public class ProjectValidator {
    public void valildate() {
        ProjectResponse[] response = (ProjectResponse[]) APIManager.getLastResponse().getResponse();
        for (ProjectResponse project : response) {
            Assert.assertNotNull(project.getId(), "Se encontro un id de projecto null");
        }
    }

    public void validateName(String name) {
        ProjectResponse project = (ProjectResponse) APIManager.getLastResponse().getResponse();
        Assert.assertEquals(name, project.getName(), "El nombre no es el esperado");
    }
}
