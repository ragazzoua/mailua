package ua.i.testing.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.i.testing.model.EmailData;

import java.util.Comparator;
import java.util.List;

/**
 * created by FAMILY 18.07.2019
 */

public class EmailCreationTestLambda extends TestBase {

    @Test(enabled = false)
    public void emailCreationTest() {
        app.goTo().drafts();
        List<EmailData> before = app.group().list();
        EmailData emailData = new EmailData().withEmailAddress("sdfsdf@ukr.net").withEmailText("dsfsdf");
        app.group().create(emailData);
        List<EmailData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size() + 1);

        emailData.withId(String.valueOf(Integer.parseInt(after.stream().max((o1, o2) -> Integer.compare(Integer.parseInt(o1.getId()), Integer.parseInt(o2.getId()))).get().getId())));
        before.add(emailData);
        Comparator<? super EmailData> byId = (g1, g2) -> Integer.compare(Integer.parseInt(g1.getId()), Integer.parseInt(g2.getId()));
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);


    }

}
