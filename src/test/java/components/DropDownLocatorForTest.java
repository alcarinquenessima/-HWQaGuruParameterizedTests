package components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DropDownLocatorForTest {
    private final SelenideElement buttonForLearn =  $$("a.nav-link").findBy(text("Learn"));
    private final SelenideElement titleOfThePage =   $(".entry-title");
    private final ElementsCollection links = $$(".dropdown-menu .dropdown-item");
    private final SelenideElement login = $("#email");
    private final SelenideElement password = $("#password");
    private final SelenideElement loginButton = $(".btn-primary");
    private final SelenideElement errorMessage = $(".alert-danger");


    public DropDownLocatorForTest openMainPage (){
        open("");
        return this;
    }
    public DropDownLocatorForTest findFirstButton () {
        buttonForLearn.hover();
        return this;
    }
    public void  verifyLinks(String[] expectedTitles) {
        for (int i = 0; i < expectedTitles.length; i++) {
            links.get(i).click(); // Клик по ссылке
            titleOfThePage.shouldHave(text(expectedTitles[i]));

            back();
            buttonForLearn.hover();
        }
    }

    public DropDownLocatorForTest changeLanguage (String value) {
        open(value.toLowerCase() + "/category/technique");
        return this;
    }
    public void checkTitleLanguage (String value) {
        titleOfThePage.shouldHave(text(value));
    }
    public DropDownLocatorForTest openLoginPage () {
        open("/login");
        return this;
    }
    public DropDownLocatorForTest enterWrongDataLogin (String loginTest, String passwordTest) {
        login.click();
        login.setValue(loginTest);
        password.click();
        password.setValue(passwordTest);

        return this;
    }
    public DropDownLocatorForTest pressLoginButton () {
        loginButton.shouldHave(text("Login")).click();
        return this;
    }
    public void checkForErrorMessage () {
        errorMessage.shouldHave(text("These credentials do not match our records"));
    }
}
