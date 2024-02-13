import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.input.Input;
import org.openqa.selenium.support.ui.ExpectedConditions;


import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSongTest() throws InterruptedException {
        String songName = "Pluto";
        login("demo@class.com", "te$t$tudent");
        WebElement allSongs = driver.findElement(By.xpath("//*[@id='sidebar']/section[1]/ul/li[3]/a"));
        allSongs.click();
        Thread.sleep(2000);

        WebElement searchSong = driver.findElement(By.cssSelector("#searchForm>input[type='search']"));
        searchSong.click();
        searchSong.sendKeys(songName, Keys.ENTER);

        WebElement firstSong = driver.findElement(By.xpath("//*[@id='searchExcerptsWrapper']/div/div/section[1]/ul/article"));
        firstSong.click();
        Thread.sleep(2000);

        WebElement soundBar = driver. findElement(By.xpath("//*[@id='mainFooter']/div[2]/div[2]/div"));
        Assert.assertTrue(soundBar.isDisplayed());

    }

}
