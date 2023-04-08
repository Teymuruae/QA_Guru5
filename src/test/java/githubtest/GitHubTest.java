package githubtest;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class GitHubTest {
    private final String URL = "https://github.com/";

    private SelenideElement solutionsMenu = $(Selectors.byTagAndText("button", "Solutions"));
    private SelenideElement enterprise = $(Selectors.byTagAndText("a", "Enterprise"));
    private SelenideElement textInEnterprisePage = $x("(//h1[text() = 'Build like the best'])[1]");

    @BeforeEach
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 10000;
    }

    @Test
    public void solutionsTest() {
        Selenide.open(URL);
        solutionsMenu.hover();
        enterprise.click();

        textInEnterprisePage.shouldBe(Condition.visible);




    }

}
