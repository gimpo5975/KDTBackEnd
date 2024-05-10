package com.shopapi.config;

import com.shopapi.controller.formatter.LocalDateFormatter;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Log4j2
public class CustomServletConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {//LocalDateFormatter 클래스 addFormatters 에 등록
        log.info("-------------------------------");
        log.info("addFormatter");
        registry.addFormatter(new LocalDateFormatter());

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {//메서드의 매개변수인 CorsRegistry registry는 CORS 설정을 추가하거나 수정하는 데 사용됩니다.
                                                        // 메서드에서는 CorsRegistry 객체를 사용하여 CORS 설정을 추가합니다.

        registry.addMapping("/**")
                //이 설정은 모든 URL 경로(/**)에 대해 CORS 설정을 추가합니다. 즉, 애플리케이션의 모든 URL 경로에 대해 CORS 규칙을 적용합니다.
                .maxAge(500)//CORS 사전 플라이트 요청(Preflight request)의 결과를 얼마나 오랫동안 캐싱할지를 설정합니다.
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
                //이 설정은 CORS 요청에서 허용되는 HTTP 메서드(GET, POST, PUT, DELETE, HEAD, OPTIONS)를 지정합니다.
                //클라이언트는 이 메서드 중 하나를 사용하여 애플리케이션에 요청을 보낼 수 있습니다.
                .allowedOrigins("*");//모든 출처에서 요청을 허용한다는 의미입니다. 이는 모든 도메인에서 요청을 받아들이겠다는 의미입니다.

    }
}
