import org.example.pages.LoginPage;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

@Test

public void addSongToPlaylist() {
    LoginPage page = new LoginPage(driver);
    page.login("dzmitry.kimber@testpro.io","1qAY76Rs");
    

}
}
