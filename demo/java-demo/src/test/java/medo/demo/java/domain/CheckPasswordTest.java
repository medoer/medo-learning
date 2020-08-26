package medo.demo.java.domain;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.junit.Assert;
import org.junit.Test;

public class CheckPasswordTest {

    @Test
    public void test() {
        String salt = "1";
        String password = "123456";
        String originPassword = DigestUtils.md5Hex(password + salt);
        CheckPassword checkPassword = new CheckPassword();
        boolean checkPassword2 = checkPassword.checkPassword(null, "123", originPassword);
        Assert.assertFalse(checkPassword2);
        boolean checkPassword3 = checkPassword.checkPassword(null, "123456", originPassword);
        Assert.assertTrue(checkPassword3);
    }

}
