import org.example.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class hw19 extends BaseTest {

    @Test

    public void deletePlaylist() {

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("dzmitry.kimber@testpro.io", "1qAY76Rs");
        WebElement Playlist =  getDriver().findElement(By.cssSelector("[class='playlist playlist']"));
        WebElement Delete = getDriver().findElement(By.cssSelector("[data-testid='playlist-context-menu-delete-86853']"));
        Delete.click();
        Assert.assertTrue(Delete.isDisplayed());
    }

}
