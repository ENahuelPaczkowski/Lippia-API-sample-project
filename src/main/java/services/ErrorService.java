package services;

import api.model.ErrorResponse;
import api.model.workspaces.WorkspacesResponse;
import com.crowdar.api.rest.MethodsService;
import com.crowdar.api.rest.Request;
import com.crowdar.api.rest.Response;
import com.crowdar.core.PropertyManager;

import java.util.HashMap;
import java.util.Map;

public class ErrorService extends BaseService {

    public static Response get(String jsonName) {
        return get(jsonName, ErrorResponse.class,setParams());
    }

    private static Map<String, String> setParams() {
        Map<String, String> params = new HashMap<String, String>();
//        params.put("base.url", PropertyManager.getProperty("base.api.url"));
//        params.put("api-key", PropertyManager.getProperty("api-key"));
        params.put("wSpace", ID_WSPACE.get());

        return params;
    }

}
