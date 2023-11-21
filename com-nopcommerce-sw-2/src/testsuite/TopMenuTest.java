package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        //click on the 'computers' tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/computers']")).click();

        //verify the text 'Computers'
        String expectedText = "Computers";

        String actualText = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/computers']")).getText();
        Assert.assertEquals("The text does not match.",expectedText, actualText);

    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully(){
        //click on the 'Electronics' tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/electronics']")).click();

        //verify the text 'Electronics'
        String expectedText = "Electronics";

        String actualText = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/electronics']")).getText();
        Assert.assertEquals("The text does not match.",expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully(){
        //click on the 'Apparel' tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/apparel']")).click();

        //verify the text 'Apparel'
        String expectedText = "Apparel";

        String actualText = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/apparel']")).getText();
        Assert.assertEquals("The text does not match.",expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully(){
        //click on the 'Digital downloads' tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/digital-downloads']")).click();

        //verify the text 'Digital downloads'
        String expectedText = "Digital downloads";

        String actualText = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/digital-downloads']")).getText();
        Assert.assertEquals("The text does not match.",expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully(){
        //click on the 'Books' tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/books']")).click();

        //verify the text 'Books'
        String expectedText = "Books";

        String actualText = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/books']")).getText();
        Assert.assertEquals("The text does not match.",expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully(){
        //click on the 'Jewelry' tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/jewelry']")).click();

        //verify the text 'Jewelry'
        String expectedText = "Jewelry";

        String actualText = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/jewelry']")).getText();
        Assert.assertEquals("The text does not match.",expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully(){
        //click on the 'Gift Cards' tab
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/gift-cards']")).click();

        //verify the text 'Gift Cards'
        String expectedText = "Gift Cards";

        String actualText = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/gift-cards']")).getText();
        Assert.assertEquals("The text does not match.",expectedText, actualText);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
