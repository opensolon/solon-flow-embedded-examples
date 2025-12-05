package webapp;

import jakarta.annotation.PostConstruct;
import org.noear.solon.flow.FlowEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlowTest {
    @Autowired
    private FlowEngine flowEngine;

    @PostConstruct
    public void init() {
        flowEngine.eval("c1");
    }
}
