package henshin;

public abstract class CoreMedal {
    protected String name;

    public CoreMedal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getSlotPosition(); 
}