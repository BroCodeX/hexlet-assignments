package exercise;

import io.javalin.Javalin;
import io.javalin.http.HttpStatus;
import io.javalin.validation.ValidationException;
import java.util.List;
import exercise.model.Article;
import exercise.dto.articles.ArticlesPage;
import exercise.dto.articles.BuildArticlePage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

import exercise.repository.ArticleRepository;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/articles", ctx -> {
            List<Article> articles = ArticleRepository.getEntities();
            var page = new ArticlesPage(articles);
            ctx.render("articles/index.jte", model("page", page));
        });

        // BEGIN
        app.get("/articles/build", context -> {
            BuildArticlePage page = new BuildArticlePage();
            context.render("articles/build.jte", model("page", page));
        });

        app.post("/articles", context -> {
            try {
                String title = context.formParamAsClass("title", String.class)
                        .check(item -> item.trim().length() >= 2, "Название не должно быть короче двух символов")
                        .check(App::isUnique, "Статья с таким названием уже существует")
                        .get().trim();
                String content = context.formParamAsClass("content", String.class)
                        .check(item -> item.length() >= 10, "Статья должна быть не короче 10 символов")
                        .get();
                Article article = new Article(title, content);
                ArticleRepository.save(article);
                context.redirect("/articles");
            } catch (ValidationException ex) {
                String title = context.formParam("title").trim();
                String content = context.formParam("content").trim();
                BuildArticlePage page = new BuildArticlePage(title, content, ex.getErrors());
                context.status(422).render("articles/build.jte", model("page", page));
            }
        });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }

    public static boolean isUnique(String title) {
        return ArticleRepository.getEntities().stream()
                .noneMatch(article -> article.getTitle().equals(title.trim()));
    }
}
