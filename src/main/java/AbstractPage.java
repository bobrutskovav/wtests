import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;


public abstract class AbstractPage {

    TopMenu topMenu = new TopMenu();

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
}
