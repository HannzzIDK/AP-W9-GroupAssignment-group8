package henshin;

import java.util.ArrayList;
import java.util.List;

public class OOOdriver {
    private coreMedal headSlot;
    private coreMedal armSlot;
    private coreMedal legSlot;

    private String currentForm = "";

    // Syarat Rubrik: COLLECTIONS untuk Scan History
    private List<String> scanHistory;

    public OOOdriver() {
        this.scanHistory = new ArrayList<>();
    }

    // Memasukkan koin ke slot yang tepat
    public void insertMedal(coreMedal medal) {
        if (medal == null)
            return;

        // Syarat Rubrik: EXCEPTION HANDLING
        String part = medal.getPart().toUpperCase();
        switch (part) {
            case "HEAD":
                if (headSlot != null)
                    throw new IllegalArgumentException("HEAD slot is already occupied by " + headSlot.getName() + "!");
                headSlot = medal;
                System.out.println("Inserted " + medal.getName() + " into HEAD slot.");
                break;
            case "ARMS":
                if (armSlot != null)
                    throw new IllegalArgumentException("ARMS slot is already occupied by " + armSlot.getName() + "!");
                armSlot = medal;
                System.out.println("Inserted " + medal.getName() + " into ARMS slot.");
                break;
            case "LEGS":
                if (legSlot != null)
                    throw new IllegalArgumentException("LEGS slot is already occupied by " + legSlot.getName() + "!");
                legSlot = medal;
                System.out.println("Inserted " + medal.getName() + " into LEGS slot.");
                break;
            default:
                throw new IllegalArgumentException("Unknown medal part: " + part);
        }
    }

    // Mengeluarkan semua koin
    public void ejectAll() {
        headSlot = null;
        armSlot = null;
        legSlot = null;
        currentForm = ""; // Reset form saat koin dicabut
        System.out.println("All medals ejected from the Driver.");
    }

    // Mengeluarkan satu koin spesifik (Bonus Task)
    public void ejectMedal(String part) {
        switch (part.toUpperCase()) {
            case "HEAD":
                headSlot = null;
                break;
            case "ARMS":
                armSlot = null;
                break;
            case "LEGS":
                legSlot = null;
                break;
        }
        currentForm = ""; // Form batal jika satu koin dicabut
        System.out.println("Ejected medal from " + part + " slot.");
    }

    // --- Getters & Setters ---
    public coreMedal getHead() {
        return headSlot;
    }

    public coreMedal getArms() {
        return armSlot;
    }

    public coreMedal getLegs() {
        return legSlot;
    }

    public String getCurrentForm() {
        return currentForm;
    }

    public void recordScan(String form) {
        this.currentForm = form;
        scanHistory.add(form);
    }

    public void printScanHistory() {
        System.out.println("\n--- Scan History ---");
        if (scanHistory.isEmpty()) {
            System.out.println("No scans recorded yet.");
        } else {
            for (int i = 0; i < scanHistory.size(); i++) {
                System.out.println((i + 1) + ". " + scanHistory.get(i));
            }
        }
    }
}