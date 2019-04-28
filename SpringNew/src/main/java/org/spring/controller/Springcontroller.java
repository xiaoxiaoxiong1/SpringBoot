package org.spring.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.entity.Address;
import org.mybatis.mapper.AddressMapper;
import org.spring.entities.MyInfo;
import org.spring.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping("/mvc")
public class Springcontroller {
	
	@Autowired
	private AddressMapper addressMapper;

	// SPitter可以传递参数上去
	@RequestMapping(value = "/sendMail")
	public String sendMail(MyInfo content, RedirectAttributes model) {

		model.addAttribute("username", content.getUsername());
		System.out.println(model.containsAttribute("username"));
		return "redirect:/config/{username}";

	}

	// 随机ID  只有responseBoyd的时候才可以使用
	@RequestMapping(value = "/myPath/{goodsId}" ,method=RequestMethod.GET)
	@ResponseBody
	public MyInfo sendPath(@PathVariable("goodsId") String goodsId, MyInfo info) {
		if(goodsId==null||"null".equals(goodsId)) {
			throw new NotFoundException("9999","参数为空");
		}
		info.setPassword(goodsId + 123);
		return info;

	}
	

	// 随机ID
	@RequestMapping(value = "/path/**" ,method=RequestMethod.GET)
	@ResponseBody
	public String path( HttpServletRequest request) {
		
		return extractPathFromPattern(request);
		 

	}
	

	@RequestMapping(produces="application/json")
	@ResponseBody
	public String UriComponents(MyInfo myInfo,UriComponentsBuilder ucb){
		
	/*	org.springframework.http.HttpHeaders header=new org.springframework.http.HttpHeaders();
		URI locationUrl=ucb.path("/config")
				.path("/"+myInfo.getUsername())
				.build()
				.toUri();
		header.setLocation(locationUrl);
		ResponseEntity<MyInfo>  result=new ResponseEntity<MyInfo>(myInfo,header,HttpStatus.CREATED);
		return result;*/
		
		UriComponents uriComponents = UriComponentsBuilder.fromUriString(
		        "http://localhost:8082/{hotel}/bookings/{booking}").build();

		URI uri = uriComponents.expand("42", "21").encode().toUri();
		System.out.println(uri.toString());
		return "suceess";
		
	} 
	
	   @RequestMapping(value="/uricom")
	    @ResponseBody
	    public String uricom(){
	        UriComponents uriComponents = UriComponentsBuilder.fromUriString(
	                "http://example.com/hotels/{hotel}/bookings/{booking}").build();

	        URI uri = uriComponents.expand("42", "21").encode().toUri();
	        return uri.toString();
	    }

	
	// 把指定URL后的字符串全部截断当成参数
	// 这么做是为了防止URL中包含中文或者特殊字符（/等）时，匹配不了的问题
	private static String extractPathFromPattern(
	            final HttpServletRequest request)
	{
	     String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
	     String bestMatchPattern = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
	     return new AntPathMatcher().extractPathWithinPattern(bestMatchPattern, path);
	}
	@RequestMapping("/view/db")
	@ResponseBody
	public List<org.mybatis.entity.Address> queryFromDb(@RequestParam("num") int num,@RequestParam("size") int size ) {

		PageHelper.startPage(num,size  );
		List<org.mybatis.entity.Address> adesss=addressMapper.selectAll();
		return adesss;
	}




}
