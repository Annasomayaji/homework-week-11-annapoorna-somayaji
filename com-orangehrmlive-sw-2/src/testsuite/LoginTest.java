package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    //method to call BaseTest class method


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Find userName field and enter user name
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("Admin");
        //Find password field and enter password
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.className("oxd-button")).click();
        //Store expected text obtained from FRS
        String expectedText = "Dashbord";
        //find the actual displayed text and use Assertion library method to compare
        WebElement actualTextElement = driver.findElement(By.linkText("Dashboard"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Not navigated to the dashboard.", expectedText,actualText);
    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}
