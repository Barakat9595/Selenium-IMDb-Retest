import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        By ratingStarWhenEmpty =  By.xpath("//div[@class='sc-4f0b1185-0 cSKIWH']/div[text()=\"Rate\"]");

        try {
            driver.get("https://www.imdb.com/title/tt0468569/?ref_=fn_al_tt_1");
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
}
