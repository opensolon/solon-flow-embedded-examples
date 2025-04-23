package webapp;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import webapp.flow.FlowUtil;

public class FlowTest extends AbstractVerticle {

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        FlowUtil.getEngine().eval("c1");
    }
}
