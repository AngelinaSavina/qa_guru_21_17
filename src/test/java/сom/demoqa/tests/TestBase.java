package сom.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import сom.demoqa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;

import java.util.Map;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = System.getProperty("baseUrl");
        Configuration.browserSize = System.getProperty("browserSize");
        Configuration.browser = System.getProperty("browser");
        Configuration.browserVersion = System.getProperty("browserVersion");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.remote = "https://user1:1234@" + System.getProperty("remoteDriverUrl") + "/wd/hub";

        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }


    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }
    @AfterAll
    public static void afterAll() {
        closeWebDriver();
    }

}

