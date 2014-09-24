package podio.pages.selenium.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by msheliah.
 */
@Name("Global Stream block")
@Block(@FindBy(css = "div.nav-box"))
public class GlobalStream extends HtmlElement {

    @Name("Email input")
    @FindBy(css = "input.email")
    private TextInput emailInput;


}