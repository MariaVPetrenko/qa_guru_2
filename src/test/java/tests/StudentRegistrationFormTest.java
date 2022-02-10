package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormTest {
    @BeforeAll
    static void beforeAll(){
            Configuration.browserSize = "1920x1080";
    }

        @Test
void formTest () {
        open("https://demoqa.com/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue("Harry");
        $("#lastName").setValue("Potter");
        $("#userEmail").setValue("hp@example.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("9643825617");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__month-select").selectOption("January");
        $(byText("14")).click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").scrollTo();
        $("#uploadPicture").uploadFile(new File("src/test/resources/5b45cb62c051e602a568cd15.png"));
        $("#currentAddress").setValue("Current address");
        $(byText("Select State")).click();
        $(byText("Haryana")).click();
        $(byText("Select City")).click();
        $(byText("Karnal")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Harry Potter"),
                text("hp@example.com"),
                text("Male"),
                text("9643825617"),
                text("14 January,1998"),
                text("Maths"),
                text("Sports"),
                text("5b45cb62c051e602a568cd15.png"),
                text("Current address"),
                text("Haryana Karnal"));
        }
}
