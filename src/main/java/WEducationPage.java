import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class WEducationPage extends AbstractPage {

    ElementsCollection educationThemes = $$x(".//");


    @Override
    protected SelenideElement getHeader() {
        return $x("/p[.='Education']");
    }


    public boolean educationThemesElementsIsVisible(String... names) {
        educationThemes.shouldBe(CollectionCondition.textsInAnyOrder(names));
        return true;
    }

    public int getEducationThemesCount() {
        return educationThemes.size();
    }


}
