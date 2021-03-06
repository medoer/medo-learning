package medo.algorithm.hash.consistent;

/**
 * a sample usage for routing a request to services based on requester ip
 */
public class MyServiceNode implements Node {

    private final String idc;
    private final String ip;
    private final int port;

    public MyServiceNode(String idc, String ip, int port) {
        this.idc = idc;
        this.ip = ip;
        this.port = port;
    }

    @Override
    public String getKey() {
        return idc + "-" + ip + ":" + port;
    }

    @Override
    public String toString() {
        return getKey();
    }

}