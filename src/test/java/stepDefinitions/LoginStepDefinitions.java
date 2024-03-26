package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class LoginStepDefinitions {

    WebDriver driver;

//    @Given("I open browser")
    @Before
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
    }

    @When("I open login page")
    public void iOpenLoginPage() {
        driver.get("https://qa.koel.app");
    }

    @And("I enter email {string}")
    public void iEnterEmail(String arg0) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(arg0);

    }


    @And("I enter password {string}")
    public void iEnterPassword(String arg0) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(arg0);
//        driver.findElement(By.cssSelector("[type='password']")).sendKeys(arg0);
    }

    @And("I submit")
    public void iSubmit() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmit();
//        driver.findElement(By.cssSelector("[type='submit']")).click();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getAvatar().isDisplayed());
    }

//    @And("I close browser")
    @After
    public void iCloseBrowser() {
        driver.quit();
    }
}
