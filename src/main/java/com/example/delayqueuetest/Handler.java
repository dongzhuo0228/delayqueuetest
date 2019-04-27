package com.example.delayqueuetest;

import java.util.HashMap;
import java.util.Map;


public class Handler<T> {
	public Map<String, Object> successResult() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("code","0");
		map.put("msg","请求成功!");
		return map;
	}
	public Map<String, Object> successResult(String msg) {

		HashMap<String, Object> map = new HashMap<>();
		map.put("code","0");
		map.put("msg",msg);
		return map;
	}

	public Map<String, Object> successResult(String msg, Object object) {

		HashMap<String, Object> map = new HashMap<>();
		map.put("code","0");
		map.put("msg",msg);
		map.put("data",object);
		return map;
	}

	public Map<String, Object> successResult(Object object) {

		HashMap<String, Object> map = new HashMap<>();
		map.put("code","0");
		map.put("msg","请求成功!");
		map.put("data",object);
		return map;
	}

	public Map<String, Object> failResult() {

		HashMap<String, Object> map = new HashMap<>();
		map.put("code","-1");
		map.put("msg","请求失败!");
		return map;
	}

	public Map<String, Object> failResult(String msg) {

		HashMap<String, Object> map = new HashMap<>();
		map.put("code","-1");
		map.put("msg",msg);
		return map;
	}

	public Map<String, Object> successPageResult(int count, int limit, Object object) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("code", "0");
        map.put("count", count);
        map.put("limit", limit);
        map.put("data", object);
        return map;
    }

    /**
     * String转ASCII
     *
     * @param value String
     * @return String
     */
	public String stringToAscii(String value) {
        StringBuilder sbu = new StringBuilder();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i != chars.length - 1) {
                sbu.append((int) chars[i]).append(",");
            } else {
                sbu.append((int) chars[i]);
            }
        }
        return sbu.toString();
    }

    /**
     * ASCII转String
     *
     * @param value ASCII
     * @return String
     */
	public String asciiToString(String value) {
        StringBuilder sbu = new StringBuilder();
        String[] chars = value.split(",");
        for (String aChar : chars) {
            sbu.append((char) Integer.parseInt(aChar));
        }
        return sbu.toString();
    }
}
