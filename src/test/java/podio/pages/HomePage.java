package podio.pages;

/**
 * Created by msheliah.
 */
public interface HomePage {
    void checkSuccessfulLogin();

    void createPost(String attachment, String space, String text);

    void checkThatPostAppear(String attach);
}
