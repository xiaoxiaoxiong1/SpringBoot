package sharding.jdbc.dbconf.base;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import tk.mybatis.mapper.provider.SpecialProvider;

/**
 * @Created by Administrator on 2019/3/16.
 * @DESC
 * @DATE 16
 */
@tk.mybatis.mapper.annotation.RegisterMapper
public interface MySpecialMapper<T> {

    @Options(useGeneratedKeys = true, keyProperty = "caseId")
    @InsertProvider(type = MySpecialProvider.class, method = "dynamicSQL")
    int insertMyUseGeneratedKeys(T record);
}
