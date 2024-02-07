package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    By avatar = By.cssSelector("#userBadge img");
    By addPlayListButton = By.cssSelector("#playlists i[role='button']");
    By createPlayListButton = By.cssSelector("[data-testid='playlist-context-menu-create-simple']");
    By playListNameInput = By.cssSelector("[name='create-simple-playlist-form']>input");


    public HomePage(WebDriver existDriver) {
        super(existDriver);
    }

    public WebElement getAvatar() {
        return findElement(avatar);
    }

    public WebElement getAddPlaylistButton(WebDriverWait wait) {
        return waitAndFindWebElement(wait, addPlayListButton);
    }

    public WebElement getCreatePlaylistButton(WebDriverWait wait) {
        return waitAndFindWebElement(wait, createPlayListButton);
    }

    public WebElement getPlaylistNameInput(WebDriverWait wait) {
        return waitAndFindWebElement(wait, playListNameInput);
    }

    public void createPlaylist(Actions actions, WebDriverWait wait, String playlistName) {
        actions.moveToElement(getAddPlaylistButton(wait)).perform();
        getAddPlaylistButton(wait).click();
        getCreatePlaylistButton(wait).click();
        getPlaylistNameInput(wait).sendKeys(playlistName);
        getPlaylistNameInput(wait).sendKeys(Keys.ENTER);
    }

    public WebElement getPlaylistByName(String playlistName) {
        return findElement(By.xpath(String.format("//section[@id='playlists']//li/a[text()='%s']", playlistName)));
    }

    public void openPlayList(String playlistName) {
        getPlaylistByName(playlistName).click();
    }
}
