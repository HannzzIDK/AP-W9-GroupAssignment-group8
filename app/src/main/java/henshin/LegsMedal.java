package henshin;

public class LegsMedal extends CoreMedal {

    public LegsMedal(String name) {
        super(name);
    }

    @Override
    public String getSlotPosition() {
        return "LEGS";
    }
}