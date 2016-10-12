package com.java.advanced.features.http.SimpleSpider;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;

/**
 * 这只虫子的功能很简单，抓取到”煎蛋网xxoo”网页(http://jandan.net/ooxx/page-1537)，解析出其中的妹子图，保存至本地。
 *
 * @url		http://www.cnblogs.com/nbspL/p/4780792.html?utm_source=tuicool&utm_medium=referral
 * @author 	Lian
 * @date 	2016/10/12
 * @since 	1.0
 */
public class SimpleSpider {

	/**
	 * 从程序来讲，分为三个步骤：
	 * 1、发起一个http请求，获取返回的response内容；
	 * 2、解析内容，分离出有效图片的url；
	 * 3、根据这些图片的url，生成图片保存至本地。
	 */

	/** 起始页码 */
	private static final int PAGE = 1538;

	public static void main(String[] args) {

		// HttpClient 超时配置
		RequestConfig globalConfig = RequestConfig
				.custom()
				.setCookieSpec(CookieSpecs.STANDARD)
				.setConnectionRequestTimeout(6000)
				.setConnectTimeout(6000)
				.build();

		CloseableHttpClient httpClient = HttpClients
				.custom()
				.setDefaultRequestConfig(globalConfig)
				.build();

		System.out.println("5秒后开始抓取煎蛋网妹子图。。。");

		for (int i = PAGE; i > 0; i--) {
			// 创建一个GET请求
			HttpGet httpGet = new HttpGet("http://jandan.net/ooxx/page-" + i);
			httpGet.addHeader("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36");
			httpGet.addHeader("Cookie", "Hm_lvt_fd93b7fb546adcfbcf80c4fc2b54da2c=1476243382; Hm_lpvt_fd93b7fb546adcfbcf80c4fc2b54da2c=1476251765; _ga=GA1.2.948465246.1476243381; _gat=1; jdna=596e6fb28c1bb47f949e65e1ae03f7f5#1476251774248");

			try {
				// 设置间隔时间
				Thread.sleep(5000);

				// 发送请求，并执行
				CloseableHttpResponse response = httpClient.execute(httpGet);
				InputStream in = response.getEntity().getContent();

				String html = Utils.convertStreamToString(in);

				// 网页内容解析
				new Thread(new JianDanHtmlParser(html, i)).start();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
