package botsMp3Converser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import utils.Tabs;

import java.util.List;

public class Ytmp3 {

    public void requestSession(List<String> list) throws InterruptedException {
        //this.getGeckoBrowser();
        this.getChromeBrowser();
        //this.setChromeDriverSize();
        //this.getHeadlessChrome();

        ChromeOptions co = new ChromeOptions();
        //co.setHeadless(true);
        //co.addArguments("--disable-gpu");
        co.setCapability("download.default_directory",
                "C:\\Users\\Mateus\\OneDrive\\Documentos\\seleniumfiles");

        //WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver(co);


        for (String song : list) {
            driver.get("https://ytmp3.cc/en13/");

            WebElement videoUrl = driver.findElement(new By.ByName("video"));
            videoUrl.sendKeys(song);
            videoUrl.submit();

            while (true) {
                String downloadable = null;

                try {
                    downloadable = driver.findElement(new By.ByLinkText("Download")).getText();
                } catch (Exception e) {
                }

                if (downloadable != null && downloadable.contains("Download")) {
                    try {
                        WebElement downloadButton = driver.findElement(new By.ByLinkText("Download"));
                        new Actions(driver).moveToElement(downloadButton).click().perform();
                        System.out.println("Download foi iniciado: " + driver.findElement(new By.ById("title")).getText());
                    } catch (Exception e) {
                        System.out.println("Não foi possível baixar a música em arquivo .mp3: " + song);
                    }

                    String originalHandle = new Tabs().closeAllSecondaryTabs(driver);
                    driver.switchTo().window(originalHandle);

                    break;
                }

                /* Erro no servidor */
                if (driver.getPageSource().contains("An error occurred")) {
                    System.out.println("Um erro do servidor YTMP3 ocorreu para o link: " + song);
                    break;
                }
            }


        } //for

    }

    private void getChromeBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mateus\\OneDrive\\Documentos\\chromedriver88.exe");
    }

    private void getGeckoBrowser() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Mateus\\OneDrive\\Documentos\\geckodriver.exe");
    }

    private ChromeOptions getHeadlessChrome() {
        return new ChromeOptions().addArguments("--headless");
    }

    public void setChromeDriverSize() {
        new ChromeOptions().addArguments("--window-size=1920,1080");
    }
}
