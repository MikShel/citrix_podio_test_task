package podio.pages.selenium.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by msheliah.
 */
@Name("Stream activity composer")
@Block(@FindBy(css = "div#stream-activity-composer"))
public class StreamActivityComposer extends HtmlElement {
    @Name("Status button")
    @FindBy(css = "li.status")
    public Button statusButton;

    public ComposeWrapper composeWrapper;



}
