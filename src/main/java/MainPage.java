import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By singInButton = By.xpath("//header//a[contains(text(), 'Sign\\u00A0in')]");
    private By singUpButton = By.xpath("");
    private By usernameField = By.xpath("//input[@id='user[login]");
    private By emailField = By.xpath("//input[@id='user[email]");
    private By passwordField = By.xpath("//input[@id='user[password]");
    private By signUpForGitHubButton = By.xpath("");

    public void clickSingIn() {
        System.out.println(driver.findElement(singInButton));
    }


}
