package medo.algorithm.consistent.hash;

import java.util.Arrays;

import org.junit.Test;

import medo.algorithm.hash.consistent.ConsistentHashRouter;
import medo.algorithm.hash.consistent.MyServiceNode;

public class ConsistentHashingTest {

    @Test
    public void testConsistentHashing() {
        // initialize 4 service node
        MyServiceNode node1 = new MyServiceNode("IDC1", "127.0.0.1", 8080);
        MyServiceNode node2 = new MyServiceNode("IDC1", "127.0.0.1", 8081);
        MyServiceNode node3 = new MyServiceNode("IDC1", "127.0.0.1", 8082);
        MyServiceNode node4 = new MyServiceNode("IDC1", "127.0.0.1", 8084);

        // hash them to hash ring
        ConsistentHashRouter<MyServiceNode> consistentHashRouter = new ConsistentHashRouter<>(
                Arrays.asList(node1, node2, node3, node4), 10);// 10 virtual node

        // we have 5 requester ip, we are trying them to route to one service node
        String requestIP1 = "192.168.0.1";
        String requestIP2 = "192.168.0.2";
        String requestIP3 = "192.168.0.3";
        String requestIP4 = "192.168.0.4";
        String requestIP5 = "192.168.0.5";

        goRoute(consistentHashRouter, requestIP1, requestIP2, requestIP3, requestIP4, requestIP5);

        MyServiceNode node5 = new MyServiceNode("IDC2", "127.0.0.1", 8080);// put new service online
        System.out.println("-------------putting new node online " + node5.getKey() + "------------");
        consistentHashRouter.addNode(node5, 10);

        goRoute(consistentHashRouter, requestIP1, requestIP2, requestIP3, requestIP4, requestIP5);

        consistentHashRouter.removeNode(node3);
        System.out.println("-------------remove node online " + node3.getKey() + "------------");
        goRoute(consistentHashRouter, requestIP1, requestIP2, requestIP3, requestIP4, requestIP5);

    }

    private static void goRoute(ConsistentHashRouter<MyServiceNode> consistentHashRouter, String... requestIps) {
        for (String requestIp : requestIps) {
            System.out.println(requestIp + " is route to " + consistentHashRouter.routeNode(requestIp));
        }
    }
}
