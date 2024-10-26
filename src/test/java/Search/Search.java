package Search;

import BaseTests.BaseTests;
import DDTClasses.MovieNameDataProvider;
import movieSearchResultsPage.movieSearchResultsPage;
import MoviePage.MoviePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Search extends BaseTests {

    @Test(dataProvider = "MovieData", dataProviderClass = MovieNameDataProvider.class)
    public MoviePage sendingTheMovieName(String movieName)
    {
            homePage.enterMovieName(movieName);
        movieSearchResultsPage movieResultsPage = homePage.clickSearch();
        movieResultsPage.getResultName();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(movieResultsPage.getResultName(), movieName);
        // Call softAssert.assertAll() to execute all assertions
        softAssert.assertAll();
        MoviePage moviePage =  movieResultsPage.chooseFirstResult();
        return moviePage;  // Return the MoviePage object for next testing class >> to prevent starting the steps all over again


    }
}
