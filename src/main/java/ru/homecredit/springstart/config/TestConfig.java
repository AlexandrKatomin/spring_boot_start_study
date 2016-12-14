package ru.homecredit.springstart.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "prefix")
public class TestConfig {
    private String stringProp1;
    private String stringProp2;
    @Max(99)
    @Min(0)
    private Integer intProp1;
    private List<String> listProp;
    private Map<String, String> mapProp;

    @PostConstruct
    public void init() {
        int i = 1;
        i++;
    }
}
