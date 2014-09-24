package podio.test.support;

import ch.lambdaj.Lambda;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsElement;
import ru.yandex.qatools.htmlelements.element.Form;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;
import static ru.yandex.qatools.htmlelements.matchers.MatcherDecorators.should;
import static ru.yandex.qatools.htmlelements.matchers.MatcherDecorators.timeoutHasExpired;
import static ru.yandex.qatools.htmlelements.matchers.WrapsElementMatchers.exists;
import static ru.yandex.qatools.htmlelements.matchers.WrapsElementMatchers.isDisplayed;

public class CommonSteps {


    public static void shouldSeeElement(WrapsElement element) {
        assertThat(element, exists());
        assertThat(element, isDisplayed());
    }

    public static void shouldNotSeeElement(WrapsElement element) {
        assertThat(element, should(not(isDisplayed())).whileWaitingUntil(timeoutHasExpired()));
    }

    public static void shouldSeeElementWithText(WrapsElement element, String text) {
        assumeIfElementNotPresent(element);
        assertThat("Текст элемента " + element + " не равен ожидаемому",
                element.getWrappedElement().getText(), equalTo(text));
    }

    public void shouldSeeElementWithAttributeValue(WrapsElement element, String attribute, String value) {
        assumeIfElementNotPresent(element);
        assertThat(attribute + " элемента " + element + " не равен ожидаемому",
                element.getWrappedElement().getAttribute(attribute), equalTo(value));
    }

    public static void shouldSeeNotEmptyListOfElements(List<? extends WrapsElement> elements) {
        assertThat("Expect to see not empty list of elements " + elements,
                elements,
                not(empty())
        );
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

    public static void waitForElementNotPresent(WrapsElement element) {
        assertThat(element, should(not(isDisplayed())).whileWaitingUntil(timeoutHasExpired()));
    }

    public static void selectOption(Select select, String option) {
        assumeIfElementNotPresent(select);
        List<String> extract =
                Lambda.extract(select.getOptions(), Lambda.on(WebElement.class).getText());

        assertThat(extract, Matchers.hasItem(option));
        select.selectByVisibleText(option);
        assertThat(select.getFirstSelectedOption().getText(), Matchers.equalTo(option));
    }
}


