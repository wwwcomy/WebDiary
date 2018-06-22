package com.iteye.wwwcomy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * 用于将原本存于Access中的数据导入到MySQL中
 * 由于原本Access中，不同用户的日记都是存在不同的数据库里的，这点在MySQL中应该是所有用户的日记都存在于同一个数据库中，由一个UserId做关联。
 * 在导出过程中有一个数据转换的过程要做处理，Access中直接存的unicode(待补充)
 * 
 * @author wwwcomy
 *
 */
@Configuration
@EnableAutoConfiguration
@EnableJpaAuditing
@ComponentScan(basePackages = "com.iteye.wwwcomy", excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = TaskManagerApplication.class) })
public class MigrationMain {

	public static void main(String[] args) throws Exception {
		SpringApplication app = new SpringApplication(MigrationMain.class);
		app.setWebEnvironment(false);
		app.run(args);
	}

}
