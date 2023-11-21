package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    //Call the base class openBrowser method
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    //Test to verify login is successful with valid credentials
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        //Find user name, password fields and enter valid credentials
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        //Find the login button and click on it
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        String expectedText = "Secure Area";

        //Capture heading text in actual text and compare with expected text
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='example']/h2"));
        String actualText = actualTextElement.getText();
        System.out.println(actualText);
        Assert.assertEquals("User is not navigated to the correct page.", expectedText, actualText);

    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        //Find user name, password fields and enter invalid user name and valid password
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith1");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        //Find the login button and click on it
        driver.findElement(By.xpath("//button[@class='radius']")).click();

        //store expected message in a variable
        String expectedText = "Your username is invalid!";
        System.out.println("length of expected string" + expectedText.length()); //for debug purpose

        //find the error message element and verify
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualText = actualTextElement.getText();
        String actualTextSubstring = actualText.substring(0, 25); //get the substring to exclude child element text
        //System.out.println(actualTextSubstring); //for debug purpose

        //validate expected and actual texts
        Assert.assertEquals("The error message does not match the expected.", expectedText, actualTextSubstring);

    }

    @Test
    public void verifyThePasswordErrorMessage() {
        //Find user name, password fields and enter valid user name and invalid password
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");

        //Find the login button and click on it
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        String expectedText = "Your password is invalid!";
        System.out.println(expectedText.length()); //for debug purpose
        String actualText = driver.findElement(By.id("flash")).getText();

        //get the substring of actual text to exclude child element text
        String actualTextSubstring = actualText.substring(0,25);
        Assert.assertEquals(expectedText, actualTextSubstring);

    }


    //call base class method to close browser
    @After
    public void tearDown() {
        closeBrowser();
    }
}
