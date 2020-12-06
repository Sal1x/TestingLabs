import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class ProfileTesting {
    WebDriver driver;
    private String emil = "tpo313@shitmail.me";
    private String passwd = "ITMOtpo313";
    final static String image = "/Users/salix/Desktop/ITMO/4year/ТПО/Lab3/src/test/java/image.png";

    @BeforeEach
    public void webDriverInit(){
        driver = WebDriverInitializer.init();
        driver.get("https://linkedin.com");

    }

    @BeforeAll
    static void downloadImageForAvatar() throws IOException {
        String commandToGetImage = "curl https://thispersondoesnotexist.com/image --output /Users/salix/Desktop/ITMO/4year/ТПО/Lab3/src/test/java/image.png";
        Runtime runtime = Runtime.getRuntime();
        runtime.exec(commandToGetImage);
    }

    @Test
    public void loginTestUser() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.findElement(By.xpath("//a[@href=\"" +
                "https://www.linkedin.com/login/ru?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"username\"]"))).sendKeys(emil);
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(passwd);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
    }

    @Test
    public void changeProfilePicture(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.findElement(By.xpath("//a[@href=\"" +
                "https://www.linkedin.com/login/ru?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"username\"]"))).sendKeys(emil);
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(passwd);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/in/testuser-testuser-7a5424201/\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/in/testuser-testuser-7a5424201/edit/intro/\"]"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for=\"top-card-form-edit-upload-input\"]")));
        driver.findElement(By.xpath("//input[@id=\"top-card-form-edit-upload-input\"]")).sendKeys(image);

        driver.findElement(By.xpath("//button[@data-control-name=\"profile_photo_crop_save\"]")).click();
    }

}
