import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {

    private static final String studentsHref = "https://www.wiley.com/en-ru/students";

    @BeforeAll
    public static void warmUp() {
        Configuration.startMaximized = true;
        Selenide.open("https://www.wiley.com/WileyCDA");
    }

    static Stream<Arguments> stringResourceNameProvider() {
        return Stream.of(Arguments.of((Object) new String[]{"Students", "Instructors", "Researchers", "Professionals", "Librarians",
                "Institutions", "Authors", "Resellers", "Corporations", "Societies", "Journalists"}));
    }

    @ParameterizedTest(name = "run #{index} with [{arguments}]")
    @MethodSource({"stringResourceNameProvider"})
    public void firstUITest(String[] resourceNames) {
        WMainPage mainPage = new WMainPage();
        assertTrue(mainPage.getTopMenu().topMenuIsPresent());
        Resources resources = mainPage.getResources();
        assertEquals(resources.getResourcesCount(), 11);
        assertTrue(resources.resourceElementsIsVisible(resourceNames));
        resources.clickOn("Students");
        WStudentsPage studentsPage = new WStudentsPage();
        assertEquals(studentsPage.getCurrentUrl(), studentsHref);
        assertTrue(studentsPage.wileyPlusLinkIsCorrect());


    }


}
