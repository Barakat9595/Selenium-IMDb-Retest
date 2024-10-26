package WatchListPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class WatchListPage {
   private WebDriver driver;
   public WatchListPage(WebDriver driver)
   {
       this.driver = driver;
   }

   By addedMovieAtFirstPosition = By.xpath("/html/body/div[2]/main/div[1]/section[1]/div[1]/section[1]/div[1]/div[1]/section[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]/h3");
   By removeFirstMovieButton = By.xpath("/html/body/div[2]/main/div/section/div/section/div/div[1]/section/div[2]/ul/li/div/div/div/div[1]/div[1]/div/div[1]/div[@class=\"ipc-watchlist-ribbon__icon\"]");
   By emptyMoviePosition = By.xpath("//div[text()='This list is empty.']");
   //ensure movie is present in the list
    public String getMovieName()
    {

        return driver.findElement(addedMovieAtFirstPosition).getText();
    }
    public void removeMovieFromList()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(removeFirstMovieButton).click();
    }
    //auto refresh to empty the list
    public WatchListPage autoRefresh()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().refresh();
        return new WatchListPage(driver);
    }
    public String getEmptyListConfirmation()
    {
        return driver.findElement(emptyMoviePosition).getText();
    }

}
