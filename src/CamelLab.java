import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;

public class CamelLab {
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        CamelContext ctx = main.getOrCreateCamelContext();
        ctx.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file:work/inbox").to("file:work/outbox");
            }
        });
        main.run();
    }
}
