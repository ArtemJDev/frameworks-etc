import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.testapp.Register;

public class RegisterTest {

    private Register register;


    @Before
    public void setUp() throws Exception {
        register = new Register();
    }

    @Test
    public void absentObjectReturnsNull() {
        Object something = register.get("absent");
        Assert.assertNull(something);
    }

    //can register new something
    @Test
    public void canRegisterSomethingAndRetrieve() {
        Object one = new Object();
        register.add("one", one);

        Object two = new Object();
        register.add("two", two);

        Object retrieveOne = register.get("one");
        Object retrieveTwo = register.get("two");
        //test equals also
        Assert.assertNotNull(retrieveOne);
        Assert.assertSame(one, retrieveOne);

        Assert.assertNotNull(retrieveTwo);
        Assert.assertSame(two, retrieveTwo);
    }
    //add medications without name
    @Test
    public void canRegisterByTypeAndRetrieve() {
        Pinicilin pinicilin = new Pinicilin();
        register.add(pinicilin);
        Purgative purgative = new Purgative();
        register.add(purgative);
        Pinicilin retrievePinicilin1 = register.get(Pinicilin.class);
        Purgative retrievePurgative1 = register.get(Purgative.class);

        Assert.assertSame(pinicilin, retrievePinicilin1);
        Assert.assertSame(purgative, retrievePurgative1);
    }


}
