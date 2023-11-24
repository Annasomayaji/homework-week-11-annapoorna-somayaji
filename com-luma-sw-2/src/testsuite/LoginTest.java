package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Click on Sign In link
        driver.findElement(By.xpath("//li[@class='authorization-link']/a")).click();

        //Enter email
        driver.findElement(By.id("email")).sendKeys("annusom@gmail.com");
        //enter Password
        driver.findElement(By.id("pass")).sendKeys("Password1");
        //Click on sign in button
        driver.findElement(By.id("send2")).click();

        //verify if the expected and actual headings match and the user is navigated to the correct page
        String expectedText = "Welcome, Annu Som!";
        String actualText = driver.findElement(By.xpath("//li/span[contains(text(),'Welcome')]")).getText();
        Assert.assertEquals("The welcome messages do not match.", expectedText, actualText);
    }

    @Test
    public void verifyTheErrorMessageWithInvalidCredentials() {
        //click on Sign In link
        driver.findElement(By.xpath("//li[@class='authorization-link']/a")).click();

        //Enter invalid email
        driver.findElement(By.id("email")).sendKeys("anusom@gmail.com");

        //enter valid password
        driver.findElement(By.id("pass")).sendKeys("Password1");

        //Click on Sign in button
        driver.findElement(By.id("send2")).click();

        //verify the expected and actual warnings match
        String expectedText = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        String actualText = driver.findElement(By.xpath("//div[contains(text(),'The account sign-in was incorrect')]")).getText();
        Assert.assertEquals("The expected warning message does not match with the actual warning message", expectedText, actualText);

    }

    @Test
    public void userShouldLogOutSuccessfully() {
        //Click on Sign In link
        driver.findElement(By.xpath("//li/a[contains(text(), 'Sign In')]")).click();

        //enter valid email
        driver.findElement(By.id("email")).sendKeys("annusom@gmail.com");

        //enter valid password
        driver.findElement(By.id("pass")).sendKeys("Password1");

        //click on Sign In button
        driver.findElement(By.id("send2")).click();

        //click on down arrow button
        driver.findElement(By.xpath("//button[@class='action switch']")).click();

        //click on sign out link
        driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();

        //Verify the Sign Out success message
        String expectedText = "You are signed out";
        String actualText = driver.findElement(By.xpath("//span[text()='You are signed out']")).getText();
        Assert.assertEquals("The expected and actual Sign Out confirmation messages do not match.", expectedText, actualText);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
