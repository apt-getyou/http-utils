package com.banhujiu.utils.http.contracts;

import java.io.IOException;

import org.apache.http.StatusLine;

import com.banhujiu.utils.http.enums.RequestMethod;

/**
 * @author banhujiu
 * @date 2017/12/18 0018 12:06
 */
public interface HttpRequestAble {
	RequestMethod getRequestMethod();

	HttpRequestAble addParam(String key, String value);

	HttpRequestAble send() throws IOException;

	HttpRequestAble setUrl(String url);

	String getUrl();

	StatusLine getStatusLine();

}
