package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = " https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //find 'signIn' element and click
        WebElement signInLink = driver.findElement(By.xpath("//a[@href='/users/sign_in']"));
        signInLink.click();

        //store expected text in a string
        String expectedText = "Welcome Back!";

        //find heading element and store its text
        String actualText = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();

        //compare actual and expected texts
        Assert.assertEquals("The user is not navigated to the correct page.", expectedText, actualText);
    }

    @Test
    public void verifyTheErrorMessage() {

        //find sign in element and click
        WebElement signInLink = driver.findElement(By.xpath("//a[@href='/users/sign_in']"));
        signInLink.click();

        //find username and password elements and enter invalid credentials
        driver.findElement(By.id("user[email]")).sendKeys("abc@gmail.com");
        WebElement password = driver.findElement(By.id("user[password]"));
        password.sendKeys("password1");

        //find 'Sign in' button and click
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();

        //store expected text in a variable
        String expectedText = "Invalid email or password.";

        //find error message element and store text in a variable
        String actualText = driver.findElement(By.xpath("//li[contains(text(),'Invalid')]")).getText();

        Assert.assertEquals("The error message does not match", expectedText, actualText);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
