package podio.test.support;

import org.openqa.selenium.By;
import org.openqa.selenium.internal.WrapsElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.Form;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;
import static ru.yandex.qatools.htmlelements.matchers.MatcherDecorators.should;
import static ru.yandex.qatools.htmlelements.matchers.MatcherDecorators.timeoutHasExpired;
import static ru.yandex.qatools.htmlelements.matchers.WrapsElementMatchers.exists;
import static ru.yandex.qatools.htmlelements.matchers.WrapsElementMatchers.isDisplayed;

/**
 * Created by msheliah.
 */
public class CommonSteps {

    public static void shouldSeeElement(WrapsElement element) {
        assertThat(element, exists());
        assertThat(element, isDisplayed());
    }

    public static void shouldNotSeeElement(WrapsElement element) {
        assertThat(element, should(not(isDisplayed())).whileWaitingUntil(timeoutHasExpired()));
    }

    public static void shouldSeeElementWithLink(Link link, String linkText) {
        assumeIfElementNotPresent(link);
        assertThat("Ссылка элемента " + link + " не равна ожидаемой", link.getReference(), equalTo(linkText));
    }

    public static void clickOn(WrapsElement element) {
        assumeIfElementNotPresent(element);
        element.getWrappedElement().click();
    }

    public static void assumeIfElementNotPresent(WrapsElement element) {
        assumeThat("Element " + element.toString() + " is not present in dom",
                element, should(exists()).whileWaitingUntil(timeoutHasExpired(5000)));
        assumeThat("Element " + element.toString() + " is not present on page",
                element, should(isDisplayed()).whileWaitingUntil(timeoutHasExpired(5000)));
    }

    public static void clearInput(TextInput input) {
        input.clear();
    }

    public static void inputText(TextInput input, String text) {
        assumeIfElementNotPresent(input);
        clearInput(input);
        input.sendKeys(text);
    }

    public void fill(Form form, Map<String, Object> map) {
        assumeIfElementNotPresent(form);
        form.fill(map);
    }

    public static void waitForElementPresent(WrapsElement element) {
        assertThat(element, should(isDisplayed()).whileWaitingUntil(timeoutHasExpired()));
    }

    public static void waitForElementWithText(String css, String text){
        new WebDriverWait(Browser.getDriver(), 30)
                .until(ExpectedConditions.textToBePresentInElementLocated(
                        By.cssSelector(css), text));
    }

    public static void waitForTextAppearInElement(TextInput element, String text){
        assertThat(element.getText(), should(equalTo(text)).whileWaitingUntil(timeoutHasExpired()));
    }

}


