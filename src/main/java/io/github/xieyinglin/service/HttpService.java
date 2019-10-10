package io.github.xieyinglin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.github.xieyinglin.domain.HttpResult;

import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HttpService {

    @Autowired
    private CloseableHttpClient closeableHttpClient;

    @Autowired
    private RequestConfig requestConfig;

    /**
     * 
     * send a get request without params, and return body , if response status is not 200, then renturn null;
     * 
     * @param url
     * @return
     * @throws Exception
     */
    public String doGet(String url) throws Exception {
        // declare  http get req
        HttpGet httpGet = new HttpGet(url);
 
        // set req config
        httpGet.setConfig(requestConfig);
 
        // execute get req
        CloseableHttpResponse response = this.closeableHttpClient.execute(httpGet);
 
        // judge resp status is 200
        if (response.getStatusLine().getStatusCode() == 200) {
            // return body
            return EntityUtils.toString(response.getEntity(), "UTF-8");
        }

        // else return null
        return null;
    }

    /**
     * send a get request with params, and return body , if response status is not 200, then renturn null;
     * 
     * @param url
     * @return
     * @throws Exception
     */
    public String doGet(String url, Map<String, Object> map) throws Exception {

        URIBuilder uriBuilder = new URIBuilder(url);
 
        if (map != null) {
            // iterator map and concate params
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                uriBuilder.setParameter(entry.getKey(), entry.getValue().toString());
            }
        }
 
        // execute get req with params
        return this.doGet(uriBuilder.build().toString());

    }
    
    /**
     * send a post req without params
     * 
     * @param url
     * @return
     * @throws Exception
     */
    public HttpResult doPost(String url) throws Exception {
        return this.doPost(url, null);
    }


     /**
     * send a post req with params
     * 
     * @param url
     * @param map
     * @return
     * @throws Exception
     */
    public HttpResult doPost(String url, Map<String, Object> map) throws Exception {
        // declare a post req
        HttpPost httpPost = new HttpPost(url);

        // set req config
        httpPost.setConfig(requestConfig);
 
        // if param map is not empty, then set to form obj
        if (map != null) {
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                list.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
            }
            // construct a form obj
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list, "UTF-8");
 
            // set entity with form obj
            httpPost.setEntity(urlEncodedFormEntity);
        }
 
        // execute post req
        CloseableHttpResponse response = this.closeableHttpClient.execute(httpPost);
        return new HttpResult(response.getStatusLine().getStatusCode(), EntityUtils.toString(
                response.getEntity(), "UTF-8"));
    }



}
