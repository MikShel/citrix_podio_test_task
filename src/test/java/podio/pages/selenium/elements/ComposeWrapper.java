package podio.pages.selenium.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Form;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by msheliah.
 */
@Name("Activity stream input form")
@Block(@FindBy(css = "div.composer-wrapper"))
public class ComposeWrapper extends HtmlElement {

    @Name("Post text input")
    @FindBy(css = "textarea#status_value")
    public TextInput postTextInput;

    @Name("File attach button")
    @FindBy(css = "li.file")
    public Button fileAttachButton;

    @Name("Link attach button")
    @FindBy(css = "li.link")
    public Button linkAttachButton;

    @Name("Link attach input")
    @FindBy(css = "input.stream-embed-url")
    public TextInput linkAttachInput;

    @Name("Question attach button button")
    @FindBy(css = "li.question")
    public Button questionAttachButton;

    @Name("Question attach form")
    @FindBy(css = "div.question-attach-box")
    public Form questionAttachForm;

    @Name("Space Switcher Button")
    @FindBy(css = "div.spaceswitcher-button")
    public Button spaceSwitcherButton;

    @Name("Space Switcher search input")
    @FindBy(css = "input.spaceswitcher-searchinput")
    public TextInput spaceSwitcherSearchInput;

    @Name("Share Button")
    @FindBy(css = "input.status-submit[name=\"commit\"]")
    public Button shareButton;

}
