package com.banhujiu.utils.http.instance;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.banhujiu.utils.http.contracts.HttpRequestAble;
import com.banhujiu.utils.http.exception.NullUrlException;

/**
 * @author banhujiu
 * @date 2017/12/18 0018 12:14
 */
public abstract class AbstractHttpRequestAble implements HttpRequestAble {
	private Map<String, String> paramMap = new HashMap<>();
	private String charset = "utf-8";
	private String url;
	private String result;
	private StatusLine statusLine;

	@Override
	public HttpRequestAble addParam(String key, String value) {
		paramMap.put(key, value);
		return this;
	}

	protected Map<String, String> getParamMap() {
		return paramMap;
	}

	public HttpRequestAble setCharset(String charset) {
		this.charset = charset;
		return this;
	}

	public String getCharset() {
		return charset;
	}

	@Override
	public HttpRequestAble send() throws IOException {
		if (this.url == null) {
			throw new NullUrlException();
		}
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpRequestBase request = getHttpRequest(this.url);
		CloseableHttpResponse response = httpclient.execute(request);

		this.statusLine = response.getStatusLine();

		try {
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity, charset);
			// do something useful with the response body
			// and ensure it is fully consumed
			EntityUtils.consume(entity);
		} finally {
			response.close();
		}
		return this;
	}

	@Override
	public HttpRequestAble setUrl(String url) {
		if (url == null || url.equals("")) {
			throw new NullUrlException();
		}
		this.url = url;
		return this;
	}

	abstract HttpRequestBase getHttpRequest(String url);

	@Override
	public String getUrl() {
		return url;
	}

	@Override
	public StatusLine getStatusLine() {
		return statusLine;
	}

	@Override
	public String toString() {
		return result;
	}
}
