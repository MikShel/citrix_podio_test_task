package podio.pages.selenium.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by msheliah.
 */
@Name("Global Stream block")
@Block(@FindBy(css = "div#global_stream"))
public class GlobalStream extends HtmlElement {


}