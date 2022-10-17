package services;

import api.model.Project.ProjectResponse;
import com.crowdar.api.rest.Response;
import com.crowdar.core.PropertyManager;

import java.util.HashMap;
import java.util.Map;

public class ProjectsService extends BaseService{

    public static Response get(String jsonName){ return get(jsonName, ProjectResponse[].class, setParams());}

    private static Map<String, String> setParams(){
        Map<String, String> params = new HashMap<>();
        params.put("api-key", PropertyManager.getProperty("api-key"));
        params.put("wSpace", ID_WSPACE.get());
        return params;
    }
}
