package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Value;
import pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormPage {
    // components
    CalendarComponent calendarComponent = new CalendarComponent();

    // locators
    SelenideElement
            headerTitle = $(".main-header"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            radioButtonInput = $(byText("Male")),
            userNumberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            checkboxInput = $(byText("Sports")),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressTextArea = $("#currentAddress"),
            selectStateInput = $(byText("Select State")),
            haryanaInput = $(byText("Haryana")),
            selectCityInput = $(byText("Select City")),
            karnalInput = $(byText("Karnal")),
            submitButton = $("#submit"),
            resultsTable = $(".table-responsive");


    // actions
    public StudentRegistrationFormPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        headerTitle.shouldHave(text("Practice Form"));
        return this;
    }

    public StudentRegistrationFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public StudentRegistrationFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public StudentRegistrationFormPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    public StudentRegistrationFormPage clickOnRadioButton() {
        radioButtonInput.click();
        return this;
    }

    public StudentRegistrationFormPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }

    public StudentRegistrationFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public StudentRegistrationFormPage setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public StudentRegistrationFormPage clickOnCheckbox() {
        checkboxInput.click();
        return this;
    }

    public StudentRegistrationFormPage scrollTo() {
        uploadPictureInput.scrollTo();
        return this;
    }

    public StudentRegistrationFormPage uploadPicture() {
        uploadPictureInput.uploadFile(new File("src/test/resources/5b45cb62c051e602a568cd15.png"));
        return this;
    }

    public StudentRegistrationFormPage setCurrentAddress(String currentAddress) {
        currentAddressTextArea.setValue(currentAddress);
        return this;
    }

    public StudentRegistrationFormPage selectState() {
        selectStateInput.click();
        haryanaInput.click();
        return this;
    }

    public StudentRegistrationFormPage selectCity() {
        selectCityInput.click();
        karnalInput.click();
        return this;
    }

    public StudentRegistrationFormPage clickOnSubmit() {
        submitButton.click();
        return this;
    }

    public StudentRegistrationFormPage checkForm(String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }
}

