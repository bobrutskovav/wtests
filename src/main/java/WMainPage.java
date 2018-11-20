import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.util.ArrayList;
import java.util.List;

public class WMainPage extends AbstractPage {

    private Resources resources = new Resources();
    private SelenideElement searchField = $x("//");
    private SelenideElement searchButton = $x("//");
    private ElementsCollection searchResults = $$x("//");


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

    public List<String> getSearchResult() {
        List<String> results = new ArrayList<>();
        searchResults.forEach(element -> results.add(element.getText()));
        return results;
    }

    public void pressSearchButton() {
        searchButton.click();
    }
}
