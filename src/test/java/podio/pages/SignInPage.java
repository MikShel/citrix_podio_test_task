package podio.pages;

import java.util.Map;

/**
 * Created by msheliah.
 */
public interface SignInPage {

    void fillCredentials (Map<String, String> credentials);

    void submitCredentials();

    void checkFailLogin();
}
