package medo.demo.java.domain;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

public class CheckPassword {

    private String salt = "1";

    public boolean checkPassword(String id, String password, String originPassword) {
        if (StringUtils.isEmpty(password)) {
            return false;
        }
        String passwordCrypt = DigestUtils.md5Hex(password + salt);
        return passwordCrypt.equals(originPassword);
    }

}
