package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.Random;

public class RegisterTest extends BaseTest {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    //call BaseTest method to close browser windows
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //verify that the signin page displays when clicked
    @Test
    public void verifyThatSignInPageDisplay() {
        //find create an account link and click
        driver.findElement(By.xpath("//a[text()='Create an Account']")).click();

        //verify if the expected text and actual text match
        String expectedText = "Create New Customer Account";
        WebElement pageTitle = driver.findElement(By.xpath("//h1[@class='page-title']"));
        String actualText = pageTitle.getText();
        Assert.assertEquals("The messages do not match:", expectedText, actualText);
    }

    //Verify the user can register successfully
    @Test
    public void userShouldRegisterAccountSuccessfully() {

        driver.findElement(By.xpath("//a[text()='Create an Account']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Annu");
        driver.findElement(By.id("lastname")).sendKeys("Som");

        //generate random email
        Random random = new Random();
        int number = random.nextInt(1000);
        String randomStr = String.format("%03d", number);
        String randomEmail = randomStr + "annusom@gmail.com";

        driver.findElement(By.id("email_address")).sendKeys(randomEmail);

        driver.findElement(By.id("password")).sendKeys("Password1");
        driver.findElement(By.id("password-confirmation")).sendKeys("Password1");
        driver.findElement(By.xpath("//button/span[contains(text(),'Create an Account')]")).click();

        //Verify confirmation message to expected message
        String expectedText = "Thank you for registering with Main Website Store.";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[contains(text(),'Thank you for registering')]"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("The actual and expected messages do not match", expectedText, actualText);

        driver.findElement(By.xpath("//button[@class='action switch']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String expectedTextForSignOut = "You are signed out";
        String actualTextForSignOut = driver.findElement(By.xpath("//span[text()='You are signed out']")).getText();
        Assert.assertEquals("The texts do not match.", expectedTextForSignOut,actualTextForSignOut);

    }



    @After
    public void tearDown() {
        closeBrowser();
    }

}
