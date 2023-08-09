package сom.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import сom.demoqa.pages.components.ResultTableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;


public class PracticeFormPage {
    ResultTableComponent resultTableComponent = new ResultTableComponent();


    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $(byText("Female")),
            userNumber = $("#userNumber"),
            birthWrapper = $("#dateOfBirth-wrapper"),
            dateOfBirthWrapper = $(".react-datepicker__day--008"),
            subjectsInput = $("#subjectsInput"),
            subjectInput = $(byText("Economics")),
            hobbiesWrapper = $("#hobbiesWrapper").$(byText("Reading")),
            picture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateCityWrapper = $("#stateCity-wrapper"),
            stateWrapper = $("#state"),
            cityWrapper = $("#city"),
            submitButton = $("#submit");


    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }


    public PracticeFormPage footerRemove() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }


    public PracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }


    public PracticeFormPage setGender() {
        genderWrapper.click();
        return this;
    }


    public PracticeFormPage setNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    public PracticeFormPage setDateOfBirth() {
        birthWrapper.$("#dateOfBirthInput").click();
        birthWrapper.$("#dateOfBirthInput").click();
        birthWrapper.$(".react-datepicker__month-select").click();
        birthWrapper.$(byText("June")).click();
        birthWrapper.$(".react-datepicker__year-select").click();
        birthWrapper.$(byText("1996")).click();
        dateOfBirthWrapper.click();
        return this;
    }

    public PracticeFormPage setSubject(String value) {
        subjectsInput.setValue(value);
        subjectInput.click();
        return this;
    }

    public PracticeFormPage setHobbie() {
        hobbiesWrapper.click();
        return this;
    }


    public PracticeFormPage setPicture(String value) {
        picture.uploadFromClasspath(value);
        return this;
    }

    public PracticeFormPage setAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }


    public PracticeFormPage setState() {
        stateWrapper.click();
        stateCityWrapper.$(byText("NCR")).click();
        return this;
    }

    public PracticeFormPage setCity() {
        cityWrapper.click();
        stateCityWrapper.$(byText("Delhi")).click();
        return this;
    }

    public PracticeFormPage submit() {
        submitButton.click();
        return this;
    }

    public PracticeFormPage verifyModalDialogWindow() {
        resultTableComponent.verifyModalDialogAppeared();
        return this;
    }

    public PracticeFormPage verifyResult(String label, String value) {
        resultTableComponent.verifyTableContent(label, value);
        return this;
    }


}
