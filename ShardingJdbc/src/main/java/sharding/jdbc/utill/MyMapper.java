package sharding.jdbc.utill;

/**
 * @Created by Administrator on 2019/3/3.
 * @DESC
 * @DATE 03
 */

import sharding.jdbc.dbconf.base.MySpecialMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @package:com.cardapprove.xshq.quartz.mapper
 * @author: XIONGHAO
 * @Date: 2018/11/12
 * @Desc: TkMybatis DAO通用模板
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T>,MySpecialMapper{
}
