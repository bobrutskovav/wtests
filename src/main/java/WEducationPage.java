import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class WEducationPage extends AbstractPage {

    ElementsCollection educationThemes = $$x("//div[@class = 'side-panel']//li");


    @Override
    protected SelenideElement getHeader() {
        return $x("//h1[.='Education']");
    }


    public void educationThemesElementsIsVisible(String... names) {
        educationThemes.shouldBe(CollectionCondition.textsInAnyOrder(names));
    }

    public void checkEducationThemesCount(int expectedCount) {
        educationThemes.shouldHaveSize(expectedCount);
    }


}
