package exercise;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

// BEGIN

// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        app.get("/companies/{id}", ctx -> {
            String id = ctx.pathParamAsClass("id", String.class).getOrDefault(null);
            var result = COMPANIES.stream()
                    .filter(map -> map.get("id").equals(id))
                    .findFirst()
                    .orElseThrow(() -> new NotFoundResponse("Company not found"));
            ctx.json(result);
        });
        // END



        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }

    public static boolean isKeyPresent (String id) {
        return COMPANIES.stream()
                .anyMatch(item -> item.containsKey("id") && item.get("id").equals(id));
    }
}
