package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

        //Click onn the login link
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();

        //verify the text 'Welcome, Please Sign In!'
        String expectedText = "Welcome, Please Sign In!";

        String actualText = driver.findElement(By.xpath("//h1[text()='Welcome, Please Sign In!']")).getText();

        Assert.assertEquals("The text messages do not match", expectedText, actualText);

    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Click onn the login link
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();

        //Find username and password , enter valid credentials
        driver.findElement(By.id("Email")).sendKeys("sallysmith@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("password1");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        //verify 'Log out' text is displayed
        String expectedText = "Log out";

        String actualText = driver.findElement(By.xpath("//a[text()='Log out']")).getText();
        Assert.assertEquals("The texts do not match.", expectedText, actualText);

    }

    @Test
    public void verifyTheErrorMessage() {
        //Click onn the login link
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();

        //Find username and password , enter valid credentials
        driver.findElement(By.id("Email")).sendKeys("johnsmithxyz@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("password123");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        //verify the error message
        String expectedText = "Login was unsuccessful. Please correct the errors and try again.\n"+
                "No customer account found";

        String actualText = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
        Assert.assertEquals("The error message does not match the expected message", expectedText, actualText);
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
