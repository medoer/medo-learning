package medo.demo.java.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class TestReport extends BaseTestReport {

    private int numberOfTests;

    public TestReport(int numOfTests) {
        this.numberOfTests = numOfTests;
    }

    @Override
    public void calResult(List<Future<BaseResponse>> results) {

        // 取出每次的请求的响应时间
        List<Long> list = new ArrayList<>();
        try{
            for (Future<BaseResponse> item: results) {
                BaseResponse result = item.get();
                list.add(result.getResponseTime());
            }
        } catch (ExecutionException | InterruptedException ignored) {
            ignored.printStackTrace();
        }


        // 按大小排序
        list.sort(Comparator.comparingLong(Long:: longValue));

        // 求 95% 响应时间 序号
        int ninetyFiveRT = BigDecimal.valueOf(numberOfTests).multiply(BigDecimal.valueOf(0.95D)).setScale(0, BigDecimal.ROUND_UP).intValue();

        // 求 平均响应时间
        double avgRt = list.stream().mapToLong(Long::longValue).average().getAsDouble();

        // 打印出测试结果
        System.out.println("平均响应时间： " + BigDecimal.valueOf(avgRt).setScale(0, BigDecimal.ROUND_UP) + ";");
        System.out.println("95% 响应时间： " + list.get(ninetyFiveRT) + ";");
    }

}
