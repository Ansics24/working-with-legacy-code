package de.schulte.smartbar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

@Configuration
@ComponentScan({"de.schulte.smartbar.management", "de.schulte.smartbar.ordering"})
@EnableWebMvc
public class SmartBarAppConfig implements WebMvcConfigurer {



}
