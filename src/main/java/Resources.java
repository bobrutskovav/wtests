import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;

public class Resources {
    ElementsCollection resourcesForElements = $$x("//a[@class ='resources-for-block-title']");


    public boolean resourceElementsIsVisible(String... names) {
        resourcesForElements.shouldBe(CollectionCondition.textsInAnyOrder(names));
        return true;
    }

    public int getResourcesCount() {
        return resourcesForElements.size();
    }

    public void clickOn(String resourceName) {
        resourcesForElements.find(Condition.exactText(resourceName)).click();
    }


}
