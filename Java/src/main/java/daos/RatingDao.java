package daos;

import entities.Rating;

import java.util.List;

public interface RatingDao {
    public Rating createRating(Rating r);

    public Rating readRating(int id);

    public List<Rating> readAllRatings();

    public Rating updateRating(Rating change);

    public Rating deleteRating(int id);

}

