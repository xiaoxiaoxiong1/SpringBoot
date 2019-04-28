package sharding.jdbc.dbconf.mapper;

import org.springframework.stereotype.Component;
import sharding.jdbc.dbconf.pojo.AppBillInstall;
import sharding.jdbc.utill.MyMapper;

@Component
public interface AppBillInstallMapper extends MyMapper<AppBillInstall> {

    public Integer countMySql();

}