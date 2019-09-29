package ua.i.testing.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.i.testing.model.EmailData;

import java.util.Set;

/**
 * created by FAMILY 18.07.2019
 */

public class EmailCreationTestSet extends TestBase {

    @Test
    public void emailCreationTestSet() {
        app.goTo().drafts();
        Set<EmailData> before = app.group().all();
        EmailData emailData = new EmailData().withEmailAddress("dfsad@ukr.net");
        app.group().create(emailData);
        Set<EmailData> after = app.group().all();
        //before.add(emailData);

        Assert.assertEquals(after.size(), before.size() + 1);


    }

}
