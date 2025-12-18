package webapp;

import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.bean.LifecycleBean;
import org.noear.solon.flow.FlowEngine;

@Component
public class YamlFlowTest implements LifecycleBean {
    @Inject
    FlowEngine flowEngine;

    @Override
    public void start() throws Throwable {
        flowEngine.eval("c1");
    }
}
