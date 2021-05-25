//package year2018;
//
//import org.apache.http.*;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.client.utils.URLEncodedUtils;
//import org.apache.http.conn.scheme.PlainSocketFactory;
//import org.apache.http.conn.scheme.Scheme;
//import org.apache.http.conn.scheme.SchemeRegistry;
//import org.apache.http.conn.ssl.SSLSocketFactory;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.entity.mime.HttpMultipartMode;
//import org.apache.http.entity.mime.MultipartEntityBuilder;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.impl.conn.PoolingClientConnectionManager;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.params.BasicHttpParams;
//import org.apache.http.params.CoreConnectionPNames;
//import org.apache.http.util.EntityUtils;
//
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.TrustManager;
//import javax.net.ssl.X509TrustManager;
//import java.io.File;
//import java.nio.charset.Charset;
//import java.security.KeyManagementException;
//import java.security.NoSuchAlgorithmException;
//import java.security.cert.CertificateException;
//import java.security.cert.X509Certificate;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by Administrator on 2019/8/14.
// */
//public class HttpClientUtils {
//    private static final Map<String, DefaultHttpClient> clientPool = new HashMap<>();
//
//    private static String post(String systemName, String postUrl, Map<String, String> parameters) throws Exception {
//        HttpPost httpPost = null;
//        try {
//            DefaultHttpClient httpClient = getHttpClient(systemName);
//            httpPost = new HttpPost(postUrl);
//            // 封装请求参数
//            List<NameValuePair> formParams = convert2NameValuePair(parameters);
//            if (null != formParams && !formParams.isEmpty()) {
//                // 设置cookie信息
//                httpPost.setEntity(new UrlEncodedFormEntity(formParams, "UTF-8"));
//            }
//            HttpResponse response = httpClient.execute(httpPost);
//            int status = response.getStatusLine().getStatusCode();
//            if (status != HttpStatus.SC_OK) {
//
//            }
//            HttpEntity entity = response.getEntity();
//            String responseContent = EntityUtils.toString(entity, "UTF-8");
//            EntityUtils.consume(entity);
//            return responseContent;
//        } finally {
//            if (httpPost != null) {
//                httpPost.releaseConnection();
//            }
//        }
//    }
//
//    private static String get(String systemName, String getUrl, Map<String, String> parameters) throws Exception {
//        HttpGet httpGet = null;
//        try {
//            DefaultHttpClient httpClient = getHttpClient(systemName);
//            if (parameters != null && parameters.size() > 0) {
//                // 封装请求参数
//                getUrl = getUrl + "?";
//                List<NameValuePair> formParams = convert2NameValuePair(parameters);
//                if (null != formParams && !formParams.isEmpty()) {
//                    getUrl = getUrl + URLEncodedUtils.format(formParams, "UTF-8");
//                }
//            }
//            httpGet = new HttpGet(getUrl);
//            HttpResponse response = httpClient.execute(httpGet);
//            StatusLine statusLine = response.getStatusLine();
//            int status = statusLine.getStatusCode();
//            if (status != HttpStatus.SC_OK) {
//            }
//            HttpEntity entity = response.getEntity();
//            String responseContent = EntityUtils.toString(entity, "UTF-8");
//            EntityUtils.consume(entity);
//
//            return responseContent;
//        } finally {
//            if (httpGet != null) {
//                httpGet.releaseConnection();
//            }
//        }
//    }
//
//    /**
//     * 添加请求参数
//     *
//     * @param requestParams 请求参数
//     */
//    private static List<NameValuePair> convert2NameValuePair(Map<String, String> requestParams) {
//        if (requestParams == null || requestParams.isEmpty()) {
//            return null;
//        }
//        List<NameValuePair> formParams = new ArrayList<>();
//        for (Map.Entry<String, String> entry : requestParams.entrySet()) {
//            formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
//        }
//        return formParams;
//    }
//
//    /**
//     * 获取httpClient连接
//     *
//     * @param key key值
//     * @return httpClient
//     * @throws NoSuchAlgorithmException
//     * @throws KeyManagementException
//     */
//    @SuppressWarnings("deprecation")
//    private static DefaultHttpClient getHttpClient(String key) throws NoSuchAlgorithmException, KeyManagementException {
//        DefaultHttpClient hc;
//        if ((hc = clientPool.get(key)) == null) {
//            // 协议注册
//            SSLContext ctx = SSLContext.getInstance("TLS");
//            ctx.init(null, new TrustManager[]{new HttpsX509TrustManager()}, null);
//            SSLSocketFactory ssf = new SSLSocketFactory(ctx);
//            // 允许所有主机的验证
//            ssf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
//
//            SchemeRegistry schemeRegistry = new SchemeRegistry();
//            // 设置http https支持
//            schemeRegistry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
//            schemeRegistry.register(new Scheme("https", 443, ssf));
//            // 连接池创建
//            PoolingClientConnectionManager cm = new PoolingClientConnectionManager(schemeRegistry);
//            // 设置最大连接数
//            cm.setMaxTotal(200);
//            /**
//             * 设置每个路由默认连接个数 DefaultMaxPerRoute是根据连接到的主机对MaxTotal的一个细分；比如：
//             * MaxtTotal=100 DefaultMaxPerRoute=50
//             * 而我只连接到http://life.baidu.com时，到这个主机的并发最多只有50；而不是100；
//             * 而我连接到http://life.baidu.com 和
//             * http://baifubao.com时，到每个主机的并发最多只有50；即加起来是100（但不能超过100）
//             **/
//            cm.setDefaultMaxPerRoute(50);
//            BasicHttpParams param = new BasicHttpParams();
//            // 设置请求超时时间
//            param.setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 3000);
//            // 设置等待数据超时时间
//            param.setIntParameter(CoreConnectionPNames.SO_TIMEOUT, 5000);
//            // 在提交请求之前 测试连接是否可用
//            param.setBooleanParameter(CoreConnectionPNames.STALE_CONNECTION_CHECK, true);
//            hc = new DefaultHttpClient(cm, param);
//            clientPool.put(key, hc);
//        }
//        return hc;
//    }
//
//    /**
//     * 缺省的认证处理
//     */
//    private static class HttpsX509TrustManager implements X509TrustManager {
//        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
//        }
//
//        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
//        }
//
//        public X509Certificate[] getAcceptedIssuers() {
//            return new X509Certificate[]{};
//        }
//    }
//
//    /**
//     * postRaw 通用请求方法
//     *
//     * @param url         请求URL
//     * @param requestJson 请求json数据
//     * @return 真实响应的数据
//     */
//    public static String postRaw(String url, String requestJson) throws Exception {
//        HttpClient httpClient = getHttpClient("SystemName");
//        HttpPost post = new HttpPost(url);
//        StringEntity postingString = new StringEntity(requestJson, "UTF-8");
//
//        post.setEntity(postingString);
//        post.setHeader("Content-type", "application/json");
//        HttpResponse response = httpClient.execute(post);
//        HttpEntity entity = response.getEntity();
//        String responseContent = EntityUtils.toString(entity, "UTF-8");
//        return responseContent;
//
//    }
//
//    /**
//     * 通用post服务请求处理，返回制定对象格式
//     *
//     * @param url        目标服务地址
//     * @param parameters 请求参数 格式：Map<String,String>
//     * @param clazz      响应对象
//     * @return post结果数据
//     */
//    public static <T> T post(String url, Map<String, String> parameters, Class<T> clazz) throws Exception {
//        String result = post("SystemName", url, parameters);
//        return JacksonUtil.parseString(result,clazz);
//    }
//
//    public static String postChuanglan(String url, Map<String, String> parameters) throws Exception {
//        return post("SystemName", url, parameters);
//    }
//
//    public static String post(String url, Map<String, String> parameters) throws Exception {
//        return post("SystemName", url, parameters);
//    }
//
//    /**
//     * 通用get服务请求处理，返回制定对象格式
//     *
//     * @param url        目标服务地址
//     * @param parameters 请求参数 格式：Map<String,String>
//     * @param clazz      响应对象
//     * @return get结果数据
//     */
//    public static <T> T get(String url, Map<String, String> parameters, Class<T> clazz) throws Exception {
//        String result = get("SystemName", url, parameters);
//        return JacksonUtil.parseString(result,clazz);
//    }
//
//    /**
//     * 通用rawPost服务请求处理，返回制定对象格式
//     *
//     * @param url     目标服务地址
//     * @param reqJson 请求参数 格式：json字符串
//     * @param clazz   响应对象字节码
//     * @return post json结果数据
//     */
//    public static <T> T postRaw(String url, String reqJson, Class<T> clazz) throws Exception {
//        String result = postRaw(url, reqJson);
//        return JacksonUtil.parseString(reqJson,clazz);
//    }
//
//    public static String get(String url, Map<String, String> parameters) throws Exception {
//        return get("SystemName", url, parameters);
//    }
//
//
//    public static String posts(String postUrl, Map<String, Object> parms) throws Exception {
//        HttpPost httpPost = null;
//        try {
//            DefaultHttpClient httpClient = getHttpClient("SystemName");
//            httpPost = new HttpPost(postUrl);
//            MultipartEntityBuilder builder = MultipartEntityBuilder.create()
//                    .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
//                    .setCharset(Charset.forName("utf-8"));
//            builder.addTextBody("accessKey", String.valueOf(parms.get("accessKey")));
//            if(parms.get("file") instanceof List){
//                List<File> l = (List)parms.get("file");
//                for(File file : l){
//                    builder.addBinaryBody("file", file);
//                }
//            }else{
//                builder.addBinaryBody("file", ((File)parms.get("file")));
//            }
//            HttpEntity reqEntity = builder.build();
//            httpPost.setEntity(reqEntity);
//            HttpResponse response = httpClient.execute(httpPost);
//            int status = response.getStatusLine().getStatusCode();
//            if (status != HttpStatus.SC_OK) {
//                LogUtils.warn(HttpClientUtils.class, "req res status is fail req url=[" + postUrl + "] status[" + status + "]");
//            }
//            HttpEntity entity = response.getEntity();
//            String responseContent = EntityUtils.toString(entity, "UTF-8");
//            EntityUtils.consume(entity);
//            return responseContent;
//        } finally {
//            if (httpPost != null) {
//                httpPost.releaseConnection();
//            }
//        }
//    }
//
//
//
//}
