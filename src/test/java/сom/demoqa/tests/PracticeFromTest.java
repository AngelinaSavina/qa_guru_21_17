package сom.demoqa.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import сom.demoqa.pages.PracticeFormPage;

import static io.qameta.allure.Allure.step;

@Tag("simple")
public class PracticeFromTest extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void successTest() {


        step("Open the page", () -> {
            practiceFormPage.openPage();
        });

        step("Fill the registration form", () -> {
            practiceFormPage.footerRemove()
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
                    .setState()
                    .setCity()
                    .submit();
        });

        step("Verify results on Dialog Window ", () -> {
            practiceFormPage.verifyModalDialogWindow()
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
        });
    }
}
