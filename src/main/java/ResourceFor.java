import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;


public enum ResourceFor {

    Students,
    Instructors,
    Researchers,
    Professionals,
    Librarians,
    Institutions,
    Authors,
    Resellers,
    Corporations,
    Societies;


    private SelenideElement element;

    private ResourceFor() {
        this.element = $x(
                format("//div[@class ='container resources-for-blocks-wrapper component-wrapper']//a[@class ='yCmsComponent' and text() = 's%']",
                        this.name()));
    }

    public static void isAllVisible() {
        for (ResourceFor aResourceFor : ResourceFor.values()) {
            aResourceFor.element.shouldBe(Condition.exist).shouldBe(Condition.visible);
        }
    }

    public void click() {
        this.element.click();
    }

}


