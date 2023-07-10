package сom.demoqa.tests;

import org.junit.jupiter.api.Test;
import сom.demoqa.pages.TextBoxPage;

public class TextBoxPageObjectsTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void successfulTextBoxTest() {
        textBoxPage.openPage()
                .setFullName("Angelina Savina")
                .setEmail("angelinaa@mail.com")
                .setCurrentAddress("Cyprus is current address")
                .setPermanentAddress("Cyprus is permanent address")
                .submitInputData()
                .verifyResult(
                        "Angelina Savina",
                        "angelinaa@mail.com",
                        "Cyprus is current address",
                        "Cyprus is permanent address"
                );
    }
}