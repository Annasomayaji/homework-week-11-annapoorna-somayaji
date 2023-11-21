package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        //click on the ‘Register’ link
        driver.findElement(By.className("ico-register")).click();

        //Verify the text ‘Register’

        String expectedText = "Register";
        String actualText = driver.findElement(By.xpath("//h1[text()='Register']")).getText();
        Assert.assertEquals("The texts do not match.", expectedText, actualText);


    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //click on the ‘Register’ link

        driver.findElement(By.className("ico-register")).click();

        // Select gender radio button
        driver.findElement(By.id("gender-male")).click();

        // Enter First name
        driver.findElement(By.id("FirstName")).sendKeys("Sally");
        // Enter Last name
        driver.findElement(By.id("LastName")).sendKeys("Smith");

        //Select Day Month and Year

        //generate random email address each time

        Random random = new Random();
        int number = random.nextInt(1000);
        String randoms = String.format("%03d", number);
        String emailId = randoms + "sallysmith@gmail.com";

        // Enter Email address
        driver.findElement(By.id("Email")).sendKeys(emailId);
        // Enter Password
        driver.findElement(By.id("Password")).sendKeys("password1");

        // Enter Confirm password
        driver.findElement(By.id("ConfirmPassword")).sendKeys("password1");
        // Click on REGISTER button
        driver.findElement(By.id("register-button")).click();

        // Verify the text 'Your registration completed’
        String expectedText = "Your registration completed";

        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='result']"));
        String actualText = actualTextElement.getText();

        Assert.assertEquals("The confirmation registration does not match the expected.", expectedText, actualText);
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
