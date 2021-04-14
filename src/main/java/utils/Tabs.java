package utils;

import org.openqa.selenium.WebDriver;

public class Tabs {

    /* Método precisa ser tratado com try/catch? */
    public String closeAllSecondaryTabs(WebDriver driver) {
        String originalHandle = driver.getWindowHandle();

        for (String currentHandle : driver.getWindowHandles()) {
            if (!currentHandle.equals(originalHandle)) {
                driver.switchTo().window(currentHandle).close();
            }
        }

        return originalHandle;
    }
}
