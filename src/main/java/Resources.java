import static com.codeborne.selenide.Selenide.$$x;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

public class Resources {

    private ElementsCollection resourcesForElements = $$x("//a[@class ='resources-for-block-title']");


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
