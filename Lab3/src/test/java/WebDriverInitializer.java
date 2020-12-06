import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverInitializer {
    public static WebDriver init(){
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "/Users/salix/Desktop/ITMO/4year/ТПО/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1623, 894));
        return driver;
    }
}
