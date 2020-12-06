import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RegistrationTest {
    WebDriver driver;

    @BeforeEach
    void prepare(){
        driver = WebDriverInitializer.init();
        driver.get("https://linkedin.com");
    }

    @Test
    void registrationUsing(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement signUpButton = driver.findElement(By.xpath("//a[@href=\"" +
                "https://www.linkedin.com/signup/cold-join?trk=guest_homepage-basic_nav-header-join\"]"));
        signUpButton.click();

        String emil = RandomStringUtils.random(12, true, false) + "@shitmail.me";
        String passwd = RandomStringUtils.random(12, true, true);

        driver.findElement(By.xpath("//input[@id=\"email-address\"]")).sendKeys(emil);
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(passwd);
        driver.findElement(By.xpath("//button[@id=\"join-form-submit\"]")).click();

        driver.findElement(By.xpath("//input[@id=\"first-name\"]")).sendKeys(passwd);
        driver.findElement(By.xpath("//input[@id=\"last-name\"]")).sendKeys(passwd);
        driver.findElement(By.xpath("//button[@id=\"join-form-submit\"]")).click();

    }
}
