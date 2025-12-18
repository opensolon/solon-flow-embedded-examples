package webapp;

import org.noear.solon.annotation.Init;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Managed;
import org.noear.solon.flow.FlowEngine;

@Managed
public class YamlFlowTest {
    @Inject
    FlowEngine flowEngine;

    @Init
    public void start() {
        flowEngine.eval("c1");
    }
}