package opst.we.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import java.io.IOException;

/**
 * @author: chgj
 * @description:
 * @date: create in 2017/11/13 13:41
 * @modified:
 */
public class HttpsClientSSL {
    private static final Logger logger = LoggerFactory.getLogger(HttpsClientSSL.class);
    public static CloseableHttpClient httpClient = null;
    public static RequestConfig requestConfig = null;

    static {
        init();
    }

    private static void init() {
        // 配置超时时间（连接服务端超时10秒，请求数据返回超时10秒）
        requestConfig = RequestConfig.custom().setConnectTimeout(200 * 10).setSocketTimeout(200 * 10)
                .setConnectionRequestTimeout(200 * 10).build();
        SSLContext sslcontext = null;
        try {
            // Trust own CA and all self-signed certs
            sslcontext = SSLContexts.custom()
                    .loadTrustMaterial(null,
                            new TrustSelfSignedStrategy())
                    .build();

            HostnameVerifier hv = new HostnameVerifier() {
                @Override
                public boolean verify(String s, SSLSession sslSession) {
                    return true;
                }
            };
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, hv);
            // 设置默认跳转以及存储cookie
            httpClient = HttpClientBuilder.create().setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
                    .setRedirectStrategy(new DefaultRedirectStrategy()).setDefaultRequestConfig(requestConfig).setSSLSocketFactory(sslsf).build();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static  int count = 0;
    /**
     * http post
     *
     * @param url
     * @param parameters string字符
     * @return String
     */
    public static String postUrl(String url, String parameters) {
//        logger.info("http url:" + url);
        String responseText = null;
        HttpPost httpPost = new HttpPost(url);
        StringEntity stringEntity = new StringEntity(parameters, "GBK");
        stringEntity.setContentEncoding("GBK");
        httpPost.setEntity(stringEntity);
        try {
            CloseableHttpResponse response = httpClient.execute(httpPost);
            // 获取响应消息实体
            HttpEntity entity = response.getEntity();
            // 响应状态
            logger.info("http status:" + response.getStatusLine());
            if(200 != response.getStatusLine().getStatusCode()){
                logger.error(count+":count："+response.getStatusLine().getStatusCode());
                return  "";
            }
            // 判断响应实体是否为空
            if (entity != null) {
                try {
                    responseText = EntityUtils.toString(entity,"GBK");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return responseText;
        } catch (ConnectionPoolTimeoutException e){
            return "timeout";
        }catch (IOException e) {
            logger.error("IO异常", e);
            e.printStackTrace();
        } catch (Exception e) {
            logger.error("异常", e);
            e.printStackTrace();
        }
        return "";
    }
}
