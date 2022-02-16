package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WithPageObjectTest {
    StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();
    String firstName = "Harry",
            lastName = "Potter",
            userEmail = "hp@example.com",
            userNumber = "9643825617",
            subject = "Maths",
            currentAddress = "Current address",
            day = "14",
            month = "January",
            year = "1998",
            studentName = "Student Name",
            studentEmail = "Student Email",
            studentEmailValue = "hp@example.com",
            gender = "Gender",
            genderValue = "Male",
            mobile = "Mobile",
            mobileValue = "9643825617",
            dateOfBirth = "Date of Birth",
            dateOfBirthValue = "14 January,1998",
            subjects = "Subjects",
            subjectsValue = "Maths",
            hobbies = "Hobbies",
            hobbiesValue = "Sports",
            picture = "Picture",
            pictureValue = "5b45cb62c051e602a568cd15.png",
            address = "Address",
            stateAndCity = "State and City",
            stateAndCityValue = "Haryana Karnal";

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void formTest() {
        studentRegistrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .clickOnRadioButton()
                .setUserNumber(userNumber)
                .setBirthDate(day, month, year)
                .setSubject(subject)
                .clickOnCheckbox()
                .scrollTo()
                .uploadPicture()
                .setCurrentAddress(currentAddress)
                .selectState()
                .selectCity()
                .clickOnSubmit()
                .checkForm(studentName, firstName + " " + lastName)
                .checkForm(studentEmail, studentEmailValue)
                .checkForm(gender, genderValue)
                .checkForm(mobile, mobileValue)
                .checkForm(dateOfBirth, dateOfBirthValue)
                .checkForm(subjects, subjectsValue)
                .checkForm(hobbies, hobbiesValue)
                .checkForm(picture, pictureValue)
                .checkForm(address, currentAddress)
                .checkForm(stateAndCity, stateAndCityValue);
    }
}
