package com.example.Spring_PrintRequest;

import com.example.Spring_PrintRequest.printrequest.PrintRequest;
import com.example.Spring_PrintRequest.printrequest.PrintRequestPrimarykey;
import com.example.Spring_PrintRequest.repository.PrintRequestJDBCTemplate;
import com.example.Spring_PrintRequest.repository.PrintRequestRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableWebMvc
@ServletComponentScan
public class SpringPrintRequestApplication implements WebMvcConfigurer {

//	@Override
//	public void configureViewResolvers(ViewResolverRegistry registry) {
//		registry.jsp("/WEB-INF/templates/", ".jsp");
//	}
//
//	@Override
//	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//		configurer.enable();
//	}
	public static void main(String[] args) {
		boolean report = true;
		ConfigurableApplicationContext appContext = SpringApplication.run(SpringPrintRequestApplication.class);
		PrintRequestJDBCTemplate templateRepo = appContext.getBean(PrintRequestJDBCTemplate.class);
		        List<PrintRequest> batchReqs = new ArrayList<>();
		batchReqs.add(
                PrintRequest.builder().id(new PrintRequestPrimarykey("10.20.567.09","123"))
						.cardPAN("1024569874254587").branchCode("123").personnelCode("100000").ipAddress("10.20.567.09").build()
        );
		batchReqs.add(
				PrintRequest.builder().id(new PrintRequestPrimarykey("10.20.567.17","345"))
						.cardPAN("1254789632021456").branchCode("345").personnelCode("100000").ipAddress("10.20.567.17").build()
		);
		templateRepo.batchInsertIntoPrintReqTableWithNamedParameter(batchReqs);
	}
	@Bean
	public ResourceBundleMessageSource messageSource(){
		ResourceBundleMessageSource reloadableResourceBundleMessageSource
				= new ResourceBundleMessageSource();
		reloadableResourceBundleMessageSource.setBasename("classpath:messages");
		reloadableResourceBundleMessageSource.setDefaultEncoding("UTF-8");
		return reloadableResourceBundleMessageSource;
	}
//
	@Bean
	public ViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/templates/");
		bean.setSuffix(".jsp");
		return bean;
	}



}
