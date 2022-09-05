import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import amazon.pageObjects.AmazonHomePage;
import amazon.waithelpers.WebElementWait;
import com.typesafe.config.Config;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.*;
import java.util.ArrayList;

import static amazon.pageObjects.AmazonHomePage.electronicsMenuItem;
import static amazon.pageObjects.AmazonHomePage.hamburgerMenuIcon;
import static amazon.pageObjects.AmazonHomePage.samsungTv;
import static amazon.pageObjects.AmazonHomePage.secondHighestPricedTV;
import static amazon.pageObjects.AmazonHomePage.sortByHighToLow;
import static amazon.pageObjects.AmazonHomePage.sortLabel;
import static amazon.pageObjects.AmazonHomePage.televisionListItem;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AmazonTest {

    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private WebDriver driver = DriverFactory.getDriver();



    @Test
    void assertThatHomePageTitleIsCorrect() throws InterruptedException {
        driver.get(HOME_PAGE_URL);
        //Thread.sleep(3000);
        driver.findElement(hamburgerMenuIcon).click();


        driver.findElement(electronicsMenuItem).click();

        WebElementWait.waitForTheElementToBeVisible(driver, driver.findElement(televisionListItem));
        driver.findElement(televisionListItem).click();

        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement samsungTelevision = driver.findElement(samsungTv);
        js.executeScript("arguments[0].scrollIntoView();", samsungTelevision);
        WebElementWait.waitForTheElementToBeVisible(driver, driver.findElement(samsungTv));
        driver.findElement(samsungTv).click();


        WebElementWait.waitForTheElementToBeVisible(driver, driver.findElement(sortLabel));
        driver.findElement(sortLabel).click();


        WebElementWait.waitForTheElementToBeVisible(driver, driver.findElement(sortByHighToLow));
        driver.findElement(sortByHighToLow).click();

        WebElementWait.waitForTheElementToBeVisible(driver, driver.findElement(secondHighestPricedTV));
        driver.findElement(secondHighestPricedTV).click();
        Thread.sleep(3000);
        ArrayList <String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));

        WebElement aboutThisItem = driver.findElement(AmazonHomePage.aboutThisItem);
        js.executeScript("arguments[0].scrollIntoView();", aboutThisItem);
        WebElementWait.waitForTheElementToBeVisible(driver, driver.findElement(AmazonHomePage.aboutThisItem));
        String finalResult = driver.findElement(AmazonHomePage.aboutThisItem).getText();

        assertEquals("About this item", finalResult);


    }
}
