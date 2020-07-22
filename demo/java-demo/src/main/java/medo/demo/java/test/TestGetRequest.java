package medo.demo.java.test;

import java.io.IOException;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * 测试case类
 * @author Lee
 */
public class TestGetRequest extends BaseTestCase {

    /**
     * 测试用 url
     */
    private String url;

    public TestGetRequest(String url) {
        this.url = url;
    }

    /**
     * 请求执行
     *
     * @return  Result
     */
    @Override
    public BaseResponse execution() {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建Get请求
        HttpGet httpGet = new HttpGet(this.url);

        long t1 = System.currentTimeMillis();
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }

        long t2 = 0L;
        BaseResponse result = new BaseResponse();
        // 访问成功
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            t2 = System.currentTimeMillis();
            result.setResponseTime(t2 -t1);
            result.setSuccess(true);
        }
        // 访问失败
        else {
            t2 = System.currentTimeMillis();
            result.setResponseTime(t2 -t1);
            result.setSuccess(false);
        }

        return result;
    }

    @Override
    public Object call() throws Exception {
        return execution();
    }
}
