package podio.pages.selenium.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextBlock;

/**
 * Created by msheliah.
 */
@Name("Stream Blog Post")
@Block(@FindBy(css = "div.stream-post"))
public class StreamPost extends HtmlElement{

    @Name("Post text")
    @FindBy(css = "div.title")
    public TextBlock postText;

    @Name("Questions part")
    @FindBy(css = "div.questions")
    public HtmlElement questionsBlock ;

    @Name("Attached link")
    @FindBy(css = "h4.text-bold > a")
    public Link attachedLink ;
}
