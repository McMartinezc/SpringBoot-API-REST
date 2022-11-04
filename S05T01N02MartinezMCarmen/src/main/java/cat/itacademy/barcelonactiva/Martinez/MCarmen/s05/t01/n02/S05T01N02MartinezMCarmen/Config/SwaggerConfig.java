package cat.itacademy.barcelonactiva.Martinez.MCarmen.s05.t01.n02.S05T01N02MartinezMCarmen.Config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import static springfox.documentation.builders.PathSelectors.regex;

//Configuración  Swagger para la generación de documentación de la Api Rest
//http://localhost:9001/swagger-ui/index.html#/
//https://www.coderearth.net/swagger-java-spring-boot-rest-api/
//https://codingnconcepts.com/spring-boot/how-to-configure-swagger/#:~:text=How%20to%20configure%20Swagger%20in%20spring%20boot%201,7%20Generate%20REST%20Client%20with%20Swagger%20Codegen%20
//https://www.springboottutorial.com/spring-boot-swagger-documentation-for-rest-services
@Configuration
//Anotación que habilita el Swagger
@EnableSwagger2
@ConditionalOnProperty(name="app.api.swagger.enable", havingValue = "true", matchIfMissing = false)
public class SwaggerConfig {

@Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                //.paths(PathSelectors.any())
                .paths(regex("/flor*"))
                .build()
                .apiInfo(apiDetails());
    }

    //datos de la documentación de la api
    private ApiInfo apiDetails (){
        return new ApiInfoBuilder().title("Spring Boot Flors API REST")
                .description("Spring Boot Flors API REST")
                .termsOfServiceUrl("http://localhost:9001/flor")
                .contact(new Contact("MC", "http://localhost:9001/","flor@email.com"))
                .version("1").build();
    }


}
