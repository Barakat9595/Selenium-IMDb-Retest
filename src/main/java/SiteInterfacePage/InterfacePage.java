package SiteInterfacePage;

import HomePage.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import logInMethodPage.logInMethodPage;  //importing the other class as it's not in the same directory

public class InterfacePage {
    private WebDriver driver;
    public InterfacePage(WebDriver driver)
    {
        this.driver = driver;
    }

    private By signInBtn = By.xpath("/html/body/div[2]/nav/div[2]/div[5]/a/span[text()=\"Sign In\"]");

    public logInMethodPage clickSignIn()
    {
        driver.findElement(signInBtn).click();
        return new logInMethodPage(driver);
        /* this is the step where the page is switched as it does return another type
        there for another page */
    }
    public  HomePage directSignIn()
    {
        driver.findElement(signInBtn).click();
        return new HomePage(driver);
        /* this is the step where the page is switched as it does return another type
        there for another page */
    }

}
