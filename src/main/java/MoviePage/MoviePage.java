package MoviePage;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import WatchListPage.WatchListPage;

import java.time.Duration;
import java.util.List;

public class MoviePage {
   private WebDriver driver;
    WebDriverWait wait;
   public MoviePage(WebDriver driver)
   {
       this.driver = driver;
       /* adding the wait in the constructor
        as the constructor is called to open the page
        so it's added to be fully loaded */
       this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

       // Wait for a key element on the MoviePage to be present
       wait.until(ExpectedConditions.visibilityOf(driver.findElement(ratingStarWhenEmpty)));
       /* visibility of element located (element (By located))
        = visibility of (driver.findElement(element) */
   }
   By ratingStarWhenEmpty =  By.xpath("//div[@class='sc-4f0b1185-0 cSKIWH']/div[text()=\"Rate\"]");
   By ratingStarActive = By.xpath("//div[@class='sc-4f0b1185-0 cSKIWH']/div[@class='sc-4f0b1185-2 gCROKr']");
   By tenthStar = By.xpath("//div[@class=\"ipc-starbar__rating\"]/child::button[@aria-label=\"Rate 10\"]");
   By submittedRate = By.xpath("//div[@class=\"ipc-rating-display__rating\"]");
   By addToWatchListBtn = By.xpath("//div[text()='Add to Watchlist']");
   By watchListAfterAddingMovie = By.xpath("//*[@id=\"imdbHeader\"]/div[2]/div[4]/a/span/span");
   // the last locator can be used after adding some movie as it represent the number of movies in the cart
    By submitRate = By.xpath("//span[text()='Rate']");
   public void openRatingPopUp() {  //openRatingPopUp will  be used once again to get rate
       try { /* try catch here is dealing with the non presence of the element and that the
       time goes out without the condition being fulfilled, which means that the explicit waits
        needs to be handled because if the time goes out and the condition not fulfilled it will through
        exception */
           // Waiting for the elements to be present
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
           List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ratingStarWhenEmpty));

           // Checking if elements were found
           if (!elements.isEmpty()) {
               // Interacting with the first element found
               WebElement firstElement = elements.get(0);
               firstElement.click();  // Perform your desired action here
           } else {
               System.out.println("No elements found matching the XPath expression.");
           }

       } catch (TimeoutException e) {
           System.out.println("The rating stars did not appear within the timeout period.");
       } catch (NoSuchElementException e) {
           System.out.println("The rating stars could not be found.");
       } catch (Exception e) {
           e.printStackTrace();
       }
   }

    public void rateMovie()
    {

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        try {
            // Wait for the tenth star element to become visible and clickable, then click it
            WebElement tenthStarElement = wait.until(ExpectedConditions.visibilityOfElementLocated(tenthStar));
            Actions actions = new Actions(driver);
            actions.moveToElement(tenthStarElement).click().perform();
        } catch (TimeoutException e) {
            System.out.println("Tenth star element was not visible within the timeout.");
        } catch (NoSuchElementException e) {
            System.out.println("Tenth star element could not be found.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }


    public void submitRating()
    {
        driver.findElement(submitRate).click();
    }

    public String getRateValue()
    {
        return driver.findElement(submittedRate).getText();
    }
    public void scrollToAddBtn()
    {
        WebElement myElement = driver.findElement(addToWatchListBtn); //to scroll to this element, we created an element to find the button
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script, myElement);

    }
    public void scrollUpToWatchList()
    {
        WebElement myElement = driver.findElement(watchListAfterAddingMovie); //to scroll to this element, we created an element to find the button
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script, myElement);
    }
    public String getMovieCountInWatchlist() {
        try {
            WebElement watchListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(watchListAfterAddingMovie));
            return watchListElement.getText();

        } catch (Exception e) {
            System.out.println("Error: Unable to retrieve movie count from watchlist - " + e.getMessage());
            return null;
        }
    }

    public void addToWatchList()
    {
        driver.findElement(addToWatchListBtn).click();
    }
    public WatchListPage openWatchList()
    {
        driver.findElement(watchListAfterAddingMovie).click();
        return new WatchListPage(driver);
    }
    public void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }
    public void calmDown()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }





}
