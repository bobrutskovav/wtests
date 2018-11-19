import com.codeborne.selenide.WebDriverRunner;
import org.junit.Assert;

public abstract class AbstractPage {

    String currentUrl;

    public AbstractPage() {
        currentUrl = WebDriverRunner.currentFrameUrl();
    }

    public void checkCurrentUrlIs(String url) {
        Assert.assertEquals("Current url is not valid", url, currentUrl);
    }
}
