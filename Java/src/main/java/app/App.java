package app;

import controllers.MechController;
import controllers.PictureController;
import controllers.RatingController;
import controllers.UserController;
import daos.*;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;
import services.*;

public class App {

    public static void main(String[] args) {

        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins);


        establishRoutes(app);

        app.start(7000);
}
    private static void establishRoutes(Javalin app) {

        UserDao ud = new UserDaoImpl();
        UserService us = new UserServiceImpl(ud);
        UserController uc = new UserController(us);

        MechDao md = new MechDaoImpl();
        MechService ms = new MechServiceImpl(md);
        MechController mc = new MechController(ms);

        PictureDao pd = new PictureDaoImpl();
        PictureService ps = new PictureServiceImpl(pd);
        PictureController pc = new PictureController(ps);

        RatingDao rd = new RatingDaoImpl();
        RatingService rs = new RatingServiceImpl(rd);
       RatingController rc = new RatingController(rs);

        app.get("/welcome", (context) -> context.result("Welcome Landing Page!"));
        app.get("/welcome2", new WelcomePageHandler());

        app.get("/user", uc.readAllUsers);
        app.get("/user/{id}", uc.readUserById);
        app.post("/user", uc.createUser);
        app.put("user/id", uc.updateUser);
        app.delete("/user/{id}", uc.deleteUser);

        app.get("/mech", mc.readAllMechs);
        app.get("/mech/{id}", mc.readMechById);
        app.post("/mech", mc.createMech);
        app.put("mech/id", mc.updateMech);
        app.delete("/mech/{id}", mc.deleteMech);

        app.get("/picture", pc.readAllPictures);
        app.get("/picture/{id}", pc.readPictureById);
        app.post("/picture", pc.createPicture);
        app.put("picture/{id}", pc.updatePicture);
        app.delete("/picture/{id}", pc.deletePicture);

        app.get("/rating", rc.readAllRatings);
        app.get("/rating/{id}", rc.readRatingById);
        app.post("/rating", rc.createRating);
        app.put("rating/{id}", rc.updateRating);
        app.delete("/rating/{id}", rc.deleteRating);

    }
}

