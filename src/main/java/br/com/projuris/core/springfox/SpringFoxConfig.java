package br.com.projuris.core.springfox;

import br.com.projuris.api.exceptionhandler.Problem;
import com.fasterxml.classmate.TypeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        var typeResolver = new TypeResolver();

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("V1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.projuris.api.v1"))
                .paths(PathSelectors.any()) //TODO: ideal -> .ant("/v1/**")
                .build()
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, ResponseMessages.globalGet())
                .globalResponseMessage(RequestMethod.PUT, ResponseMessages.globalPut())
                .globalResponseMessage(RequestMethod.POST, ResponseMessages.globalPost())
                .globalResponseMessage(RequestMethod.DELETE, ResponseMessages.globalDelete())
                .additionalModels(typeResolver.resolve(Problem.class))
                .apiInfo(apiInfo())
                .tags(new Tag("Clientes", "Gerencia os Clientes"))
                .tags(new Tag("Ordem Serviço", "Gerencia as Ordem de Serviços"));
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Sistema para controle de manutenção de equipamentos")
                .description("API aberta para Todos")
                .version("1")
                .contact(new Contact("Victtor Araújo Freitas", "http://www.victtorfreitas.br/", "victtorfreitas95@gmail.com"))
                .build();
    }
}
