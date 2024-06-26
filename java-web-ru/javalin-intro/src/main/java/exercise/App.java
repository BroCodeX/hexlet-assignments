package exercise;

// BEGIN
import io.javalin.Javalin;
// END

public final class App {

    public static Javalin getApp() {

        // BEGIN
        Javalin app = Javalin.create(config -> config.bundledPlugins.enableDevLogging());
        return app;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.get("/welcome", handler -> handler.result("Welcome to Hexlet!"));
        app.start(7070);
    }
}
