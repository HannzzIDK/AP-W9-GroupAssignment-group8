package henshin;

import java.util.ArrayList;
import java.util.List;

public class OOODriver implements IScannable {
    @Override
    public List<CoreMedal> getMedalsForScanning() {
        return this.getMedals(); 
    }

    @Override
    public String getDeviceName() {
        return "OOO Driver Belt";
    }

    private List<CoreMedal> medals = new ArrayList<>();

    public void addMedal(CoreMedal medal) {
        if (medals.size() < 3) {
            medals.add(medal);
            System.out.println("[SYSTEM] " + medal.getName() + " inserted.");
        } else {
            System.out.println("[!] Driver is full!");
        }
    }

    public void ejectAll() {
        medals.clear();
        System.out.println("[SYSTEM] Medals ejected.");
    }

    public List<CoreMedal> getMedals() {
        return medals;
    }

    public boolean isReady() {
        return medals.size() == 3;
    }
}