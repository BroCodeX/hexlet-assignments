package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            var page = ctx.queryParamAsClass("page", Integer.class);
            var per = ctx.queryParamAsClass("per", Integer.class);
            int anwPage = page.getOrDefault(1);
            int anwPer = per.getOrDefault(5);
            if (anwPage > 1) {
                int start = (anwPage - 1) * anwPer;
                int finish = (anwPage - 1) * anwPer + anwPer;
                ctx.json(USERS.subList(start, finish));
            } else {
                ctx.json(USERS.subList(anwPage - 1, anwPer));
            }
        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
