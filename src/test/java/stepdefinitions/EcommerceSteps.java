package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ProductPage;
import pages.CartPage;
import pages.LoginPage;

import java.time.Duration;

public class EcommerceSteps {

    WebDriver driver;
    ProductPage productPage;
    CartPage cartPage;
    LoginPage loginPage;

    @Given("user launches the application")
    public void launchApp() {
        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com"); // your app URL

        // initialize page objects AFTER driver is ready
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    @And("user logs in with valid credentials")
    public void login() {
        loginPage.login("standard_user", "secret_sauce");

        // Handle popup if any
        productPage.handlePopupIfPresent();
    }

    @When("user selects a product")
    public void selectProduct() {
        productPage.selectProduct();
    }

    @And("user adds product to cart")
    public void addToCart() {
        productPage.goToCart();
    }

    @And("user proceeds to checkout")
    public void checkout() {
        cartPage.checkout();
    }

    @And("user enters checkout details")
    public void enterDetails() {
        // Your checkout code here
    }

    @Then("user completes the purchase")
    public void finish() {
        // Your purchase completion code here
        driver.quit(); // close browser at the end
    }
}