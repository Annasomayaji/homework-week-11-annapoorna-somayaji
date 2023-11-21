package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {
    static String browser = "Chrome"; //send default browser name
    public static WebDriver driver;  //declare WebDriver reference object

   //openBrowser method to be re-used in all tests
    public void openBrowser(String baseUrl) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();  //creating object of Chrome browser and assign it to WebDriver reference
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("You have entered the wrong browser. Try again!");
        }
        driver.get(baseUrl);  //Launch url
        driver.manage().window().maximize();  //Maximise browser window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));   //provide implicit wait

    }

   //close browser method to be re-used in all tests
    public void closeBrowser() {
        driver.quit();  //closes all browser windows and terminates the browser instance. Ends webDriver session
    }
}
