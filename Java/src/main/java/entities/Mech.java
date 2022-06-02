package entities;

public class Mech {
    private int id;
    private String make;
    private String model;
    private String year;
    private String color;
    private Double maxSpeed;
    private Double weight;
    private Double height;
    private String description;
    private int pilotCount;
    private Boolean available;


    public Mech() {
        super();
    }
    public Mech(int id, String make, String model, String year, String color, Double maxSpeed, Double weight,
                Double height, String description, int pilotCount, Boolean available) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.height = height;
        this.description = description;
        this.pilotCount = pilotCount;
        this.available = available;


    }

    public int getId() {
        return id;
    }
    public void setMechId(int id) {
        this.id = id;
    }
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Double getMaxSpeed() {
        return maxSpeed;
    }
    public void setMaxSpeed(Double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.make = make;
    }
    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getPilotCount() {
        return pilotCount;
    }
    public void setPilotCount(int pilotCount) {

        this.pilotCount = pilotCount;
    }

    public Boolean getAvailable() {
        return available;
    }
    public void setAvailable(Boolean available) {
        this.available = available;
    }

}

