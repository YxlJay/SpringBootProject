package com.yxl.application.config;

import lombok.Data;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.List;

/**
 * ClassName: HttpCilentConfig <br/>
 * Description: <br/>
 * date: 2021/12/1 11:27<br/>
 *
 * @author zhaoran<br />
 * @since JDK 1.8
 */
@Configuration
@ConfigurationProperties(prefix = "http")
@Data
public class HttpCilentConfig {
    private Integer maxTotal;// 最大连接

    private Integer defaultMaxPerRoute;// 每个host的最大连接

    private Integer connectTimeout;// 连接超时时间

    private Integer connectionRequestTimeout;// 请求超时时间

    private Integer socketTimeout;// 响应超时时间

    /**
     * HttpClient连接池
     * @return
     */
    @Bean
    public HttpClientConnectionManager httpClientConnectionManager() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(maxTotal);
        connectionManager.setDefaultMaxPerRoute(defaultMaxPerRoute);
        return connectionManager;
    }

    /**
     * 注册RequestConfig
     * @return
     */
    @Bean
    public RequestConfig requestConfig() {
        return RequestConfig.custom().setConnectTimeout(connectTimeout)
                .setConnectionRequestTimeout(connectionRequestTimeout).setSocketTimeout(socketTimeout)
                .build();
    }

    /**
     * 注册HttpClient
     * @param manager
     * @param config
     * @return
     */
    @Bean
    public HttpClient httpClient(HttpClientConnectionManager manager, RequestConfig config) {
        return HttpClientBuilder.create().setConnectionManager(manager).setDefaultRequestConfig(config)
                .build();
    }
    /**
     * 使用连接池管理连接
     * @param httpClient
     * @return
     */
    @Bean
    public ClientHttpRequestFactory requestFactory(HttpClient httpClient) {
        return new HttpComponentsClientHttpRequestFactory(httpClient);
    }
    /**
     * 使用HttpClient来初始化一个RestTemplate
     * @param requestFactory
     * @return
     */
    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory requestFactory) {
        RestTemplate template = new RestTemplate(requestFactory);

        List<HttpMessageConverter<?>> list = template.getMessageConverters();
        for (HttpMessageConverter<?> mc : list) {
            if (mc instanceof StringHttpMessageConverter) {
                ((StringHttpMessageConverter) mc).setDefaultCharset(Charset.forName("UTF-8"));
            }
        }
        return template;
    }
}