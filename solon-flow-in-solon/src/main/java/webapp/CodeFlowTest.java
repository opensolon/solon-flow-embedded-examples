package webapp;

import org.noear.solon.annotation.Init;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Managed;
import org.noear.solon.flow.*;

@Managed
public class CodeFlowTest {
    @Inject
    FlowEngine flowEngine;

    @Init
    public void start() {
        case1();
        case2();
    }


    private void case1() {
        Graph graph = Graph.create("case1", decl -> {
            decl.addStart("n1").linkAdd("n2");
            decl.addActivity("n2").linkAdd("n3").task("@Cace1Com");
            decl.addEnd("n3");
        });

        //可以正常输出 yaml, json
        System.out.println(graph.toYaml());

        flowEngine.eval(graph);
    }

    @Managed("Cace1Com")
    public class Cace1Com implements TaskComponent {
        @Override
        public void run(FlowContext context, Node node) throws Throwable {
            System.out.println("---------hello world!");
        }
    }

    private void case2() {
        Graph graph = Graph.create("case2", decl -> {
            decl.addStart("n1").linkAdd("n2");
            decl.addActivity("n2").linkAdd("n3").task((c, n) -> {
                System.out.println("---------hello world!");
            });
            decl.addEnd("n3");
        });

        //输出 yaml, json 时，task 为空（因为接口实列没法字符串化）
        System.out.println(graph.toYaml());

        flowEngine.eval(graph);
    }
}