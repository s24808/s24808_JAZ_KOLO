package pl.pjatk.jazs24808nbp.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.pjatk.jazs24808nbp.model.CurrencyQuery;

import java.util.List;

@Configuration
public class ConfigurationTest {

    @Bean
    @ConditionalOnProperty(prefix = "should.create.important", name = "bean", havingValue = "true")
    public CurrencyQuery exampleBean(){
        return new CurrencyQuery();
    }

    @Bean
    public List<String> defaultData(){
        return List.of("Some", "Example", "Strings", "Times", "Five");
    }
}
