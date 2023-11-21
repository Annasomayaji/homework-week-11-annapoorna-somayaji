package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class BaseTest {
    static String browser = "chrome";

    public static WebDriver driver; //declare WebDriver reference

    //launch browser
    public void openBrowser(String baseUrl) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else {
            System.out.println("You have entered the wrong browser name. Try again!");
        }
        driver.get(baseUrl); //Open url
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public void closeBrowser() {
        driver.quit();//  Terminate WebDriver session, terminate browser instances. Close all browser windows.
    }

}
