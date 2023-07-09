package сom.demoqa.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import сom.demoqa.pages.PracticeFormPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFromTestWithPageObjects extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void successTest(){

        practiceFormPage.openPage()
                .setFirstName("Angelina")
                .setLastName("Savina")
                .setUserEmail("angelinaa@mail.com")
                .setGender()
                .setNumber("1234567891")
                .setDateOfBirth()
                .setSubject("ec")
                .setHobbie()
                .setPicture("imageTest.png")
                .setAddress("Cyprus is current address")
                .setCity()
                .submit()
                .verifyModalDialogWindow()
                .verifyResult("Student Name", "Angelina Savina")
                .verifyResult("Student Email", "angelinaa@mail.com")
                .verifyResult("Gender", "Female")
                .verifyResult("Mobile", "1234567891")
                .verifyResult("Date of Birth", "08 June,1996")
                .verifyResult("Subjects", "Economics")
                .verifyResult("Hobbies", "Reading")
                .verifyResult("Picture", "imageTest.png")
                .verifyResult("Address", "Cyprus is current address")
                .verifyResult("State and City", "NCR Delhi");
    }


}
