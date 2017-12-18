package com.banhujiu.utils.http.instance;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.message.BasicNameValuePair;

import com.banhujiu.utils.http.enums.RequestMethod;

/**
 * @author banhujiu
 * @date 2017/12/18 0018 14:07
 */
public class Post extends AbstractHttpRequestAble {
	private RequestMethod method = RequestMethod.POST;

	@Override
	public RequestMethod getRequestMethod() {
		return method;
	}

	@Override
	public HttpRequestBase getHttpRequest(String url) {
		HttpPost httpPost = new HttpPost(url);
		//拼接参数
		List<NameValuePair> nvps = new ArrayList<>();
		for (Map.Entry<String, String> entry : getParamMap().entrySet()) {
			nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nvps, getCharset()));
		} catch (UnsupportedEncodingException e) {
			throw new com.banhujiu.utils.http.exception.UnsupportedEncodingException();
		}
		return httpPost;
	}
}
