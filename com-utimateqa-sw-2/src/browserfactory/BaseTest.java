package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class BaseTest {
    String browser = "Chrome";
    public static WebDriver driver; //create a WebDriver reference variable

    public void openBrowser(String baseUrl){

        //launch browser
        if(browser.equalsIgnoreCase("chrome")){
            driver=new ChromeDriver();
        }else if (browser.equalsIgnoreCase("safari")){
            driver=new SafariDriver();
        }else if(browser.equalsIgnoreCase("Edge")){
            driver=new EdgeDriver();
        }else{
            System.out.println("You have entered a wrong browser name. Try again!");
        }

        //open url
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

   public void closeBrowser(){
        driver.quit(); //close all browsers windows and terminate browser instances and close WebDriver session
   }
}
