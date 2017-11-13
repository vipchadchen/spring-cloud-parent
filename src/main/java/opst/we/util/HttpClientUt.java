package opst.we.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * @author: chgj
 * @description:
 * @date: create in 2017/11/13 12:48
 * @modified:
 */
public class HttpClientUt {
    private final static Logger logger = LoggerFactory.getLogger(HttpClientUt.class);
    public static CookieStore cookieStore = new BasicCookieStore();
    public static CloseableHttpClient httpCilent = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
    public static int CODE_200 = 200;
    public static int CODE_404 = 404;

    public static String httpPost(String url, List<BasicNameValuePair> list) {

        // 配置超时时间
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(1000).setConnectionRequestTimeout(1000)
                .setSocketTimeout(1000).setRedirectsEnabled(true).build();

        HttpPost httpPost = new HttpPost(url);
        // 设置超时时间
        httpPost.setConfig(requestConfig);

        String strResult = "";
        try {
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "UTF-8");
            // 设置post求情参数
            httpPost.setEntity(entity);
            HttpResponse httpResponse = httpCilent.execute(httpPost);

            if (httpResponse != null) {
                int statusCode=httpResponse.getStatusLine().getStatusCode();
                if (httpResponse.getStatusLine().getStatusCode() == CODE_200) {
                    strResult = EntityUtils.toString(httpResponse.getEntity());
                    logger.info("post/"+statusCode+":"+strResult);
                    return strResult;
                }  else {
                    strResult = "Error Response: " + httpResponse.getStatusLine().toString();
                    logger.info("post/"+statusCode+":"+strResult);
                    strResult=null;
                }
            } else {

            }

        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {

        }

        return strResult;
    }

    public static String ttpGet(String url) {
        // 设置连接超时时间、请求超时时间、允许自动重定向
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setSocketTimeout(5000).setRedirectsEnabled(true)
                .build();
        HttpGet httpGet2 = new HttpGet(url);
        httpGet2.setConfig(requestConfig);
        String srtResult =null;
        try {
            HttpResponse httpResponse = httpCilent.execute(httpGet2);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (httpResponse.getStatusLine().getStatusCode() == CODE_200) {
                // 获得返回的结果
                srtResult = EntityUtils.toString(httpResponse.getEntity());
                logger.info("get/"+statusCode+":"+srtResult);
                return srtResult;
            } else {
                // 获得返回的结果
                srtResult = EntityUtils.toString(httpResponse.getEntity());
                logger.info("get/"+statusCode+":"+srtResult);
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
        return null;
    }
    public static void setCookieStore(List<BasicClientCookie> cookielist ) {
        for(BasicClientCookie cookie:cookielist){
            HttpClientUt.cookieStore.addCookie(cookie);
        }
    }
    public static void createCookie(List<BasicClientCookie> cookielist ) {
        for(BasicClientCookie cookie:cookielist){
            HttpClientUt.cookieStore.addCookie(cookie);
        }
    }

}
