package com.demoqa.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import com.demoqa.pages.PracticeFormPage;
import com.github.javafaker.Faker;

import static com.demoqa.utils.RandomUtils.*;

import java.util.Locale;

import static io.qameta.allure.Allure.step;

@Tag("simple")
public class PracticeFromTest extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void successTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Faker faker = new Faker(new Locale("en"));
        String
                firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                gender = getRandomGender(),
                number = faker.phoneNumber().subscriberNumber(10),
                subject = getRandomSubject(),
                pictureURL = "imageTest.png",
                address = faker.address().fullAddress(),
                day = String.format("%02d", faker.number().numberBetween(1, 28)),
                month = getRandomMonth(),
                year = String.valueOf(getRandomInt(1960, 2000)),
                hobbies = getRandomHobby(),
                state = getRandomState(),
                city = getRandomCity();

        step("Open the page", () -> {
            practiceFormPage.openPage();
        });

        step("Fill the registration form", () -> {
            practiceFormPage.footerRemove()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setUserEmail(userEmail)
                    .setGender(gender)
                    .setNumber(number)
                    .setDateOfBirth(day, month, year)
                    .setSubject(subject)
                    .setHobbie(hobbies)
                    .setPicture(pictureURL)
                    .setAddress(address)
                    .setState(state)
                    .setCity(city)
                    .submit();
        });

        step("Verify results on Dialog Window ", () -> {
            practiceFormPage
                    .verifyModalDialogWindow()
                    .verifyResult("Student Name", firstName + " " + lastName)
                    .verifyResult("Student Email", userEmail)
                    .verifyResult("Gender", gender)
                    .verifyResult("Mobile", number)
                    .verifyResult("Date of Birth", day + " " + month + "," + year)
                    .verifyResult("Subjects", subject)
                    .verifyResult("Hobbies", hobbies)
                    .verifyResult("Picture", pictureURL)
                    .verifyResult("Address", address)
                    .verifyResult("State and City", state + " " + city);
        });
    }
}