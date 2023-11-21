package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = " https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //find username and password elements and send valid credentials
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        //find login button element and click
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //find expected text from the requirement and store it in a variable
        String expextedText = "Products";

        //find the element from response page and store the text in a variable
        String actualText = driver.findElement(By.xpath("//div[@class='header_secondary_container']/span[text()='Products']")).getText();

        //compare actual and expected texts
        Assert.assertEquals("The user is not navigated to the right page.", expextedText, actualText);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //find username and password elements and send valid credentials
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        //find login button element and click
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //find elements of the display products
        List<WebElement> productList = driver.findElements(By.className("inventory_item"));

        //System.out.println(productList.size());
        Assert.assertTrue("The number of products in the list is not 6.",productList.size()==6);
    }


    @After
    public void tearDown() {
        closeBrowser();
    }

}
