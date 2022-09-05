package amazon.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonHomePage {
    public static By hamburgerMenuIcon = By.xpath("//*[@id='nav-hamburger-menu']");
    public static By electronicsMenuItem = By.xpath("//a//div[contains(text(),'TV, Appliances, Electronics')]");
    public static By televisionListItem = (By.xpath("//li//a[contains(text(),'Televisions')]"));
    public static By samsungTv = (By.xpath("//ul//li//a//span[contains(text(),'Samsung')]//preceding-sibling::div"));
    public static By sortLabel = (By.xpath("//span[@class='a-dropdown-label']"));
    public static By sortByHighToLow = (By.xpath("//a[contains(text(),'Price: High to Low')]"));
    public static By secondHighestPricedTV = (By.xpath("//div[@data-index='2']//a"));
    public static By aboutThisItem =By.xpath("//*[contains(text(),'About this item')]");



}
