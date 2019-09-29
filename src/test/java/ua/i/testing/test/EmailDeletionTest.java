package ua.i.testing.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.i.testing.model.EmailData;

/**
 * created by FAMILY 21.07.2019
 */

public class EmailDeletionTest extends TestBase {

    @Test
    public void emailDeletionTest() {
        app.goTo().drafts();
        if (!app.group().isThereDraft()) {
            app.group().create(new EmailData().withEmailAddress("sdfsfffdf@ukr.net").withEmailText("dsfsdf"));
        }
        int before = app.group().getGroupCount();
        app.group().selectEmail(before - 1);
        app.group().deleteSelectedEmails();
        app.acceptAlert();
        app.goTo().drafts();
        int after = app.group().getGroupCount();
        Assert.assertEquals(after, before - 1);

    }

}
