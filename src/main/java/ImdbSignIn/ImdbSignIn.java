package ImdbSignIn;

import HomePage.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ImdbSignIn {

    private WebDriver driver;
    public ImdbSignIn(WebDriver driver)
    {
        this.driver = driver;
    }
    private By emailField = By.xpath("//input[@type='email']");
    private By passwordField = By.xpath("//input[@type='password']");
    private By signInBtn = By.xpath("//input[@id='signInSubmit']");


    public void enterEmail(String email)
    {
        driver.findElement(emailField).sendKeys(email);

    }
    public void enterPassword(String password)
    {
        driver.findElement(passwordField).sendKeys(password);
    }
    public HomePage clickSignIn()
    {
        driver.findElement(signInBtn).click();
        return new HomePage(driver);
    }
}
