package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage {

    WebDriver driver;

    By product = By.id("add-to-cart-sauce-labs-backpack");
    By cart = By.className("shopping_cart_link");

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    // Handle popup if present
    public void handlePopupIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println("Popup detected: " + alert.getText());
            alert.accept(); // Click OK
        } catch (NoAlertPresentException | org.openqa.selenium.TimeoutException e) {
            // No popup, continue
        }
    }

    // Select product with wait
    public void selectProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(product)).click();
    }

    public void goToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cart)).click();
    }
}