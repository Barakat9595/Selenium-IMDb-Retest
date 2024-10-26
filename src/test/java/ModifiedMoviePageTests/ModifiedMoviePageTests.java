package ModifiedMoviePageTests;

import DDTClasses.MovieNameDataProvider;
import ModifiedBaseTests.ModifiedBaseTests;
import MoviePage.MoviePage;
import movieSearchResultsPage.movieSearchResultsPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ModifiedMoviePageTests extends ModifiedBaseTests {


    @Test(dataProvider = "MovieData", dataProviderClass = MovieNameDataProvider.class)
    public void rateTest(String movieName)
    {
        SoftAssert softAssert = new SoftAssert();
        homePage.enterMovieName(movieName); //inherits the home page from the baseTets
        movieSearchResultsPage movieResultsPage = homePage.clickSearch();
        MoviePage moviePage =  movieResultsPage.chooseFirstResult();
        moviePage.openRatingPopUp();
        moviePage.rateMovie();
        softAssert.assertEquals(moviePage.getRateValue(), "10");

        moviePage.submitRating();
        softAssert.assertAll();

    }

    @Test(dataProvider = "MovieData", dataProviderClass = MovieNameDataProvider.class)
    public void addToWatchListTests(String movieName)
    {
        SoftAssert softAssert = new SoftAssert();
        homePage.enterMovieName(movieName); //inherits the home page from the baseTets
        movieSearchResultsPage movieResultsPage = homePage.clickSearch();
        MoviePage moviePage =  movieResultsPage.chooseFirstResult();
        moviePage.calmDown();
        moviePage.scrollToAddBtn();
        moviePage.addToWatchList();
        moviePage.scrollToTop();
        softAssert.assertEquals(moviePage.getMovieCountInWatchlist(), "1");
        softAssert.assertAll();



    }

}
