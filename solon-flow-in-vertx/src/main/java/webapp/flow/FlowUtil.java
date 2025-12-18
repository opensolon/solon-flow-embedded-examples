package webapp.flow;

import org.noear.solon.flow.FlowEngine;
import org.noear.solon.flow.container.MapContainer;
import org.noear.solon.flow.driver.SimpleFlowDriver;

public class FlowUtil {
    private static final MapContainer container;
    private static final FlowEngine engine;

    static {
        container = new MapContainer();
        engine = FlowEngine.newInstance();

        //使用 map 容器
        engine.register(new SimpleFlowDriver(container));
        //加载 flow 的链配置
        engine.load("classpath:flow/*.yml");
    }

    public static MapContainer getContainer() {
        return container;
    }

    public static FlowEngine getEngine() {
        return engine;
    }
}
