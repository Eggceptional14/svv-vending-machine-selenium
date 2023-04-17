package th.ac.kmitl.se;

import org.graphwalker.java.annotation.AfterExecution;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SystemTest {
    static WebDriver driver;
    
    @BeforeAll
    static public void setUp() {
        WebDriverManager.safaridriver().setup();
        // ChromeOptions options = new ChromeOptions();
        // options.addArguments("--remote-allow-origins=*");
        driver = new SafariDriver();
        driver.get("https://fekmitl.pythonanywhere.com/kratai-bin");
    }

    @AfterAll
    static public void tearDown() {
        driver.quit();
    }

    @Test
    public void test_flow_1() throws InterruptedException{
        System.out.println("Test 1");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("start")));
        driver.findElement(By.id("start")).click();
        wait.until(ExpectedConditions.urlToBe("https://fekmitl.pythonanywhere.com/kratai-bin/order"));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("add_tum_thai")));
        driver.findElement(By.id("add_tum_thai")).click();
        driver.findElement(By.id("add_tum_thai")).click();
        driver.findElement(By.id("add_tum_thai")).click();
        driver.findElement(By.id("add_tum_thai")).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(1000);

        driver.findElement(By.name("btn_check_out")).click();
        Thread.sleep(1000);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("btn_change")));
        driver.findElement(By.name("btn_change")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("btn_cancel")));
        driver.findElement(By.name("btn_cancel")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("start")));
        driver.findElement(By.id("start")).click();
        wait.until(ExpectedConditions.urlToBe("https://fekmitl.pythonanywhere.com/kratai-bin/order"));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("add_tum_thai")));
        driver.findElement(By.id("add_tum_thai")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("add_tum_poo")));
        driver.findElement(By.id("add_tum_poo")).click();

        driver.findElement(By.name("btn_check_out")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("btn_confirm")));
        driver.findElement(By.name("btn_confirm")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("btn_pay")));
        driver.findElement(By.name("btn_pay")).click();
        Thread.sleep(1000);

        WebElement txtCreditCardNum = driver.findElement(By.name("txt_credit_card_num"));
        WebElement txtNameOnCard = driver.findElement(By.name("txt_name_on_card"));
        txtCreditCardNum.sendKeys("1234567890");
        txtNameOnCard.sendKeys("MR JOHN DOE");
        driver.findElement(By.name("btn_pay")).click();
        Thread.sleep(1000);

        wait.until(ExpectedConditions.elementToBeClickable(By.tagName("img")));
        WebElement imageTumThaiElement = driver.findElement(By.className("ImgTumThai"));
        WebElement imageTumPooElement = driver.findElement(By.className("ImgTumPoo"));

        imageTumPooElement.click();
        imageTumThaiElement.click();

        driver.quit();
    }

    @Test
    public void test_flow_2() throws InterruptedException {
        System.out.println("Test 2");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("start")));
        driver.findElement(By.id("start")).click();
        wait.until(ExpectedConditions.urlToBe("https://fekmitl.pythonanywhere.com/kratai-bin/order"));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("add_tum_thai")));
        driver.findElement(By.id("add_tum_thai")).click();

        driver.findElement(By.name("btn_check_out")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("btn_confirm")));
        driver.findElement(By.name("btn_confirm")).click();
        Thread.sleep(1000);

        WebElement txtCreditCardNum = driver.findElement(By.name("txt_credit_card_num"));
        WebElement txtNameOnCard = driver.findElement(By.name("txt_name_on_card"));
        txtCreditCardNum.sendKeys("1234567890");
        txtNameOnCard.sendKeys("MR JOHN DOE");
        driver.findElement(By.name("btn_pay")).click();
        Thread.sleep(1000);

        wait.until(ExpectedConditions.elementToBeClickable(By.tagName("img")));

        Thread.sleep(1000*12);

        driver.quit();
    }
}