import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSongTest() throws InterruptedException {

        login("demo@class.com", "te$t$tudent");
        WebElement allSongsButton = driver.findElement(By.cssSelector("[#sidebar > section.music > ul > li:nth-child(3) > a]"));
        Thread.sleep(3000);
        allSongsButton.click();
        WebElement songPluto = driver.findElement(By.cssSelector("//div/div[1]/section[1]/ol/li[1]/article/span[2]/span[1]/text()"));
        songPluto.click();
        WebElement nextSongButton = driver.findElement(By.cssSelector("[data-testid='play-next-btn']"));
        nextSongButton.click();
        WebElement soundbar = driver.findElement(By.cssSelector("[data-test='sound-bars']"));
        Assert.assertTrue(songPluto.isDisplayed());




    }

}
