package ai.exaleap.common.util;


import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Http模拟请求
 */
@Slf4j
public final class HttpUtils {
    /**
     * HTTP请求URL与参数分隔符
     */
    public static final String HTTP_REQUEST_URL_SPLIT = "?";


    /**
     * 连接池
     */
    private static PoolingHttpClientConnectionManager poolingHttpClientConnectionManager;
    /**
     * 请求配置
     */
    private static RequestConfig requestConfig;
    /**
     * 从连接池获取连接时间
     */
    private static final int CONNECTION_REQUEST_TIMEOUT = 2 * 1000;
    /**
     * 连接建立的超时时间
     */
    private static final int CONNECTION_TIMEOUT = 2 * 1000;
    /**
     * 响应超时时间，超过此时间不再读取响应；客户端从服务器读取数据的超时时间
     */
    private static final int SOCKET_TIMEOUT = 10 * 1000;
    /**
     * 连接池大小
     */
    private static final int MAX_TOTAL = 200;
    /**
     * 默认编码
     */
    private static final String DEFAULT_ENCODING = "UTF-8";

    private HttpUtils() {
    }

    static {
        // 设置连接池
        poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
        // 设置连接池大小
        poolingHttpClientConnectionManager.setMaxTotal(MAX_TOTAL);
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(poolingHttpClientConnectionManager.getMaxTotal());

        RequestConfig.Builder configBuilder = RequestConfig.custom();
        // 设置连接超时
        configBuilder.setConnectTimeout(CONNECTION_TIMEOUT);
        // 设置读取超时
        configBuilder.setSocketTimeout(SOCKET_TIMEOUT);
        // 设置从连接池获取连接实例的超时
        configBuilder.setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT);
        // 在提交请求之前 测试连接是否可用
        //configBuilder.setStaleConnectionCheckEnabled(true);
        requestConfig = configBuilder.build();
    }


    /**
     * 发送 POST 请求（HTTP），不带输入数据
     *
     * @param url the url
     * @return string
     */
    public static String doPost(String url) {
        return doPost(url, new HashMap<String, Object>());
    }

    /**
     * 发送 POST 请求（HTTP），K-V形式
     *
     * @param url    API接口URL
     * @param params 参数map
     * @return string
     */
    public static String doPost(String url, Map<String, Object> params) {
        String result = null;
        System.out.println(url);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;

        try {
            httpPost.setConfig(requestConfig);
            List<NameValuePair> pairList = new ArrayList<>(params.size());
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                //过滤空值
                if (StringUtils.isEmpty(entry.getValue())) {
                    continue;
                }

                Object objVal = entry.getValue();
                String val = getValue(objVal);

                NameValuePair pair = new BasicNameValuePair(entry.getKey(), val);
                pairList.add(pair);
            }
            httpPost.setEntity(new UrlEncodedFormEntity(pairList, Charset.forName(DEFAULT_ENCODING)));
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity, DEFAULT_ENCODING);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
        return result;
    }

    /**
     * 发送 POST 请求（HTTP），JSON形式
     *
     * @param url  the url
     * @param json json字符串
     * @return string
     */
    public static String doPost(String url, String json) {
        String result = null;

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;

        try {
            httpPost.setConfig(requestConfig);
            StringEntity stringEntity = new StringEntity(json.toString(), DEFAULT_ENCODING); //解决中文乱码问题
            stringEntity.setContentEncoding(DEFAULT_ENCODING);
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            System.out.println(response.getStatusLine().getStatusCode());
            result = EntityUtils.toString(entity, DEFAULT_ENCODING);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
        return result;
    }

    public static String doGet(String url, Map<String, String> param) {

        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();

        String resultString = "";
        CloseableHttpResponse response = null;
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();

            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);

            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultString;
    }

    public static String doGet(String url) {
        return doGet(url, null);
    }


    /**
     * 值类型转化
     *
     * @param objVal 参数值
     * @return 转化后参数值
     */
    private static String getValue(Object objVal) {
        String val = null;

        if (objVal instanceof String) {
            val = String.valueOf(objVal);
        } else if (objVal instanceof String[]) {
            val = ((String[]) objVal)[0];
        } else {
            throw new IllegalArgumentException("map type is eroor, please use Map<String,String> or Map<String, String[])");
        }
        return val;
    }
}


