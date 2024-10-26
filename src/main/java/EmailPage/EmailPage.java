
package EmailPage;

import HomePage.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailPage {
    private WebDriver driver;
    public EmailPage(WebDriver driver)
    {
        this.driver = driver;
    }
    private By emailField = By.xpath("//*[@id=\"identifierId\"]");
    private By confirmBtn = By.xpath("/html/body/div[1]/div[1]/div[2]/c-wiz/div/div[3]/div/div[1]/div/div/button/span");
    public void enterEmail(String email)
    {
        driver.findElement(emailField).sendKeys(email);
    }
    /* public HomePage clickNext()
    {
        driver.findElement(confirmBtn).click();
        return new HomePage(driver);
    } */



}
