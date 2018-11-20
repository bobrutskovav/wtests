import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


public class UITests {

    private static final String studentsHref = "https://www.wiley.com/enru/students";

    @BeforeAll
    public static void operBrowser() {
        Configuration.startMaximized = true;
        Selenide.open("https://www.wiley.com/WileyCDA");
    }

    private static Stream<Arguments> stringResourceNameProvider() {
        return Stream.of(Arguments
                .of((Object) new String[]{"Students", "Instructors", "Researchers", "Professionals", "Librarians",
                        "Institutions", "Authors", "Resellers", "Corporations", "Societies", "Journalists"}));
    }


    private static Stream<Arguments> stringEducationThemesProvider() {
        return Stream.of(Arguments.of((Object) new String[]{"Information & Library Science",
                "Education & Public Policy",
                "K12 General",
                "Higher Education General",
                "Vocational Technology",
                "Conflict Resolution & Mediation (School settings)",
                "Curriculum Tools General",
                "Special Educational Needs",
                "Theory of Education",
                "Education Special Topics",
                "Educational Research & Statistics",
                "Literacy & Reading",
                "Classroom Management"}));
    }

    @ParameterizedTest(name = "run #{index} with [{arguments}]")
    @MethodSource({"stringResourceNameProvider", "stringEducationThemesProvider"})
    public void firstUITest(String[] resourceNames, String[] educationThemes) {
        WMainPage mainPage = new WMainPage();
        assertTrue(mainPage.getTopMenu().topMenuIsPresent());
        Resources resources = mainPage.getResources();
        assertEquals(resources.getResourcesCount(), 11);
        assertTrue(resources.resourceElementsIsVisible(resourceNames));
        resources.clickOn("Students");
        WStudentsPage studentsPage = new WStudentsPage();
        assertTrue(studentsPage.checkHeaderIsPresent());
        assertEquals(studentsPage.getCurrentUrl(), studentsHref);
        assertTrue(studentsPage.wileyPlusLinkIsCorrect());
        studentsPage.getTopMenu().clickOnResource("E-L", "Education");
        WEducationPage educationPage = new WEducationPage();
        assertTrue(educationPage.checkHeaderIsPresent());
        assertTrue(educationPage.educationThemesElementsIsVisible(educationThemes));
        educationPage.getTopMenu().clickToWileyLogo();
        assertEquals(0, mainPage.getSearchResult().size());
        assertTrue(mainPage.checkHeaderIsPresent());
        mainPage.enterTextToSearch("Math");
        List<String> results = mainPage.getSearchResult();


    }


}
