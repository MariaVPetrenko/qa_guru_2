package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WithPageObjects {
    StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();
    String firstName = "Harry";
    String lastName = "Potter";
    String userEmail = "hp@example.com";
    String userNumber = "9643825617";
    String subject = "Maths";
    String currentAddress = "Current address";
    String day = "14";
    String month = "January";
    String year = "1998";
    String studentName = "Student Name";
    String studentNameValue = "Harry Potter";
    String studentEmail = "Student Email";
    String studentEmailValue = "hp@example.com";
    String gender = "Gender";
    String genderValue = "Male";
    String mobile = "Mobile";
    String mobileValue = "9643825617";
    String dateOfBirth = "Date of Birth";
    String dateOfBirthValue = "14 January,1998";
    String subjects = "Subjects";
    String subjectsValue = "Maths";
    String hobbies = "Hobbies";
    String hobbiesValue = "Sports";
    String picture = "Picture";
    String pictureValue = "5b45cb62c051e602a568cd15.png";
    String address = "Address";
    String stateAndCity = "State and City";
    String stateAndCityValue = "Haryana Karnal";

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
                .checkForm(studentName, studentNameValue)
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
