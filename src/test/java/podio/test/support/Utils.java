package podio.test.support;

import org.junit.Assert;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by msheliah.
 */
public class Utils{

    private Properties prop;

    public static Map<String, String> getCredentials(Boolean validity){
        Map<String, String> credentials = new HashMap<String, String>();
        credentials.put("login", System.getProperty("login"));
        credentials.put("pass", System.getProperty("pass"));
        if (credentials.get("login").equals("no") | credentials.get("pass").equals("no")){
            //TODO add possibility to get Credentials from db, googledoc or any other place
            Properties prop = new Properties();
            InputStream input = null;

            try {
                input = new FileInputStream(new File(System.getProperty("cred")));
                prop.load(input);
                credentials.put("login", prop.getProperty("login"));
                credentials.put("pass", prop.getProperty("pass"));

            } catch (IOException ex) {
                Assert.fail("File can't be found, please specify login/pass as a parameter or check file path" + ex.getMessage());
            } finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if(!validity){
            credentials.put("pass", "pass");
        }
        return credentials;
    }

    public static Map<String, Object> getAnswers() {
        Map<String, Object> questios = new HashMap<String, Object>();
        questios.put("question-answer[0]", "Answer with number" + Math.random());
        questios.put("question-answer[1]", "Answer with number" + Math.random());
        return questios;
    }
}
