import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class NewPublisherTest {
    WebDriver driver;
    private String emil = "tpo313@shitmail.me";
    private String passwd = "ITMOtpo313";
    final static String cat = "/Users/salix/Desktop/ITMO/4year/ТПО/Lab3/src/test/java/cat.png";

    @BeforeEach
    public void webDriverInit() {
        driver = WebDriverInitializer.init();
        driver.get("https://linkedin.com");

    }

    @BeforeAll
    static void downloadImageForPublic() throws IOException {
        String commandToGetImage = "curl https://thiscatdoesnotexist.com --output /Users/salix/Desktop/ITMO/4year/ТПО/Lab3/src/test/java/cat.png";
        Runtime runtime = Runtime.getRuntime();
        runtime.exec(commandToGetImage);
    }

    @Test
    public void publishingRandomTextAndImage() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.findElement(By.xpath("//a[@href=\"" +
                "https://www.linkedin.com/login/ru?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"username\"]"))).sendKeys(emil);
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(passwd);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        String randomMsg = RandomStringUtils.random(313, true, true);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-control-name=\"share.sharebox_focus\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test-ql-editor-contenteditable=\"true\"]"))).sendKeys(randomMsg);

        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-control-name=\"share.post\"]")));
        submitBtn.click();
    }

    @Test
    public void publishingRandomImage() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.findElement(By.xpath("//a[@href=\"" +
                "https://www.linkedin.com/login/ru?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"username\"]"))).sendKeys(emil);
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(passwd);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        WebElement buttonPicShare = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-control-name=\"share.sharebox_bottom_bar_image\"]")));
        buttonPicShare.click();
        WebElement sharePic = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-control-name=\"select_photo\"]")));
        sharePic.sendKeys(cat);
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-control-name=\"confirm_selected_photo\"]")));

        submitBtn.click();

        WebElement share = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-control-name=\"share.post\"]")));
        share.click();
        
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE);
    }
}
