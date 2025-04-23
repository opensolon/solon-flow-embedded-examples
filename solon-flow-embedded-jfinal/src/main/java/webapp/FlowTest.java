package webapp;

import com.jfinal.plugin.IPlugin;
import webapp.flow.FlowUtil;


public class FlowTest implements IPlugin {
    @Override
    public boolean start() {
        FlowUtil.getEngine().eval("c1");

        return true;
    }

    @Override
    public boolean stop() {
        return true;
    }
}
