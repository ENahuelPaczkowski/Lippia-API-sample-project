package services;

import api.model.Project.ProjectResponse;
import com.crowdar.api.rest.Response;
import com.crowdar.core.PropertyManager;

import java.util.HashMap;
import java.util.Map;

public class ProjectService extends BaseService{


    public static final ThreadLocal<String> PROJECT_NAME = new ThreadLocal<>();

    public static Response get(String jsonName){ return get(jsonName, ProjectResponse.class, setParamsId(setParams()));}

    public static Response post(String jsonName){ return post(jsonName, ProjectResponse.class, setParams());}

    public static Response put(String jsonName){ return put(jsonName, ProjectResponse.class, setParamsName(setParamsId(setParams())));}

    private static Map<String, String> setParams(){
        Map<String, String> params = new HashMap<>();
        params.put("api-key", PropertyManager.getProperty("api-key"));
        params.put("wSpace", ID_WSPACE.get());
        return params;
    }

    private static Map<String, String> setParamsId(Map<String, String> params){
        params.put("projectId", ID_PROJECT.get());
        return params;
    }

    private static Map<String, String> setParamsName(Map<String, String> params){
        params.put("name", PROJECT_NAME.get());
        return params;
    }
}
