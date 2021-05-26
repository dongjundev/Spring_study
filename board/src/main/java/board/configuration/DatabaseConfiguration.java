package board.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:/application.properties") //application.properties를 사용할 수 있도록 설정 파일의 위치를 정해 준다.
public class DatabaseConfiguration {
	
	@Autowired
	private ApplicationContext applicationContext;

    // application.properties에 설정했던 데이터베이스 관련 정보를 사용하도록 지정한다.
	//@ConfigurationProperties 어노테이션에 prefix가 spring.datasource.hikari로 설정되었기 때문에 
	//spring.datasource.hikari로 시작하는 설정을 이용해서 히카리CP의 설정파일을 만든다.
    @Bean
    @ConfigurationProperties(prefix="spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    //앞에서 만든 히카리CP의 설정파일을 이용해서 데이터베이스와 연결하는 데이터 소스를 생성한다. 
    //여기서는 데이터 소스가 정상적으로 생성되었는지 확인하기 위해서 데이터 소스를 출력했다.
    @Bean
    public DataSource dataSource() throws Exception {
        DataSource dataSource = new HikariDataSource(hikariConfig());
        System.out.println(dataSource.toString());
        return dataSource;
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/*.xml"));	//** : 하위폴더전체
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
