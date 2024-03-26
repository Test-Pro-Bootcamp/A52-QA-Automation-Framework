import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ThemeTest extends BaseTest {

    @Test
    public void changeThemeTest() {
        String themeName = "Classic";
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("demo@class.com", "te$t$tudent");
        HomePage homePage = new HomePage(getDriver());
        homePage.getAvatar().click();
        ProfilePage profilePage = new ProfilePage(getDriver());
        profilePage.chooseThemByName(themeName);
        Assert.assertTrue(profilePage.isThemeSelected(themeName));
    }
}
