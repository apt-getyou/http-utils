package com.banhujiu.utils.http;

import com.banhujiu.utils.http.contracts.HttpRequestAble;
import com.banhujiu.utils.http.enums.RequestMethod;

/**
 * @author banhujiu
 * @date 2017/12/18 0018 11:54
 */
public class HttpFactory {
	public static HttpRequestAble getHttpRequest(RequestMethod method) {
		if (method == null) {
			throw new NullPointerException();
		}
		return method.newInstance();
	}

	public static HttpRequestAble getHttpRequest(String method) {
		return getHttpRequest(RequestMethod.get(method));
	}
}
