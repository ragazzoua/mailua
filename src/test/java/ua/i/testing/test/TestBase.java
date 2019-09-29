package ua.i.testing.test;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ua.i.testing.appmanager.ApplicationManager;

/**
 * created by FAMILY 21.07.2019
 */

public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);
/*
BeforeMethod запускается перед каждым тестовым методом
BeforeClass запускается один раз перед всеми тестовыми методами
BeforeGroups запускается перед тестами которые входят в одну группу
BeforeSuite сьют всегда один а тестов может быть несколько используется для конф файла / запускает один екземпляр браузера


    */
    @BeforeSuite
    public void setup() throws Exception {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

    public ApplicationManager getApp() {
        return app;
    }
}
