package сom.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    SelenideElement
            fullNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            resultName = $("#output #name"),
            resultEmail = $("#output #email"),
            resultCurrentAddress = $("#output #currentAddress"),
            resultPermanentAddress = $("#output #permanentAddress");

    public TextBoxPage openPage() {
        open("/text-box");
        $(".main-header").shouldHave(text("Text Box"));

        return this;
    }

    public TextBoxPage setFullName(String fullName) {
        fullNameInput.setValue(fullName);

        return this;
    }

    public TextBoxPage setEmail(String email) {
        emailInput.setValue(email);

        return this;
    }

    public TextBoxPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);

        return this;
    }

    public TextBoxPage setPermanentAddress(String permanentAddress) {
        permanentAddressInput.setValue(permanentAddress);

        return this;
    }

    public TextBoxPage submitInputData() {
        submitButton.click();

        return this;
    }

    public TextBoxPage verifyResult(String fullName, String email, String currentAddress, String permanentAddress) {
        resultName.shouldHave(text(fullName));
        resultEmail.shouldHave(text(email));
        resultCurrentAddress.shouldHave(text(currentAddress));
        resultPermanentAddress.shouldHave(text(permanentAddress));

        return this;
    }
}