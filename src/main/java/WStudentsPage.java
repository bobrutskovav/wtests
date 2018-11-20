import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$x;

public class WStudentsPage extends AbstractPage {

    private final String wileyLink = "http://wileyplus.wiley.com/";

    private SelenideElement wileyPLUSLink = $x("//a[text() = 'WileyPLUS']");

    public void wileyPlusLinkIsCorrect() {
        wileyPLUSLink.shouldBe(new Condition("Wiley Plus Condition Checker") {
            @Override
            public boolean apply(Driver driver, WebElement element) {
                return element.isDisplayed() && element.getAttribute("href").equalsIgnoreCase(wileyLink);
            }
        });
    }

    @Override
    protected SelenideElement getHeader() {
        return $x("//p[.='Students']");
    }
}
