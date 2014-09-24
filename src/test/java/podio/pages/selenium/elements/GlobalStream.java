package podio.pages.selenium.elements;

import org.openqa.selenium.support.FindBy;
import podio.test.support.CommonSteps;
import podio.test.support.Utils;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by msheliah.
 */
@Name("Global Stream block")
@Block(@FindBy(css = "div#global_stream"))
public class GlobalStream extends HtmlElement {

    private StreamActivityComposer composer;

    private StreamPost streamPost;
    CommonSteps commonSteps = new CommonSteps();


    public void chooseMenu(String menu){
        commonSteps.waitForElementPresent(composer);
        switch (menu){
            case "Status":
                commonSteps.clickOn(composer.statusButton);
                commonSteps.shouldSeeElement(composer.composeWrapper.postTextInput);
                break;
        }
    }

    public void createPost(String attachment, String space, String text) {
        commonSteps.clickOn(composer.composeWrapper.postTextInput);
        commonSteps.inputText(composer.composeWrapper.postTextInput, text);
        switch (attachment){
            case ("no"):
                break;
            case ("link"):
                commonSteps.clickOn(composer.composeWrapper.linkAttachButton);
                commonSteps.inputText(composer.composeWrapper.linkAttachInput, System.getProperty("url"));
                commonSteps.clickOn(composer.composeWrapper.linkAttachedButton);
                break;
            case ("question"):
                commonSteps.clickOn(composer.composeWrapper.questionAttachButton);
                commonSteps.fill(composer.composeWrapper.questionAttachForm, Utils.getQuestions());
                break;
        }
        commonSteps.clickOn(composer.composeWrapper.spaceSwitcherButton);
        commonSteps.inputText(composer.composeWrapper.spaceSwitcherSearchInput, space);
        commonSteps.clickOn(composer.composeWrapper.spaceSwitcherSearchReult);
        commonSteps.waitForTextAppearInElement(composer.composeWrapper.postTextInput, "");
    }

    public void checkNewPost(String postText, String attachment) {
        commonSteps.waitForElementWithText("div.stream-post", postText);
        switch (attachment){
            case ("no"):
                break;
            case ("link"):
                commonSteps.shouldSeeElementWithLink(streamPost.attachedLink, System.getProperty("url"));
                break;
            case ("question"):
                commonSteps.shouldSeeElement(streamPost.questionsBlock);
                break;
        }
    }
}