import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextMessagingTest {
    WebDriver driver;
    private final String emil = "tpo313@shitmail.me";
    private final String passwd = "ITMOtpo313";


    @BeforeEach
    void prepare() {
        driver = WebDriverInitializer.init();
        driver.get("https://linkedin.com");
    }


    @Test
    void sendMessageUpToThousandChars() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.findElement(By.xpath("//a[@href=\"" +
                "https://www.linkedin.com/login/ru?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"username\"]"))).sendKeys(emil);
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(passwd);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-test-global-nav-link=\"messaging\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/messaging/thread/6741458879340802048/\"]"))).click();

        String randomMessage = RandomStringUtils.random(1000, true, true);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role=\"textbox\"]"))).sendKeys(randomMessage);

        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type=\"submit\"]")));
        submitBtn.click();
    }
}
