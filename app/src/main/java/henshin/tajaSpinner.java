package henshin;

import java.util.ArrayList;
import java.util.List;

public class tajaSpinner {
    // Syarat Rubrik: COLLECTIONS
    private List<coreMedal> stack;
    private final int MAX_CAPACITY = 7; // Kapasitas maksimal Taja Spinner

    public tajaSpinner() {
        this.stack = new ArrayList<>();
    }

    public void addMedal(coreMedal medal) {
        if (medal == null)
            return;

        // Syarat Rubrik: EXCEPTION HANDLING
        if (stack.size() >= MAX_CAPACITY) {
            throw new IllegalStateException("Spinner is full! Cannot add " + medal.getName());
        }

        stack.add(medal);
        System.out.println(
                "Added " + medal.getName() + " to TajaSpinner. (Total: " + stack.size() + "/" + MAX_CAPACITY + ")");
    }

    public void ejectAll() {
        stack.clear();
        System.out.println("TajaSpinner emptied.");
    }

    public void gigaScan() {
        if (stack.isEmpty()) {
            System.out.println("\n[Spinner Empty] Click... click...");
            return;
        }

        System.out.print("\n>>> GIGA SCAN! ");

        // Membaca semua koin di dalam tumpukan
        for (coreMedal m : stack) {
            System.out.print(m.getName().toUpperCase() + "! ");
        }
        System.out.println("GIGA SCANNED!!! <<<");
    }
}