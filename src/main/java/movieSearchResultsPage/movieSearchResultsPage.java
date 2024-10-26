package movieSearchResultsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import MoviePage.MoviePage;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class movieSearchResultsPage {

    private WebDriver driver;
    public movieSearchResultsPage(WebDriver driver)
    {
        this.driver = driver;
    }
    private By firstResult = By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/section/div/div[1]/section[2]/div[2]/ul/li[1]/div[2]/div/a");
    public String getResultName()
    {
        return  driver.findElement(firstResult).getText();

    }
    public MoviePage chooseFirstResult()
    {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(firstResult).click();

        return new MoviePage(driver);

    }
}
