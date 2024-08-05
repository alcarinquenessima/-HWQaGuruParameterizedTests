package tests;

import components.DropDownLocatorForTest;
import components.Languages;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTestsQAguru extends TestBase {

    @ParameterizedTest(name = "Checking links in the Learn dropdown")
    @ValueSource(strings = {
            "Improving technique,Deeper understanding of anatomy,Fellow students,Other resources"
    })
    public void verifySeasonsList(String linkTitles) {
        DropDownLocatorForTest locatorForTest = new DropDownLocatorForTest();
        String[] expectedTitles = linkTitles.split(",");

        locatorForTest.openMainPage()
                .findFirstButton()
                .verifyLinks(expectedTitles);
    }

    @ParameterizedTest(name = "Checking the title in two languages")
    @EnumSource(Languages.class)
    public void verifyTitlesInDifferentLanguages(Languages language) {
    DropDownLocatorForTest locatorForTest = new DropDownLocatorForTest();

    locatorForTest.changeLanguage (language.name())
                  .checkTitleLanguage(language.titlesLanguage);

}

    @ParameterizedTest (name = "Check error on login")
    @CsvSource(value = {
        "Login , password",
        "Login2, password2"
})
    public void errorOnLoginTest (String login, String password) {
    DropDownLocatorForTest locatorForTest = new DropDownLocatorForTest();

    locatorForTest.openLoginPage()
                  .enterWrongDataLogin (login, password)
                  .pressLoginButton ()
                  .checkForErrorMessage ();
}
}