import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class TopMenu {

    private SelenideElement resourcesLink = $x("//a[text()='Resources']");
    private SelenideElement subjectsLink = $x("//a[text()='Subjects']");
    private SelenideElement aboutLink = $x("//a[text()='About']");
    private SelenideElement wileyLogo = $x("//");
    //ToDo


    public boolean topMenuIsPresent() {
        resourcesLink.shouldBe(Condition.visible);
        subjectsLink.shouldBe(Condition.visible);
        aboutLink.shouldBe(Condition.visible);
        return true;
    }


    public void clickOnResource(String firstLetters, String nextWord) {
        resourcesLink.click();
        $x(format("//*[.='%s']", firstLetters)).click();
        $x(format("//*[.='%s']", nextWord)).click();
    }

    public void clickToWileyLogo() {
        wileyLogo.click();
    }

}
