package webapp;

import org.noear.solon.flow.FlowEngine;
import org.noear.solon.flow.driver.SimpleFlowDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import webapp.flow.SpringContainer;


@Configuration
public class FlowTest implements ApplicationListener<ApplicationStartedEvent> {
    @Bean
    public FlowEngine flowEngine(SpringContainer springContainer) {
        FlowEngine engine = FlowEngine.newInstance();

        engine.register(new SimpleFlowDriver(springContainer));
        engine.load("classpath:flow/*.yml");

        return engine;
    }

    @Autowired
    private FlowEngine flowEngine;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        flowEngine.eval("c1");
    }
}
