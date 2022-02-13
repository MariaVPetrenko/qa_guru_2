package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WithPageObjects {
    StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void formTest() {
        studentRegistrationFormPage.openPage()
                .setFirstName("Harry")
                .setLastName("Potter")
                .setUserEmail("hp@example.com")
                .clickOnRadioButton()
                .setUserNumber("9643825617")
                .setBirthDate("14", "January", "1998")
                .setSubject("Maths")
                .clickOnCheckbox()
                .scrollTo()
                .uploadPicture()
                .setCurrentAddress("Current address")
                .selectState()
                .selectCity()
                .clickOnSubmit()
                .checkForm("Student Name", "Harry Potter")
                .checkForm("Student Email", "hp@example.com")
                .checkForm("Gender", "Male")
                .checkForm("Mobile", "9643825617")
                .checkForm("Date of Birth", "14 January,1998")
                .checkForm("Subjects", "Maths")
                .checkForm("Hobbies", "Sports")
                .checkForm("Picture", "5b45cb62c051e602a568cd15.png")
                .checkForm("Address", "Current address")
                .checkForm("State and City", "Haryana Karnal");
    }
}
