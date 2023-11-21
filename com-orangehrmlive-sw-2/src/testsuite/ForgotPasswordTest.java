package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {
        driver.findElement(By.xpath("//div[@class='orangehrm-login-forgot']")).click();
        String expectedText="Reset Password";
        WebElement actualTextElement = driver.findElement(By.xpath("//h6[text()='Reset Password']"));
        String actualText=actualTextElement.getText();
        Assert.assertEquals("User is not navigated to Password Reset page.",expectedText,actualText);
    }


    @After
    public void tearDown() {
        closeBrowser();
    }

}
