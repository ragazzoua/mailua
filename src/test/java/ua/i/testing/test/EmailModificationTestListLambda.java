package ua.i.testing.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.i.testing.model.EmailData;

import java.util.Comparator;
import java.util.List;

/**
 * created by FAMILY 23.07.2019
 */

public class EmailModificationTestListLambda extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().drafts();
        if (app.group().list().size() == 0) {
            app.group().create(new EmailData().withEmailAddress("fsfsdf@ukr.net"));
        }
    }

    @Test(enabled = false)
    public void emailModificationTest() {
        List<EmailData> before = app.group().list();
        int index = before.size() - 1;
        EmailData data = new EmailData().withId(before.get(before.size() -1).getId()).withEmailAddress("to2@ukr.net");
        app.group().modify(index, data);
        List<EmailData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(data);
        Comparator<? super EmailData> byId = (g1, g2) -> Integer.compare(Integer.parseInt(g1.getId()), Integer.parseInt(g2.getId()));
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
//Шаблон Билдер завершено рефакторинг

}
