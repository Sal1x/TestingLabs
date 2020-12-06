import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchTesting {
    WebDriver driver;

    private String emil = "tpo313@shitmail.me";
    private String passwd = "ITMOtpo313";

    @BeforeEach
    void prepare(){
        driver = WebDriverInitializer.init();
        driver.get("https://linkedin.com");
    }



    @Test
    public void search(){
        //login
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.findElement(By.xpath("//a[@href=\"" +
                "https://www.linkedin.com/login/ru?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"username\"]"))).sendKeys(emil);
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(passwd);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        //search

        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class=\"search-global-typeahead__input always-show-placeholder\"]")));
        searchInput.sendKeys("Tester");
        searchInput.sendKeys(Keys.ENTER);

    }
}
