package com.topyfine.springboot.httpclientdemo.chapt1;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.net.URI;

/**
 * @author shipfly
 * @version V1.0
 * @date 2018/7/11 23:07
 * @apiNote ${todo}(用一句话描述该文件做什么)
 */
@Slf4j
public class HttpClientBase {
    public static void main(String[] args) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // 1.
            HttpGet httpGet = new HttpGet("http://www.baidu.com");
            // 2.
            URI uri = new URIBuilder()
                    .setScheme("http")
                    .setHost("www.google.com")
                    .setPath("/search")
                    .setParameter("q", "httpclient")
                    .setParameter("btnG", "Google Search")
                    .setParameter("aq", "f")
                    .setParameter("oq", "")
                    .build();
            HttpGet httpGet1 = new HttpGet(uri);
            CloseableHttpResponse response = httpClient.execute(httpGet1);
            for (Header header : response.getAllHeaders()) {
                for (HeaderElement e : header.getElements()) {
                    log.info(e.getName() + "-->" + e.getValue());
                }
            }
        } catch (Exception e) {
            log.warn(">>> ", e);
        }
    }
}
