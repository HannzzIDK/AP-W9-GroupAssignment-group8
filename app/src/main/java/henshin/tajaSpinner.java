package henshin;

import java.util.ArrayList;
import java.util.List;

public class tajaSpinner implements IScannable {
    private List<CoreMedal> slots = new ArrayList<>();

    public int calculatePower() {
        int count = this.slots.size();
        if (count == 7) {
            return 1000;
        }
        return count * 100;
    }

    public void addMedal(CoreMedal m) {
        if (slots.size() < 7) {
            slots.add(m);
            System.out.println("[SPINNER] " + m.getName() + " added to Taja Spinner.");
        } else {
            System.out.println("[!] Taja Spinner is full!");
        }
    }

    @Override
    public List<CoreMedal> getMedalsForScanning() {
        return slots;
    }

    @Override
    public String getDeviceName() {
        return "Taja Spinner";
    }
}