package entities;

public class Picture {
    private int id;
    private byte file;
    private int mechId;

    public Picture(){
        super();
    }
    public Picture(int id, int mechId, byte file) {
        super();
        this.id = id;
        this.mechId = mechId;
        this.file = file;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public byte getFile() {
        return file;
    }
    public void setFile(byte file) {
        this.file = file;
    }
    public int getMechId() {
        return mechId;
    }
    public void setMechId(int mechId) {
        this.mechId = mechId;
    }

}

