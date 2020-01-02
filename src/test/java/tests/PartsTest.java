package tests;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class PartsTest {

    @Test
    public void appiumTest() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "My Mobile Device");
        caps.setCapability("udid", "ce0918296281ba1901");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "8");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "pl.otomoto");
        caps.setCapability("appActivity", "com.fixeads.verticals.cars.startup.view.activities.StartupActivity");
        caps.setCapability("browserName", "");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

        FluentWait<MobileDriver> wait = new FluentWait<>((MobileDriver) driver)
                .pollingEvery(Duration.ofMillis(500))
                .withTimeout(Duration.ofSeconds(30))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NullPointerException.class)
                .ignoring(ClassCastException.class);

        int przerwa=2;

        Poczekaj(przerwa);

        Kliknij("CZĘŚCI", driver);

        Poczekaj(przerwa);

        Kliknij("Zastosowanie", driver);

        Poczekaj(przerwa);

        Kliknij("Części do pojazdów dostawczych", driver);

        Poczekaj(przerwa);

        Kliknij("WIĘCEJ PARAMETRÓW", driver);

        Poczekaj(przerwa);

        verticalSwipeByPercentages(0.70,0.20,0.50, driver);

        Kliknij("Rodzaj części", driver);

        Poczekaj(przerwa);

        Kliknij("Felgi", driver);

        Poczekaj(przerwa);

        //do testow testu
        //Kliknij("Felgi", driver);
        //Poczekaj(3);
        //Kliknij("Tuning", driver);
        //Poczekaj(3);

        Kliknij("Marka pojazdu", driver);

        Poczekaj(przerwa);

        Wpisz("Szukaj Marka pojazdu","Merc", driver);

        Poczekaj(przerwa);

        Kliknij("Mercedes-Benz", driver);

        Poczekaj(przerwa);

        Kliknij("Pokaż wyniki", driver);

        Poczekaj(przerwa);

        verticalSwipeByPercentages(0.30,0.90,0.50, driver);

        Poczekaj(przerwa);

        Kliknij("PLN", driver);

    }

    private void Poczekaj(int czas) {
        try {
            Thread.sleep(czas *1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    private void Kliknij(String tekst, AndroidDriver driver) {
        WebElement element = driver.findElement(By.xpath("//*[@text='" + tekst + "']"));
        if (element.isDisplayed()) {
            element.click();
        }
    }
    private void Wpisz(String tekst, String wpisz, AndroidDriver driver) {
        WebElement element = driver.findElement(By.xpath("//*[@text='" + tekst + "']"));
        if (element.isDisplayed()) {
            element.sendKeys(wpisz);
        }
    }
    //pozyczone z internetow
    public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage, AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);

        new TouchAction(driver)
                .press(PointOption.point(anchor, startPoint))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(anchor, endPoint))
                .release().perform();
    }
}
