import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TopMenu {

    SelenideElement resourcesLink = $x("//a[text()='Resources']");
    SelenideElement subjectsLink = $x("//a[text()='Subjects']");
    SelenideElement aboutLink = $x("//a[text()='About']");


    public boolean topMenuIsPresent() {
        resourcesLink.shouldBe(Condition.visible);
        subjectsLink.shouldBe(Condition.visible);
        aboutLink.shouldBe(Condition.visible);
        return true;
    }

}
