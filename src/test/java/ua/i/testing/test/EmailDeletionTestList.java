package ua.i.testing.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.i.testing.model.EmailData;

import java.util.List;

/**
 * created by FAMILY 21.07.2019
 */

public class EmailDeletionTestList extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().drafts();
        if (!app.group().isThereDraft()) {
            app.group().create(new EmailData().withEmailAddress("sdfsdf@ukr.net").withEmailText(null));
        }
    }

    @Test
    public void emailDeletionTest() {
        List<EmailData> before = app.group().list();
        app.group().selectEmail(before.size() - 1);
        app.group().deleteSelectedEmails();
        app.acceptAlert();
        app.goTo().drafts();
        List<EmailData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);

        Assert.assertEquals(before, after);


    }

}
