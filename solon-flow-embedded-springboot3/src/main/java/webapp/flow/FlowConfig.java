package webapp.flow;

import org.noear.solon.flow.FlowEngine;
import org.noear.solon.flow.driver.SimpleFlowDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlowConfig {
    @Bean
    public FlowEngine flowEngine(SpringContainer springContainer) {
        FlowEngine engine = FlowEngine.newInstance();

        engine.register(new SimpleFlowDriver(springContainer));
        engine.load("classpath:flow/*.yml");

        return engine;
    }
}
