package com.base.api.swagger;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.base.ConstantsCode;

import java.util.ArrayList;

@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages = { "com" })
@Configuration
public class SwaggerConfig extends WebMvcConfigurationSupport {

	@Bean
	public Docket createRestApi() {
		//自定义异常信息
		ArrayList<ResponseMessage> responseMessages = new ArrayList<ResponseMessage>() {{
			add(new ResponseMessageBuilder().code(200).message("成功").build());
			add(new ResponseMessageBuilder().code(102).message("登录失效，请重新登录").responseModel(new ModelRef("Error")).build());
			add(new ResponseMessageBuilder().code(500).message("服务器内部错误").responseModel(new ModelRef("Error")).build());
			add(new ResponseMessageBuilder().code(400).message("请求参数错误").responseModel(new ModelRef("Error")).build());
			add(new ResponseMessageBuilder().code(401).message("权限认证失败").responseModel(new ModelRef("Error")).build());
			add(new ResponseMessageBuilder().code(404).message("请求资源不存在").responseModel(new ModelRef("Error")).build());
			add(new ResponseMessageBuilder().code(403).message("请求资源不可用").responseModel(new ModelRef("Error")).build());
		}};
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
				.paths(PathSelectors.any())
				.build()
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.POST, responseMessages)
				.globalResponseMessage(RequestMethod.GET, responseMessages);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(ConstantsCode.PROJECT_NAME)
				.description("1.登录后默认所有接口都要传token，接口中不再说明<br/>2.接口统一返回errorCode,errorCode为0时有data数据,不为0时返回errorMsg")
				.termsOfServiceUrl(ConstantsCode.API_URL)
				.contact(new Contact("sun", "", ""))
				.version("1.0")
				.build();
	}
}