package MoviePageTests;
import BaseTests.BaseTests;
import DDTClasses.MovieNameDataProvider;
import MoviePage.MoviePage;
import Search.Search;
import WatchListPage.WatchListPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MoviePageTests extends BaseTests {

    private static MoviePage moviePage; /* defined in global scope to be able to use it in multiple
    tests using the same session from we left off in the previous one */


    @Test(dataProvider = "MovieData", dataProviderClass = MovieNameDataProvider.class)
    public void rateTest(String movieName)
    {
        //passing the session to the next test
        SoftAssert softAssert = new SoftAssert();
        Search searchTest = new Search();
        moviePage = searchTest.sendingTheMovieName(movieName);
        moviePage.openRatingPopUp();
        moviePage.rateMovie();
        softAssert.assertEquals(moviePage.getRateValue(), "10");
        softAssert.assertAll();
        moviePage.submitRating();



    }
    @Test(dependsOnMethods = {"rateTest"})
    public WatchListPage addToWatchListTests()
    {
        SoftAssert softAssert = new SoftAssert();

        moviePage.scrollToAddBtn();
        moviePage.addToWatchList();
        moviePage.scrollToTop();
        Assert.assertEquals(moviePage.getMovieCountInWatchlist(),"1");
        softAssert.assertAll();
        WatchListPage watchListPage = moviePage.openWatchList();
        return watchListPage;
    }



}
