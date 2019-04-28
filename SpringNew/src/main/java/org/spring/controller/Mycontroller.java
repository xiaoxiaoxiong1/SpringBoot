package org.spring.controller;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;

import javax.swing.text.AbstractDocument.Content;
import javax.validation.Valid;

import com.github.pagehelper.PageHelper;
import org.mybatis.entity.Address;
import org.mybatis.mapper.AddressMapper;
import org.spring.config.BeanInterface;
import org.spring.dto.ResponseDTO;
import org.spring.entities.MyInfo;
import org.spring.mail.SpringMail;
import org.spring.retry.CircuyService;
import org.spring.retry.RetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/config")
public class Mycontroller {
	
	@Value("${springnew2.name}")
	private String name;
	@Autowired
	BeanInterface bean;
	@Autowired
	SpringMail springMail;
	@Autowired
	private AddressMapper addressMapper;

	@Autowired
	private RetryService retryService;

	@Autowired
	private CircuyService circuyService;

	@RequestMapping(value="/uploadFile",produces="application/xml")
	public MyInfo request(@RequestPart MultipartFile file) {
		MyInfo info=new MyInfo();

		info.setUsername(file.getOriginalFilename());
		return info;
	}
	
	
	@RequestMapping(value="/queryConfig")
	
	public String queryConfig() {
		return bean.toString();
		
	}
	
	
	@RequestMapping(value="/queryEnv")
	@Autowired
	public String queryConfig(Environment env) {
		return env.getProperty("springnew.name");
		
	}
	
	@RequestMapping(value="/queryValue")
	@Autowired
	public String queryValue() {
		return name;
		
	}

	@RequestMapping(value="/sendMail")
	
	public String sendMail(@RequestParam(name="content") String content) {
		springMail.sendMail(content);
		return "sendMail Sucess";
		
	}
	
	

	@RequestMapping(value="/async")
	
	public Callable<String> sendAjax( String content) {
		
		return new Callable<String>() {
			 @Override
			   public String call() throws Exception {
			    Thread.sleep(1 * 1000L);
			    return "小单 - " + System.currentTimeMillis();
			   }
		};
		
	}

	@RequestMapping(value = "/async/function")
	public ResponseDTO<List<Address>> sendAsynFcuntion(String content){
		PageHelper.startPage(1,15);
		List<Address> addresses=  addressMapper.selectAll();
		ResponseDTO response=new ResponseDTO("0000","000");
		response.setData(addresses);
		springMail.sendMail(content);
		return 	response;




	}


	@RequestMapping(value = "/spirng/retry")
	public ResponseDTO<String> retry(String num){

		circuyService.retry(Integer.parseInt(num));
		return new ResponseDTO("0000","1232");
	}

	@RequestMapping(value = "/address/insert")
	public String insertMapper(){
		Address address=new Address();
		address.setId(666);
		address.setAddress("11");
		address.setUserId(00535);
		addressMapper.insert(address);
		return "sucess";
	}


}
