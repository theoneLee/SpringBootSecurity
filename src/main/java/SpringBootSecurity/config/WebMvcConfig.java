package SpringBootSecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 如果有需要便利的将一个url直接匹配一个view时，可以直接在这里配，而不需要重新写一个controller（只用来映射视图）
 * Created by Lee on 2017/6/19 0019.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/login").setViewName("login");
//        registry.addStatusController();
//        registry.addRedirectViewController();
    }
}
