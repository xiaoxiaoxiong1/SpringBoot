package org.mybatis.tool;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class GeneratorMapper {
	
	
	public static void main(String args[]) throws Exception {
	       List<String> warnings = new ArrayList<String>();
	       boolean overwrite = true;
	       ConfigurationParser cp = new ConfigurationParser(warnings);
	       Configuration config = cp.parseConfiguration(
	               GeneratorMapper.class.getResourceAsStream("/generatorConfig.xml"));
	       Context context=config.getContext("Mysql");
	       List<TableConfiguration> configs= config.getContext("Mysql").getTableConfigurations();
	       for(TableConfiguration c:configs){
	           c.setCountByExampleStatementEnabled(false);
	           c.setUpdateByExampleStatementEnabled(false);
	           c.setUpdateByPrimaryKeyStatementEnabled(false);
	           c.setDeleteByExampleStatementEnabled(false);
	           c.setSelectByExampleStatementEnabled(false);
	       }
	       DefaultShellCallback callback = new DefaultShellCallback(overwrite);
	       MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
	       myBatisGenerator.generate(null);

	   }
}
