import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UITests {

    private static final String studentsHref = "https://www.wiley.com/en-ru/students";

    @BeforeAll
    public static void operBrowser() {
        Configuration.startMaximized = true;
        Selenide.open("https://www.wiley.com/WileyCDA");
    }

    private static Stream<Arguments> stringValuesProvider() {
        return Stream.of(Arguments
                .of(new String[]{"Students", "Instructors", "Researchers", "Professionals", "Librarians",
                                "Institutions", "Authors", "Resellers", "Corporations", "Societies", "Journalists"},

                        new String[]{"Information & Library Science",
                                "Education & Public Policy",
                                "K-12 General",
                                "Higher Education General",
                                "Vocational Technology",
                                "Conflict Resolution & Mediation (School settings)",
                                "Curriculum Tools- General",
                                "Special Educational Needs",
                                "Theory of Education",
                                "Education Special Topics",
                                "Educational Research & Statistics",
                                "Literacy & Reading",
                                "Classroom Management"}));
    }




    @ParameterizedTest(name = "run #{index} with [{arguments}]")
    @MethodSource("stringValuesProvider")
    public void firstUITest(String[] resourceNames, String[] educationThemes) {
        WMainPage mainPage = new WMainPage();
        mainPage.getTopMenu().topMenuIsPresent();
        Resources resources = mainPage.getResources();
        resources.checkResourcesCount(11);
        resources.resourceElementsIsVisible(resourceNames);
        resources.clickOn("Students");
        WStudentsPage studentsPage = new WStudentsPage();
        studentsPage.checkHeaderIsPresent();
        assertEquals(studentsHref, studentsPage.getCurrentUrl());
        studentsPage.wileyPlusLinkIsCorrect();
        studentsPage.getTopMenu().clickOnSubject("E-L", "Education");
        WEducationPage educationPage = new WEducationPage();
        educationPage.checkHeaderIsPresent();
        educationPage.educationThemesElementsIsVisible(educationThemes);
        educationPage.getTopMenu().clickToWileyLogo();
        mainPage.pressSearchButton();
        mainPage.checkSearchResult("");
        mainPage.checkHeaderIsPresent();
        mainPage.enterTextToSearch("Math");
        mainPage.checkSearchResult("Math");
        mainPage.checkRelatedContent("Math");
        mainPage.pressSearchButton();
        mainPage.checkConcreteSearchResultsCount(10);
        mainPage.concreteSearchResultsContainsAddToCartButton();


    }


}
