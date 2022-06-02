package controllers;

import com.google.gson.Gson;
import entities.Mech;
import io.javalin.http.Handler;
import services.MechService;

import java.util.List;

public class MechController {
    private MechService ms;
    private Gson gson = new Gson();

    public MechController(MechService ms) {
        this.ms = ms;
    }

    public Handler readAllMechs = (context) -> {

        List<Mech> mechs = ms.readAllMechs();
        String mechsJSON = gson.toJson(mechs);
        context.result(mechsJSON);
    };

    public Handler readMechById = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));
        Mech m = ms.readMech(id);
        context.result(gson.toJson(m));
    };

    public Handler createMech = (context) -> {

        Mech m = gson.fromJson(context.body(), Mech.class);
        m = ms.createMech(m);
        context.result(gson.toJson(m));
    };
    public Handler deleteMech = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));
        Mech m = ms.deleteMech(id);
        context.result(gson.toJson(m));
    };
    public Handler updateMech = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));
        Mech change = ms.deleteMech(id);
        context.result(gson.toJson(change));
    };
}
