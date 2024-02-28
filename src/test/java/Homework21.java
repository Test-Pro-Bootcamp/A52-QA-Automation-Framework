import org.testng.annotations.Test;
import java.pages.HomePage;
import java.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Homework21 extends BaseTest {
    String newPlayListName = "New playlist";
    String currentPlayListName = "TestPro Playlist";
    HomePage homePage = null;

    @Test
    public void renamePlayListTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("demo@class.com", "te$t$tudent");
        homePage = new HomePage(driver);
        homePage.renamePlayList(currentPlayListName, newPlayListName);

        Assert.assertEquals(newPlayListName, homePage.getPlayListByName(newPlayListName).getText());
        //Assert.assertTrue(homePage.getPlaylistByName(newPlayListName).isDisplayed());
    }

    @AfterMethod
    public void rollBackChanges() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.renamePlayList(newPlayListName, currentPlayListName);
    }
}
