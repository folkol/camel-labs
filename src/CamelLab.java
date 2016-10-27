import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelLab {
    public static void main(String[] args) throws Exception {
        DefaultCamelContext ctx = new DefaultCamelContext();
        ctx.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file:work/inbox").to("file:work/outbox");
            }
        });
        ctx.start();

        while (ctx.isStarted()) {
            Thread.sleep(10);
        }
        System.out.println("Shutting down...");
    }
}
