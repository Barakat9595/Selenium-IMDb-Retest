package ModifiedSearchTests;

import DDTClasses.MovieNameDataProvider;
import HomePage.HomePage;
import ModifiedBaseTests.ModifiedBaseTests;
import org.testng.annotations.Test;
import movieSearchResultsPage.movieSearchResultsPage;
import org.testng.asserts.SoftAssert;

public class ModifiedSearchTests extends ModifiedBaseTests {

    @Test(dataProvider = "MovieData", dataProviderClass = MovieNameDataProvider.class)
    public void sendingMovieName(String movieName)
    {
        homePage.enterMovieName(movieName);
        movieSearchResultsPage movieResultsPage = homePage.clickSearch();
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(movieResultsPage.getResultName(), movieName);
        // Call softAssert.assertAll() to execute all assertions
        soft.assertAll();

    }


}
