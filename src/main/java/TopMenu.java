import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class TopMenu {

    private SelenideElement resourcesLink = $x("//a[text()='Resources']");
    private SelenideElement subjectsLink = $x("//a[text()='Subjects']");
    private SelenideElement aboutLink = $x("//a[text()='About']");
    private SelenideElement wileyLogo = $x("//div[@class='yCmsContentSlot logo']");
    //ToDo


    public void topMenuIsPresent() {
        resourcesLink.shouldBe(Condition.visible);
        subjectsLink.shouldBe(Condition.visible);
        aboutLink.shouldBe(Condition.visible);
    }


    public void clickOnSubject(String firstLetters, String nextWord) {
        subjectsLink.hover();
        $x(format("//*[@title = '%s']", firstLetters)).waitUntil(Condition.appear, 2000).click();
        $x(format("//*[@title = '%s']", nextWord)).waitUntil(Condition.visible, 2000)
                .click();
    }

    public void clickToWileyLogo() {
        wileyLogo.click();
    }

}
