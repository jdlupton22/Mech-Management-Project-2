package controllers;

import com.google.gson.Gson;
import entities.Rating;
import io.javalin.http.Handler;
import services.RatingService;

import java.util.List;

public class RatingController {

    private RatingService rs;

    private final Gson gson = new Gson();

    public RatingController(RatingService rs) {
        this.rs = rs;
    }
    public Handler readAllRatings = (context) -> {
        List<Rating> ratings = rs.readAllRatings();
        String ratingsJSON = gson.toJson(ratings);
        context.result(ratingsJSON);
    };
    public Handler readRatingById = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));
        Rating r = rs.readRating(id);
        context.result(gson.toJson(r));
    };
    public Handler deleteRating = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));
        Rating r = rs.deleteRating(id);
        context.result(gson.toJson(r));
    };
    public Handler createRating = (context) -> {

        Rating r = gson.fromJson(context.body(), Rating.class);
        r = rs.createRating(r);
        context.result(gson.toJson(r));
    };
    public Handler updateRating = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));
        Rating change = rs.deleteRating(id);
        context.result(gson.toJson(change));
    };
}
