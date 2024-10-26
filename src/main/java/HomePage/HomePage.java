package HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import movieSearchResultsPage.movieSearchResultsPage;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;
    public HomePage (WebDriver driver)
    {
        this.driver = driver;
    }

    private By searchBar = By.xpath("//div[@role='combobox']/child::input ");
    private By searchIconBtn = By.id("suggestion-search-button");
    public void enterMovieName(String movieName)
    {
        driver.findElement(searchBar).sendKeys(movieName);
    }
    public movieSearchResultsPage clickSearch()
    {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(searchIconBtn).click();
        return new movieSearchResultsPage(driver); /* adding (driver) here compensates adding it in the
        tests, the base test contains (driver) because it's not returned by any method */
    }
}
