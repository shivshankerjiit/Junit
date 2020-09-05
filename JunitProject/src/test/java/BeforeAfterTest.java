import org.junit.*;

public class BeforeAfterTest {
    @BeforeClass
    public static void beforeClass(){
        System.out.println("before class test");
    }
    @Before
    public void before(){
        System.out.println("before test");
    }
    @Test
    public void test1(){
        System.out.println("test 1");
    }
    @Test
    public void test2(){
        System.out.println("test 2");
    }
    @After
    public void after(){
        System.out.println("after test");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("after class test");
    }
}
