package henshin;

public class ArmsMedal extends CoreMedal {

    public ArmsMedal(String name) {
        super(name);
    }

    @Override
    public String getSlotPosition() {
        return "ARMS";
    }
}