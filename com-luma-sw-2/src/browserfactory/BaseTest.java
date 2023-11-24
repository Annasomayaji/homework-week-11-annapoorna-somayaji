package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.time.Duration;

public class BaseTest {
    static String browser = "Chrome";
    public static WebDriver driver; //create a reference variable to WebDriver interface

    public void openBrowser(String baseUrl) {

        //create ChromeOption object and add incognito mode argument
        ChromeOptions options=new ChromeOptions();
        SafariOptions options1=new SafariOptions();
        options.addArguments("--incognito");

        //launch browser
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else if (browser.equalsIgnoreCase("edge")){
            driver=new EdgeDriver();
        }else
            System.out.println("You have entered a wrong browser name. Try again!");

        //open url
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    public void closeBrowser(){
        driver.quit();//Terminate WebDriver session. Close all driver instances. close browser windows
    }


}
