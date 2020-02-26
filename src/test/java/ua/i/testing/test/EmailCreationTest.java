package ua.i.testing.test;

import org.testng.annotations.Test;
import ua.i.testing.model.EmailData;

import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * created by FAMILY 18.07.2019
 */

public class EmailCreationTest extends TestBase {

    @Test(enabled = false)
    public void emailCreationTest() {
        app.goTo().drafts();
        List<EmailData> before = app.group().list1();
        EmailData emailData = new EmailData().withEmailAddress("dfsad@ukr.net");
        app.group().create(emailData);
        List<EmailData> after = app.group().list1();

        assertEquals(after.size(), before.size() + 1);


    }

}
