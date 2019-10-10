package io.github.xieyinglin.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpClient {

    @Autowired
    private HttpConfig httpConfig;

    /**
     * instantiate a conn pool manager, and set max conns, maxConnsPerRoute
     * @return
     */
    @Bean(name = "httpClientConnectionManager")
    public PoolingHttpClientConnectionManager httpClientConnectionManager(){
        PoolingHttpClientConnectionManager httpClientConnectionManager = new PoolingHttpClientConnectionManager();
        //max conns
        httpClientConnectionManager.setMaxTotal(httpConfig.getMaxTotal());
        //Max conns Per Route
        httpClientConnectionManager.setDefaultMaxPerRoute(httpConfig.getDefaultMaxPerRoute());

        return httpClientConnectionManager;
    }

    /**
     *  instantiate a conn pool and set conn pool manager
     * @param httpClientConnectionManager
     * @return
     */
    @Bean(name = "httpClientBuilder")
    public HttpClientBuilder httpClientBuilder(@Qualifier("httpClientConnectionManager") PoolingHttpClientConnectionManager httpClientConnectionManager){
            
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
 
        httpClientBuilder.setConnectionManager(httpClientConnectionManager);
 
        return httpClientBuilder;
    }


    /**
     * 
     * inject conn pool, then get httpClient
     * 
     * @param httpClientBuilder
     * @return
     */
    @Bean
    public CloseableHttpClient closeableHttpClient(@Qualifier("httpClientBuilder") HttpClientBuilder httpClientBuilder){
        return httpClientBuilder.build();
    }

    /**
     * get request config
     * @return
     */
    @Bean(name = "requestBuilder")
    public RequestConfig.Builder requestBuilder(){
        RequestConfig.Builder builder = RequestConfig.custom();
        return builder.setConnectTimeout(httpConfig.getConnectTimeout())
                .setConnectionRequestTimeout(httpConfig.getConnectionRequestTimeout())
                .setSocketTimeout(httpConfig.getSocketTimeout())
                .setStaleConnectionCheckEnabled(httpConfig.isStaleConnectionCheckEnabled());
    }
    
    /**
     * new a RequestConfig by requestBuilder
     * @param builder
     * @return
     */
    @Bean
    public RequestConfig requestConfig(@Qualifier("requestBuilder") RequestConfig.Builder builder){
        return builder.build();
    }



}