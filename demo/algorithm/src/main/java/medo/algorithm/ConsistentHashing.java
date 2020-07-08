package medo.algorithm;

/**
 * Consistent Hashing.
 * 
 * @author bryce
 *
 */
public interface ConsistentHashing {

    public String getHash(String key);

    public String getServer(String host);

    public void addServer(String[] hosts);

    public void removeServer(String host);

    default void validParams(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
