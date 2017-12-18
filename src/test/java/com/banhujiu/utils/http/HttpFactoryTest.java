package com.banhujiu.utils.http;

import java.io.IOException;

import org.junit.Test;

import com.banhujiu.utils.http.contracts.HttpRequestAble;

/**
 * @author banhujiu
 * @date 2017/12/18 0018 14:02
 */
public class HttpFactoryTest {

	@Test
	public void getHttpRequest() throws IOException {
		HttpRequestAble httpRequestAble = HttpFactory.getHttpRequest("get");
		httpRequestAble.addParam("in", "in").setUrl("http://www.baidu.com").send();
		System.out.println(httpRequestAble.getUrl());
		System.out.println(httpRequestAble.getStatusLine().getStatusCode());
		System.out.println(httpRequestAble.toString());
	}
}
