import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class WMainPage extends AbstractPage {

    private Resources resources = new Resources();
    private SelenideElement searchField = $x("//input[@type='search']");
    private SelenideElement searchButton = $x("//button[.='Search']");
    private ElementsCollection searchList = $$x("//div[@class='search-list']");
    private ElementsCollection relatedContent = $$x("//div[@class= 'related-content-products']//*[@class = 'product-title']");
    private ElementsCollection concreateSearchResults = $$x("//div[@class = 'product-list-wrapper']//section[@class='product-item ']");


    public Resources getResources() {
        return resources;
    }

    @Override
    protected SelenideElement getHeader() {
        return null;
    }

    public void enterTextToSearch(String search) {
        searchField.sendKeys(search);

    }

    public void checkSearchResult(String searchResultContains) {
        if (searchResultContains.isEmpty()) {
            searchList.filterBy(Condition.visible).shouldHaveSize(0);
        } else {
            searchList.filterBy(Condition.visible).forEach(element -> element.shouldHave(Condition.text(searchResultContains)));
        }

    }


    public void checkRelatedContent(String relatedContentContains) {
        if (relatedContentContains.isEmpty()) {
            relatedContent.filterBy(Condition.visible).shouldHaveSize(0);
        } else {
            relatedContent.filterBy(Condition.visible).forEach(element -> element.shouldHave(Condition.text(relatedContentContains)));
        }
    }

    public void pressSearchButton() {
        searchButton.click();
    }

    public void checkConcreteSearchResultsCount(int expectedCount) {
        concreateSearchResults.shouldHaveSize(expectedCount);
    }

    public void concreteSearchResultsContainsAddToCartButton() {
        concreateSearchResults.findBy(Condition.text("Add to cart"));
    }
}
