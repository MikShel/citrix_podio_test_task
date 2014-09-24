package podio.test.support;

import java.util.HashMap;
import java.util.Map;

public class Utils{

    public static Map<String, String> getCredentials(Boolean validity){
        Map<String, String> credentials = new HashMap<String, String>();
        credentials.put("login", System.getProperty("login"));
        credentials.put("pass", System.getProperty("pass"));
        if (credentials.get("login").equals("no") | credentials.get("pass").equals("no")){
            //TODO get data from googledoc
            credentials.put("login", "professor@ngcblusqdbkptlwhkkge.com");
            credentials.put("pass", "professor_$ecur3Pwd");
        }
        if(!validity){
            credentials.put("pass", "pass");
        }
        return credentials;
    }

    public static Map<String, Object> getQuestions() {
        Map<String, Object> questios = new HashMap<String, Object>();
        questios.put("question-answer[0]", "Question 1 ?");
        questios.put("question-answer[1]", "Question 2 ?");
        return questios;
    }
}
