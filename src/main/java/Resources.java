import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public class Resources {

    private ElementsCollection resourcesForElements = $$x("//a[@class ='resources-for-block-title']");


    public void resourceElementsIsVisible(String... names) {
        resourcesForElements.shouldBe(CollectionCondition.textsInAnyOrder(names));
    }

    public void checkResourcesCount(int expectedCount) {
        resourcesForElements.shouldHaveSize(expectedCount);
    }

    public void clickOn(String resourceName) {
        resourcesForElements.find(Condition.exactText(resourceName)).click();
    }


}
