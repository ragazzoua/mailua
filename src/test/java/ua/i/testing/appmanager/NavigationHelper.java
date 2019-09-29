package ua.i.testing.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * created by FAMILY 21.07.2019
 */

public class NavigationHelper extends HelperBase{


    public NavigationHelper(WebDriver driver) {
        super(driver);

    }

    public void drafts() {
        click(By.xpath("//ul[@class='list_underlined']/li[3]/a"));
    }
}
