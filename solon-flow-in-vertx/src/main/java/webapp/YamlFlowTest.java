package webapp;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import webapp.flow.FlowUtil;

public class YamlFlowTest extends AbstractVerticle {

    @Override
    public void start(Promise<Void> startPromise) {
        FlowUtil.getEngine().eval("c1");
    }
}
