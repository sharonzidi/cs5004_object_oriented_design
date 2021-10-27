import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LockerTest {
    private Recipient recipient1;
    private Mail mail1;
    private Locker locker1;

    @Before
    public void setUp() throws Exception {
        recipient1 = new Recipient("Sharon", "Xia", "a@b.com");
        mail1 = new Mail(2, 2, 2, recipient1);
        locker1 = new Locker(2, 2, 2);
    }

    @Test(expected = MailOverSizeException.class)
    public void addMail_widthOverSize() throws Exception {
        locker1.addMail(new Mail(3, 2, 2, recipient1));
    }

    @Test(expected = MailOverSizeException.class)
    public void addMail_heightOverSize() throws Exception {
        locker1.addMail(new Mail(2, 3, 2, recipient1));
    }

    @Test(expected = MailOverSizeException.class)
    public void addMail_depthOverSize() throws Exception {
        locker1.addMail(new Mail(2, 2, 3, recipient1));
    }

    @Test
    public void addMail_notOverSize() throws Exception {
        locker1.addMail(new Mail(2, 2, 2, recipient1));
    }

    @Test
    public void pickupMail_owner() throws Exception {
        locker1.addMail(mail1);
        assertEquals(true, locker1.pickupMail(recipient1).equals(mail1));
    }

    @Test
    public void pickupMail_notOwner() throws Exception {
        locker1.addMail(new Mail(2, 2, 2, recipient1));
        Recipient another = new Recipient("a", "b", "c");
        assertEquals(null, locker1.pickupMail(another));
    }
}