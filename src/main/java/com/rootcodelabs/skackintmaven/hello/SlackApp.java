package com.rootcodelabs.skackintmaven.hello;

import com.slack.api.bolt.App;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SlackApp {
    @Bean
    public App initSlackApp() {
        App app = new App();
        app.command("/hello", (req, ctx) -> {
            String commandArgText = req.getPayload().getText();
            String channelId = req.getPayload().getChannelId();
            String channelName = req.getPayload().getChannelName();
            String text = "You said " + commandArgText + " at <#" + channelId + "|" + channelName + ">";
            ctx.respond(text); // perform an HTTP request
            System.out.println(text);
            String payload =
                    "{\n" +
                            "\t\"blocks\": [\n" +
                            "\t\t{\n" +
                            "\t\t\t\"type\": \"section\",\n" +
                            "\t\t\t\"text\": {\n" +
                            "\t\t\t\t\"type\": \"plain_text\",\n" +
                            "\t\t\t\t\"text\": \"Hello\",\n" +
                            "\t\t\t\t\"emoji\": true\n" +
                            "\t\t\t}\n" +
                            "\t\t},\n" +
                            "\t\t{\n" +
                            "\t\t\t\"type\": \"actions\",\n" +
                            "\t\t\t\"elements\": [\n" +
                            "\t\t\t\t{\n" +
                            "\t\t\t\t\t\"type\": \"button\",\n" +
                            "\t\t\t\t\t\"text\": {\n" +
                            "\t\t\t\t\t\t\"type\": \"plain_text\",\n" +
                            "\t\t\t\t\t\t\"text\": \"Click Me\",\n" +
                            "\t\t\t\t\t\t\"emoji\": true\n" +
                            "\t\t\t\t\t},\n" +
                            "\t\t\t\t\t\"value\": \"click_me_123\",\n" +
                            "\t\t\t\t\t\"action_id\": \"actionId-0\"\n" +
                            "\t\t\t\t}\n" +
                            "\t\t\t]\n" +
                            "\t\t}\n" +
                            "\t]\n" +
                            "}";
            return ctx.ack(payload); // respond with 200 OK
        });
        return app;
    }
}
