package medo.demo.java.core.other;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: yangcj
 * @Date: 2020/11/10 22:19
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        Domain domain = new Domain();
        domain.setName("ihfvf");
        Domain domain1 = new Domain();
        domain1.setName("ihfvf");
        Domain domain2 = new Domain();
        domain2.setName("ihfg");
        List<Domain> domains = Arrays.asList(domain, domain1, domain2);
        boolean repeat = new RemoveDuplicates().isRepeat(domains);
        System.out.println(repeat);
    }

    public boolean isRepeat(List<Domain> domains) {
        Set<String> collect = domains.stream().map(Domain::getName).collect(Collectors.toSet());
        return domains.size() != collect.size();
    }

    public static class Domain {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
