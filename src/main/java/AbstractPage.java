import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;


public abstract class AbstractPage {

    private TopMenu topMenu = new TopMenu();

    private String currentUrl;

    public AbstractPage() {
        currentUrl = WebDriverRunner.currentFrameUrl();
    }

    public String getCurrentUrl() {
        return currentUrl;
    }

    public boolean pageContainsLinkWithText(String text) {
        return $x(format("//a[text() ='%s']", text)).isDisplayed();

    }

    public TopMenu getTopMenu() {
        return topMenu;
    }

    public boolean checkHeaderIsPresent() {
        SelenideElement header = getHeader();
        return header == null || header.isDisplayed();

    }

    protected abstract SelenideElement getHeader();
}
