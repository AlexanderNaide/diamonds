package org.satal.diamonds.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Data
@Component
@PropertySource("classpath:application.properties")
public class Properties {

    @Value("${window.height}")
    private Integer windowHeight;

    @Value("${window.width}")
    private Integer windowWidth;

    @Value("${gameWindow.height}")
    private Integer gameWindowHeight;

    @Value("${gameWindow.width}")
    private Integer gameWindowWidth;

    @Value("${grid.lineCount}")
    private Integer gridLineCount;

    @Value("${grid.height}")
    private Integer gridHeight;

    @Value("${grid.width}")
    private Integer gridWidth;

}
