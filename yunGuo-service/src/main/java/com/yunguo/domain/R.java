package com.yunguo.domain;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class R extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	public R() {
		put("code", 200);
		put("msg", "操作成功");
	}
	
	public static R FAILURE() {
		return error(500, "操作失败");
	}

	public static R FAILURE(String msg) {
		return error(500, msg);
	}

	public static R error(int code, String msg) {
		R r = new R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static R ok(String msg) {
		R r = new R();
		r.put("msg", msg);
		return r;
	}

	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}
	public static R ok(String msg,Object o) {
		R r = new R();
		r.put("data", o);
		return r;
	}
	public static R ok() {
		return new R();
	}

	@Override
	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}
	
	public static R ExportNo(String msg,Object o) {
		R r = new R();
		r.clear();
		r.put("导入结果", msg);
		r.put("详情", o);
		return r;
	}
	public static R ExportOk(String msg) {
		R r = new R();
		r.clear();
		r.put("导入结果", msg);
		return r;
	}
	
	public static R PeopleNo(String msg) {
		R r = new R();
		r.clear();
		r.put("code", 300);
		r.put("msg", msg);
		return r;
	}
}
