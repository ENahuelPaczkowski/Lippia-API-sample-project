package ar.validator;

import api.model.workspaces.WorkspacesResponse;
import com.crowdar.api.rest.APIManager;
import org.testng.Assert;

public class WorkspaceValidator {
        public static void validate(){
            WorkspacesResponse[] response = (WorkspacesResponse[]) APIManager.getLastResponse().getResponse();
            for (WorkspacesResponse workspace : response) {
                Assert.assertNotNull(workspace.getId(),"El campo ID del workspace es nulo");
            }
        }
}
