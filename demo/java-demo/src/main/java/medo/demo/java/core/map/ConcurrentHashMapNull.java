package medo.demo.java.core.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap & HashTable 不能使用 null 做为 key 或者 value。
 * 
 * @author: bryce
 * @date: 2020-09-12
 */
public class ConcurrentHashMapNull {

    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        try {
            map.put(null, null);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}
