package com.banhujiu.utils.http.instance;

import java.util.Map;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;

import com.banhujiu.utils.http.enums.RequestMethod;

/**
 * @author banhujiu
 * @date 2017/12/18 0018 12:01
 */
public class Get extends AbstractHttpRequestAble {
	private RequestMethod method = RequestMethod.GET;

	@Override
	public RequestMethod getRequestMethod() {
		return method;
	}

	@Override
	public HttpRequestBase getHttpRequest(String url) {
		if (getParamMap().isEmpty()) {
			return new HttpGet(url);
		}
		if (!url.endsWith("?")) {
			url += "?";
		}
		StringBuffer urlBuffer = new StringBuffer(url);
		for (Map.Entry<String, String> entry : getParamMap().entrySet()) {
			urlBuffer.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
		}
		urlBuffer.deleteCharAt(urlBuffer.length() - 1);
		this.setUrl(urlBuffer.toString());
		return new HttpGet(this.getUrl());
	}


}
