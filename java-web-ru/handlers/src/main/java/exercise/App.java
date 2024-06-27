package exercise;

import io.javalin.Javalin;

import javax.naming.Context;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        Javalin app = Javalin.create(config -> config.bundledPlugins.enableDevLogging());;
        app.get("/phones", hnd -> hnd.json(Data.getPhones()));
        app.get("/domains", hnd -> hnd.json(Data.getDomains()));
        return app;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
