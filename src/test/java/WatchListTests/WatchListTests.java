package WatchListTests;

import DDTClasses.MovieNameDataProvider;
import MoviePageTests.MoviePageTests;
import WatchListPage.WatchListPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WatchListTests {
    private WatchListPage watchlistPage;

    @Test(dataProvider = "MovieData", dataProviderClass = MovieNameDataProvider.class)
    public void testMoviePresence(String movieName)
    {
        MoviePageTests moviePageTests = new MoviePageTests();  // Pass WebDriver instance
        watchlistPage = moviePageTests.addToWatchListTests();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(watchlistPage.getMovieName(), movieName);
        watchlistPage.removeMovieFromList();
        watchlistPage.autoRefresh();
        softAssert.assertEquals(watchlistPage.getEmptyListConfirmation(), "This list is empty.");
        softAssert.assertAll();

    }
}