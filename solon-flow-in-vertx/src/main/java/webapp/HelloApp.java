package webapp;

import io.vertx.core.Vertx;

public class HelloApp {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        vertx.deployVerticle(new YamlFlowTest());
    }
}