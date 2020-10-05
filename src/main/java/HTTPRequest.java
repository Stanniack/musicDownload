import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.CookieManager;
import com.gargoylesoftware.htmlunit.html.*;
import okio.Timeout;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;


public class HTTPRequest {

    public void downloadFileByUrlAndFile(String urlContent, String fileDirectory) {

        try {

            URL url = new URL(urlContent);
            System.out.println(url.getPath());
            File file = new File(fileDirectory);
            FileUtils.copyURLToFile(url, file);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void RequestSessionHtmlUnit() {
        /* Simulação de um browser por HtmlUnit */
        final WebClient webClient = new WebClient(BrowserVersion.CHROME);

        /* Desabilita o JS e o CSS da página */
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setCssEnabled(false);

        /* cookieManager para gerenciar os dados da sessão */
        CookieManager cookieManager = new CookieManager();
        cookieManager = webClient.getCookieManager();

        /* Requisição de dados */
        try {

            HtmlPage page = webClient
                    .getPage("");
            System.out.println(page.toString());


            /* Recupera o formulário por nome ou todos*/
            HtmlForm form = page.getFormByName("");

            /* Atribui os dados de acordo com a tag */
            HtmlTextInput textInput = form.getInputByName("");
            HtmlPasswordInput passwordInput = form.getInputByName("");
            textInput.setValueAttribute("");
            passwordInput.setValueAttribute("");

            /* Simula o click */
            final HtmlPage answerPage = (HtmlPage) form.getInputByValue("").click();

            /* Retorna o resultado*/
            //answerPage.getWebResponse();
            String result = webClient.getPage("").getWebResponse().getContentAsString();
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void RequestSessionFlvto() {
        this.getChromeBrowser();
        WebDriver driver = new ChromeDriver();
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setCapability("chrome.switches", Arrays.asList("--disable-javascript"));
        driver.get("https://www.flvto.biz/pt78/");

        WebElement videoUrl = driver.findElement(new By.ByName("video_url"));
        videoUrl.sendKeys("https://www.youtube.com/watch?v=weeI1G46q0o");
        videoUrl.submit();

        /* Espera carregamento da página */
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*Simula click*/
//        List<WebElement> buttonElements = driver.findElements(new By.ByTagName("button"));
//        for(WebElement e : buttonElements){
//            try {
//                new Actions(driver).moveToElement(e).click().perform();
//            }catch (Exception exc){
//                System.out.println("Botão não clicável: " + exc);
//                System.out.println("____");
//            }
//        }
        WebElement downloadLink = driver.findElement(new By.ByXPath("//*[@id=\"__next\"]/div[1]/section[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[2]/button"));
        downloadLink.submit();


    }

    public void RequestSessionYtmp3(String url) throws InterruptedException {
        this.getChromeBrowser();
        this.setChromeDriverSize();
        WebDriver driver = new ChromeDriver();
        new ChromeOptions().setCapability("download.default_directory", "C:\\Users\\Mateus\\OneDrive\\Documentos\\seleniumfiles");
        driver.get("https://ytmp3.cc/en13/");

        WebElement videoUrl = driver.findElement(new By.ByName("video"));
        videoUrl.sendKeys(url);
        videoUrl.submit();

        /* Cooldown tempo servidor */
        Thread.sleep(10000);

        /* Erro no servidor */
        if (driver.getPageSource().contains("An error occurred")) {
            System.out.println("Não foi possível baixar a música em arquivo .mp3");
        } else {

            try {
                WebElement downloadButton = driver.findElement(new By.ByLinkText("Download"));
                new Actions(driver).moveToElement(downloadButton).click().perform();
                System.out.println("Download foi iniciado: " + driver.findElement(new By.ById("title")).getText());
            } catch (Exception e) {
                System.out.println("Não foi possível baixar a música em arquivo .mp3");
            }

        }

        /* Se fechar o download para */
        // driver.close();

    }

    public void RequestSessionYtmp3(List<String> list) throws InterruptedException {
        this.getChromeBrowser();
        this.setChromeDriverSize();
        WebDriver driver = new ChromeDriver();
        new ChromeOptions().setCapability("download.default_directory", "C:\\Users\\Mateus\\OneDrive\\Documentos\\seleniumfiles");

        for (String song : list) {
            //driver.findElement(new By.ByCssSelector("body")).sendKeys(Keys.CONTROL + "t");
            driver.get("https://ytmp3.cc/en13/");

            WebElement videoUrl = driver.findElement(new By.ByName("video"));
            videoUrl.sendKeys(song);
            videoUrl.submit();

            /* Cooldown tempo servidor */
            Thread.sleep(10000);

            /* Erro no servidor */
            if (driver.getPageSource().contains("An error occurred")) {
                System.out.println("Não foi possível baixar a música em arquivo .mp3");
            } else {

                try {
                    WebElement downloadButton = driver.findElement(new By.ByLinkText("Download"));
                    new Actions(driver).moveToElement(downloadButton).click().perform();
                    System.out.println("Download foi iniciado: " + driver.findElement(new By.ById("title")).getText());
                } catch (Exception e) {
                    System.out.println("Não foi possível baixar a música em arquivo .mp3");
                }

                String originalHandle = this.closeTabs(driver);
                driver.switchTo().window(originalHandle);

            }

        } //for


    }

    public void RequestSessionMp3Youtube() throws InterruptedException {
        this.getChromeBrowser();
        new ChromeOptions().addArguments("download.default_directory", "C:\\Users\\Mateus\\OneDrive\\Documentos\\seleniumfiles");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mp3-youtube.download/pt/nice-audio-converter");

        WebElement videoUrl = driver.findElement(new By.ByName("url"));
        videoUrl.sendKeys("https://www.youtube.com/watch?v=7tXCo-fl59M");
        WebElement button = driver.findElement(new By.ByXPath("//*[@id=\"app\"]/div/article/div/div/div/button"));
        button.click();

        /* Espera carregamento da página */
        Thread.sleep(15000);

        WebElement downloadButton = driver.findElement(
                new By.ByXPath("//*[@id=\"app\"]/div/article/div/p[2]/button"));
        /* método evita a sobreposição de elementos JS */
        new Actions(driver).moveToElement(downloadButton).click().perform();

        /* Fecha abas adicionais e pega a aba original */
        String originalHandle = this.closeTabs(driver);

        /* Volta para a página original */
        driver.switchTo().window(originalHandle);
        System.out.println(driver.getCurrentUrl());

        WebElement downloadButton2 = driver.findElement(
                new By.ByXPath("//*[@id=\"app\"]/div/article/div/p[2]/button"));
        new Actions(driver).moveToElement(downloadButton2).click().perform();

    }

    private String closeTabs(WebDriver driver) {
        String originalHandle = driver.getWindowHandle();

        for (String currentHandle : driver.getWindowHandles()) {
            if (!currentHandle.equals(originalHandle)) {
                driver.switchTo().window(currentHandle).close();
            }
        }

        return originalHandle;
    }

    private void getChromeBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mateus\\OneDrive\\Documentos\\chromedriver85.exe");
    }

    private ChromeOptions getHeadlessChrome() {
        return new ChromeOptions().addArguments("--headless");
    }

    public void setChromeDriverSize() {
        new ChromeOptions().addArguments("--window-size=1920,1080");
    }


}
