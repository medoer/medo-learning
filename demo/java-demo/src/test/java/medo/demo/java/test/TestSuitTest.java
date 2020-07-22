package medo.demo.java.test;
import org.junit.Test;

public class TestSuitTest {

    @Test
    public void test() throws InterruptedException {
        int numberOfTests = 100;

        TestProperties testProperties = TestProperties.build(10, numberOfTests);
        TestSuit testSuit = new TestSuit(testProperties);

        testSuit.excute(new TestGetRequest("http://www.baidu.com"),
                new TestReport(numberOfTests));
    }

}
