import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class TopMenu {

    SelenideElement resourcesLink = $x("//a[text()='Resources']");
    SelenideElement subjectsLink = $x("//a[text()='Subjects']");
    SelenideElement aboutLink = $x("//a[text()='About']");


    public void topMenuIsPresent() {
        resourcesLink.shouldBe(Condition.visible);
        subjectsLink.shouldBe(Condition.visible);
        aboutLink.shouldBe(Condition.visible);
    }

}
