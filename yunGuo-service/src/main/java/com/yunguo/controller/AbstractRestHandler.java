package com.yunguo.controller;

import java.io.IOException;
//import java.io.BufferedOutputStream;
//import java.io.FileOutputStream;
import java.util.zip.DataFormatException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.config.ResourceNotFoundException;
//import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.yunguo.domain.R;
import com.yunguo.exception.CustomException;

public abstract class AbstractRestHandler implements ApplicationEventPublisherAware {

	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	
	protected static final String DEFAULT_PAGE_SIZE = "100";
	protected static final String DEFAULT_PAGE_NUM = "0";

	protected static final String APPLICATION_JSON = "application/json";
	protected static final String APPLICATION_XML = "application/xml";
	
	protected ApplicationEventPublisher eventPublisher;

	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(DataFormatException.class)
	public @ResponseBody R handleDataStoreException(DataFormatException ex, WebRequest request,
			HttpServletResponse response) {
		log.info("Converting Data Store exception to Ronse : " + ex.getMessage());
		return R.FAILURE("Converting Data Store exception to Ronses");
	}

	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(ResourceNotFoundException.class)
	public @ResponseBody R handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request,
			HttpServletResponse response) {
		log.info("ResourceNotFoundException handler:" + ex.getMessage());
		return R.FAILURE("数据未找到");
	}

	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(Exception.class)
	public @ResponseBody R handleResourceNotFoundException(Exception ex, WebRequest request,
			HttpServletResponse response) {
		log.info("异常信息:" + ex.getMessage());
		return R.FAILURE("服务器出问题了");
	}

	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(NullPointerException.class)
	public @ResponseBody R handleNullPointerException(NullPointerException ex, WebRequest request,
			HttpServletResponse response) {
		log.info("异常信息:" + ex.getMessage());
		return R.FAILURE("内部错误");
	}

	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(IOException.class)
	public @ResponseBody R handleIOException(IOException ex, WebRequest request, HttpServletResponse response) {
		log.info("异常信息:" + ex.getMessage());
		return R.FAILURE("io异常");
	}
	
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(JsonParseException.class)
	public @ResponseBody R handleJsonParseException(JsonParseException ex, WebRequest request, HttpServletResponse response) {
		log.info("异常信息:" + ex.getMessage());
		return R.FAILURE("json解析异常");
	}
	
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(JsonMappingException.class)
	public @ResponseBody R handleJsonMappingException(JsonMappingException ex, WebRequest request, HttpServletResponse response) {
		log.info("异常信息:" + ex.getMessage());
		return R.FAILURE("json解析异常");
	}

	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(CustomException.class)
	public @ResponseBody R handleCustomServiceException(CustomException ex, WebRequest request,
			HttpServletResponse response) {
		log.info("异常信息:" + ex.getMessage());
		return R.FAILURE(ex.getMessage());
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.eventPublisher = applicationEventPublisher;
	}

	// todo: replace with exception mapping
	protected static <T> T checkResourceFound(final T resource) {
		if (resource == null) {
			throw new ResourceNotFoundException("resource not found", null);
		}
		return resource;
	}

	protected String getRemortIP(HttpServletRequest request) {
		if (request.getHeader("x-forwarded-for") == null) {
			return request.getRemoteAddr();
		}
		return request.getHeader("x-forwarded-for");
	}

}