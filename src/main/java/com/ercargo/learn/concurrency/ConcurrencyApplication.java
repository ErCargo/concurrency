package com.ercargo.learn.concurrency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ConcurrencyApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ConcurrencyApplication.class, args);
	}


	/**
	 * 过滤掉threadLocal 开头的方法
	 * @return
	 */
	@Bean
	public FilterRegistrationBean httpFilter(){
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new HttpFilter());
		//registrationBean.addUrlPatterns("/threadLocal/*");
		return registrationBean;
	}

	/**
	 *
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/**
		 * 把路径全部拦截住
		 */
		registry.addInterceptor(new HttpInterceptor()).addPathPatterns("/**");
	}
}

