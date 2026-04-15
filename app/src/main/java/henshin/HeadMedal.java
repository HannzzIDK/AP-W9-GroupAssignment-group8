package henshin;

public class HeadMedal extends CoreMedal {

    public HeadMedal(String name) {
        super(name); 
    }

    @Override
    public String getSlotPosition() {
        return "HEAD"; 
    }
}