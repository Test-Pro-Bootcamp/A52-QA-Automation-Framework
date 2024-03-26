import org.example.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Hw18 extends BaseTest {
    @Test
    public void playSongTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("dzmitry.kimber@testpro.io", "1qAY76Rs");
        WebElement song = getDriver().findElement(By.xpath("//ol[@class=\"top-song-list\"]/li[1]"));
        song.click();
        Assert.assertTrue(song.isDisplayed());
    }
}
