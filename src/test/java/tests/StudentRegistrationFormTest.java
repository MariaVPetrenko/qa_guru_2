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
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void formTest() {
        open("https://demoqa.com/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue("Harry");
        $("#lastName").setValue("Potter");
        $("#userEmail").setValue("hp@example.com");
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue("9643825617");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__day--014").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbies-checkbox-1").parent().click();
        $("#uploadPicture").scrollTo();
        File imgFile = new File("./src/test/resources/5b45cb62c051e602a568cd15.png");
        $("#uploadPicture").uploadFile(imgFile);
        //$("#uploadPicture").uploadFromClasspath("/5b45cb62c051e602a568cd15.png"); альтернативный вариант
        $("#currentAddress").setValue("Current address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
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
