package com.banhujiu.utils.http.enums;

import com.banhujiu.utils.http.contracts.HttpRequestAble;
import com.banhujiu.utils.http.exception.UnsupportedRequestMethodException;
import com.banhujiu.utils.http.instance.Get;
import com.banhujiu.utils.http.instance.Post;

/**
 * @author banhujiu
 * @date 2017/12/18 0018 12:08
 */
public enum RequestMethod {
	GET {
		@Override
		public HttpRequestAble newInstance() {
			return new Get();
		}
	},
	POST {
		@Override
		public HttpRequestAble newInstance() {
			return new Post();
		}
	},;

	public static RequestMethod get(String method) {
		if (method == null) {
			throw new NullPointerException();
		}
		for (RequestMethod requestMethod : RequestMethod.values()) {
			if (method.equalsIgnoreCase(requestMethod.toString())) {
				return requestMethod;
			}
		}
		throw new UnsupportedRequestMethodException();
	}

	public abstract HttpRequestAble newInstance();
}
