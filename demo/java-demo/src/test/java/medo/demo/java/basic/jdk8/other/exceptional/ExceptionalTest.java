//package medo.demo.java.basic.jdk8.other.exceptional;
//
//import medo.demo.java.basic.jdk8.lambda.Exceptional;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.Optional;
//
//public class ExceptionalTest {
//
//    @Test(expected = RuntimeException.class)
//    public void testOrElseThrow() {
//        Exceptional
//                .of("test", () -> {
//            throw new RuntimeException("inner exception");
//        }).orElseThrow(RuntimeException::new);
//    }
//
//    @Test
//    public void testOrElseThrowWithNoException() {
//        Exceptional.of("success", () -> {
//            System.out.println("test");
//        }).orElseThrow(() ->
//            new RuntimeException("else throw")
//        );
//    }
//
//    @Test
//    public void testOrElseGet() {
//        String originValue = "origin";
//        // expect return origin value;
//        String businessError = (String)Exceptional.of(originValue, () -> {
//            ;
//        }).orElseGet(() -> "other");
//        Assert.assertEquals("origin", businessError);
//        // expect return other value;
//        String businessError1 = (String)Exceptional.of(originValue, () -> {
//            throw new RuntimeException("business error");
//        }).orElseGet(() -> "other");
//        Assert.assertEquals("other", businessError1);
//    }
//
//    @Test
//    public void testOrElseGetClassWithGeneric() {
//        TestDomain<String> originValue = new TestDomain<>();
//        // expect return origin value;
//        TestDomain<String> businessError = (TestDomain<String>) Exceptional.of(originValue, () -> {
//            ;
//        }).orElseGet(TestDomain::new);
//
//        Assert.assertEquals(originValue, businessError);
//        // expect return other value;
//        TestDomain<Integer> testDomain = new TestDomain<>();
//        Object businessError1 = Exceptional.of(originValue, () -> {
//            throw new RuntimeException("business error");
//        }).orElseGet(() -> testDomain);
//        Assert.assertEquals(testDomain, businessError1);
//    }
//
//}
