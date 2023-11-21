package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class BaseTest {
    String browser="Chrome";
    public static WebDriver driver; //create a WebDriver reference variable

    public void openBrowser(String baseUrl){
        //launch browser
        if(browser.equalsIgnoreCase("Chrome")){
            driver=new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
           driver=new EdgeDriver();
        }else if(browser.equalsIgnoreCase("safari")){
            driver=new SafariDriver();
        }else{
            System.out.println("YOu have entered a wrong browser name. Try again!");
        }

        //open url
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void closeBrowser(){
        driver.quit(); //close WebDriver session. close driver object instances and close all the browsers

    }

}
