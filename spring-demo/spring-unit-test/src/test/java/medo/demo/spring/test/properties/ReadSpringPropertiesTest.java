package medo.demo.spring.test.properties;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 1. main 和 test 同时存在配置文件，尽管属性 key 值不同，只能读取到 main 目录下的配置。<br>
 * 2. main 和 test 同时存在配置文件，配置相同 key 值，读取 main 目录下的配置。<br>
 * 3. main 和 test 中只配置一个时，能正常获取。
 * 
 * @author: bryce
 * @date: 2020-08-11
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ReadSpringPropertiesTest {

    @Value("${main:default}")
    private String main;

    @Value("${test:default}")
    private String test;

    @Value("${main2:default}")
    private String main2;

    @Value("${test2:default}")
    private String test2;

    @Value("${test3:default}")
    private String test3;

    @Test
    public void testMainResources() {
        Assert.assertNotEquals(main, "default");
        Assert.assertEquals(test, "default");
    }

    @Test
    public void testTestResources() {
        Assert.assertEquals(test2, "default");
        Assert.assertEquals(main2, "default");
    }

    // 相同的 key 值，读取的是 main 下的文件
    @Test
    public void testSameKey() {
        Assert.assertEquals(test3, "test3");
    }

    /**
     * 只配置 test 目录下时，能够正确读取。
     */
    @Test
    public void onlyTestResources() {
//        Assert.assertEquals(test3, "test4");
    }
}
