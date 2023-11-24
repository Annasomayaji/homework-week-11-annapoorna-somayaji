package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage() {
        //Click on 'sale' menu tab
        driver.findElement(By.id("ui-id-8")).click();

        //click on jackets under 'Women's Deals'
        driver.findElement(By.xpath("//ul[@class='items'][1]/li[@class='item']/a[text()='Jackets']")).click();

        //verify 'Jackets' heading
        String expectedText = "Jackets";
        String actualText = driver.findElement(By.id("page-title-heading")).getText();
        Assert.assertEquals("The expected and actual headings do not match.", expectedText, actualText);

        //verify the number of products on the page
        List<WebElement> productsOnPage = driver.findElements(By.xpath("//li[@class='item product product-item']"));
        System.out.println("The number of items on page is: " + productsOnPage.size());
        System.out.println("-------------------------------------------------------------");

        //print all the product names
        List<WebElement> productItems = driver.findElements(By.xpath("//a[@class='product-item-link']"));
        int count = 1;
        for (WebElement item : productItems) {
            System.out.println("The item " + count + " is:" + item.getText());
            count++;
        }

        //Verify total 12 items are displayed on the page.
        int expectedNumberOfProducts = 12;
        int actualNumberOfProducts = productsOnPage.size();

        Assert.assertEquals("The total number of products is not the expected number.", expectedNumberOfProducts, actualNumberOfProducts);
    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}
