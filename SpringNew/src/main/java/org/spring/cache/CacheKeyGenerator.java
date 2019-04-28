package org.spring.cache;

import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;

public class CacheKeyGenerator implements KeyGenerator {

	@Override
	public Object generate(Object arg0, Method arg1, Object... arg2) {
		StringBuilder sb = new StringBuilder();
		sb.append(arg0.toString());
		sb.append("#");
		sb.append(arg1.getName());
		sb.append("#");
		for(Object arg:arg2){
			sb.append(arg.toString());
			sb.append("|");
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

}
