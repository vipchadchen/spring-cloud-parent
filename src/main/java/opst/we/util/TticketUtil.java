package opst.we.util;

import opst.we.Constants;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.*;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: chgj
 * @description:
 * @date: create in 2017/11/13 14:05
 * @modified:
 */
public class TticketUtil {
    private static final Logger logger = LoggerFactory.getLogger(TticketUtil.class);
    public static CloseableHttpClient httpClient = null;
    public static HttpClientContext context = null;
    public static CookieStore cookieStore = null;
    public static RequestConfig requestConfig = null;

    static {
        init();
    }

    private static void init() {
        context = HttpClientContext.create();
        cookieStore = new BasicCookieStore();
        // 配置超时时间（连接服务端超时1秒，请求数据返回超时2秒）
        requestConfig = RequestConfig.custom().setConnectTimeout(120000).setSocketTimeout(60000)
                .setConnectionRequestTimeout(60000).build();
        SSLContext sslcontext = null;
        try {
            // Trust own CA and all self-signed certs
            sslcontext = SSLContexts.custom()
                    .loadTrustMaterial(new File("C:\\workspace_git\\githubpj\\weclome\\src\\main\\resources\\cert\\my.truststore"), "12345678".toCharArray(),
                            new TrustSelfSignedStrategy())
                    .build();
            // Allow TLSv1 protocol only
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                    sslcontext,
                    new String[]{"TLSv1"},
                    null,
                    SSLConnectionSocketFactory.getDefaultHostnameVerifier());
            // 设置默认跳转以及存储cookie
            httpClient = HttpClientBuilder.create().setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
                    .setRedirectStrategy(new DefaultRedirectStrategy()).setDefaultRequestConfig(requestConfig)
                    .setDefaultCookieStore(cookieStore).setSSLSocketFactory(sslsf).build();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * http get
     *
     * @param url
     * @return String
     * @throws Exception
     */
    public static String get(String url) throws Exception {
        logger.info("http url:" + url);
        String responseText = "";
        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpget, context);
        try {
            cookieStore = context.getCookieStore();
            List<Cookie> cookies = cookieStore.getCookies();
            for (Cookie cookie : cookies) {
                logger.debug("key:" + cookie.getName() + "  value:" + cookie.getValue());
            }
            responseText = printResponse(response);
        } finally {
            response.close();
        }
        return responseText;
    }

    public static void getFile(String url) throws Exception {
        logger.info("http url:" + url);
        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpget, context);
        try{
            cookieStore = context.getCookieStore();
            List<Cookie> cookies = cookieStore.getCookies();
            for (Cookie cookie : cookies) {
                logger.debug("key:" + cookie.getName() + "  value:" + cookie.getValue());
            }
            /*  写入硬盘 */
            File storeFile = new File(Constants.IMG_PATH);
            FileOutputStream output = new FileOutputStream(storeFile);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream instream = entity.getContent();
                byte b[] = new byte[1024];
                int j = 0;
                while ((j = instream.read(b)) != -1) {
                    output.write(b, 0, j);
                }
                output.flush();
                output.close();
                logger.info("--------------------------验证码下载完毕");
            }
        } finally {
            response.close();
        }
    }

    /**
     * http post
     *
     * @param url
     * @param parameters form表单
     * @return response
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static String post(String url, String parameters) throws Exception {
        logger.info("http url:" + url);
        String responseText = "";
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> nvps = toNameValuePairList(parameters);
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
        CloseableHttpResponse response = httpClient.execute(httpPost, context);
        try {
            cookieStore = context.getCookieStore();
            List<Cookie> cookies = cookieStore.getCookies();
            for (Cookie cookie : cookies) {
                logger.debug("key:" + cookie.getName() + "  value:" + cookie.getValue());
            }
            responseText = printResponse(response);
        } finally {
            response.close();
        }
        return responseText;
    }

    private static List<NameValuePair> toNameValuePairList(String parameters) {
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        String[] paramList = parameters.split("&");
        for (String parm : paramList) {
            int index = -1;
            for (int i = 0; i < parm.length(); i++) {
                index = parm.indexOf("=");
                break;
            }
            String key = parm.substring(0, index);
            String value = parm.substring(++index, parm.length());
            nvps.add(new BasicNameValuePair(key, value));
        }
        logger.info(nvps.toString());
        return nvps;
    }

    /**
     * 手动增加cookie
     *
     * @param name
     * @param value
     * @param domain
     * @param path
     */
    public static void addCookie(String name, String value, String domain, String path) {
        BasicClientCookie cookie = new BasicClientCookie(name, value);
        cookie.setDomain(domain);
        cookie.setPath(path);
        cookieStore.addCookie(cookie);
    }

    /**
     * 把结果console出来
     *
     * @param httpResponse
     * @throws Exception
     */
    public static String printResponse(HttpResponse httpResponse) {
        // 获取响应消息实体
        HttpEntity entity = httpResponse.getEntity();
        // 响应状态
        logger.info("http status:" + httpResponse.getStatusLine());
        String responseString = null;
        // 判断响应实体是否为空
        if (entity != null) {
            try {
                responseString = EntityUtils.toString(entity);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseString;
    }

    /**
     * 把当前cookie从控制台输出出来
     */
    public static List<Cookie> printCookies() {
        cookieStore = context.getCookieStore();
        List<Cookie> cookies = cookieStore.getCookies();
        for (Cookie cookie : cookies) {
            logger.info("key:" + cookie.getName() + "  value:" + cookie.getValue());
        }
        return cookies;
    }

    /**
     * 检查cookie的键值是否包含传参
     *
     * @param key
     * @return
     */
    public static boolean checkCookie(String key) {
        cookieStore = context.getCookieStore();
        List<Cookie> cookies = cookieStore.getCookies();
        boolean res = false;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(key)) {
                res = true;
                break;
            }
        }
        return res;
    }

    /**
     * 直接把Response内的Entity内容转换成String
     *
     * @param httpResponse
     * @return
     * @throws Exception
     */
    public static String toString(CloseableHttpResponse httpResponse) throws Exception {
        // 获取响应消息实体
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null) {
            return EntityUtils.toString(entity);
        } else {
            return null;
        }
    }
}
