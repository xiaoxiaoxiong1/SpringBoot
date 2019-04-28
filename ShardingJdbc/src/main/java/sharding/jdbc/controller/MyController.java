package sharding.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sharding.jdbc.dbconf.mapper.AppBillInstallMapper;
import sharding.jdbc.dbconf.pojo.AppBillInstall;
import sharding.jdbc.utill.RestResult;

/**
 * @Created by Administrator on 2019/3/3.
 * @DESC
 * @DATE 03
 */
@RestController
@RequestMapping("/sharding")
public class MyController {


    @Autowired
    private AppBillInstallMapper mapper;
    @GetMapping("/insert")
    public RestResult insert( AppBillInstall install){

        mapper.insert(install);
       // mapper.insertUseGeneratedKeys()
       return RestResult.success();
    }

    @GetMapping("/select")
    public RestResult select( AppBillInstall install){


        // mapper.insertUseGeneratedKeys()
        return RestResult.success().payLoad( mapper.countMySql());
    }
}
