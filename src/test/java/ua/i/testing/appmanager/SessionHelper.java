package ua.i.testing.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * created by FAMILY 21.07.2019
 */

public class SessionHelper extends HelperBase {


    public SessionHelper(WebDriver driver) {
        super(driver);

    }

    public void login(String username, String password) {
        type(By.name("login"), username);
        type(By.name("pass"), password);
        click(By.xpath("//input[@type='submit' and @value='Войти']"));
    }
}
