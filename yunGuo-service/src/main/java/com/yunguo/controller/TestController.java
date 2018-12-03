//package com.yunguo.controller;
//
//import javax.validation.Valid;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.yunguo.domain.R;
//import com.yunguo.domain.RailwayPolice;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
//
//@RefreshScope
//@RestController
//@RequestMapping(value = "/test")
//@Api(value = "test",tags={"test"})
//public class TestController extends AbstractRestHandler {
//	private final Logger log = LoggerFactory.getLogger(getClass());
//
//	@RequestMapping(path = "/createOrUpdate.do", method = RequestMethod.POST)
//	@ApiOperation(value="创建或更新", notes="id大于0时执行新增，否则更新")
//	public R createOrUpdate(@Valid @RequestBody RailwayPolice obj) {
//		//TODO 
//		return R.ok("操作成功");
//	}
//	
//	
//	@RequestMapping(path = "/del.do", method = RequestMethod.GET)
//	@ApiOperation(value="删除", notes="id大于0时执行")
//	public R del(Integer bindingId,Integer bindingType) {
//		//TODO 
//		return R.ok("操作成功");
//	}
//	@RequestMapping(path = "/findOne.do", method = RequestMethod.GET)
//	@ApiOperation(value="查询单个", notes="id大于0")
//	public R findOne(Integer id) {
//		//TODO 
//		return R.ok().put("data", null);
//	}
//	@RequestMapping(path = "/listPage", method = RequestMethod.POST)
//	@ApiOperation(value="获取分页列表", notes="获取分页列表")
//	public R listPage(@RequestBody RailwayPolice policeBindingVo) {
//		//TODO 
////		PageUtils pageUtils = new PageUtils(pages.getResult(), Integer.valueOf(pages.getTotal()+""));
//		return null;//R.ok().put("data",pageUtils);
//	}
//	
//	@RequestMapping(path = "/list.do", method = RequestMethod.GET)
//	@ApiOperation(value="获取列表", notes="获取列表")
//	@ApiImplicitParams({
//		@ApiImplicitParam(name = "name", value = "查询关键字", dataType = "string", paramType = "query")
//	})
//	public R list(String name) {
//		//TODO 
//		return null;
//	}
//}
