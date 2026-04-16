package henshin; // Sesuaikan dengan nama package-mu

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    // --- Pembuatan Class Konkret dari CoreMedal ---
    static class HeadMedal extends coreMedal {
        public HeadMedal(String name) {
            super(name, "HEAD");
        }
    }

    static class ArmMedal extends coreMedal {
        public ArmMedal(String name) {
            super(name, "ARMS");
        }
    }

    static class LegMedal extends coreMedal {
        public LegMedal(String name) {
            super(name, "LEGS");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Inisialisasi Semua Komponen Sistem
        transformationEngine engine = new transformationEngine();
        OOOdriver driver = new OOOdriver();
        Oscanner oScanner = new Oscanner(engine);
        tajaSpinner spinner = new tajaSpinner();

        // Syarat Rubrik: GENERICS
        medalRepository<coreMedal> repository = new medalRepository<>();

        // 2. Mengisi Koper Koin Ankh (Repository)
        repository.addMedal(new HeadMedal("Taka"));
        repository.addMedal(new ArmMedal("Tora"));
        repository.addMedal(new LegMedal("Batta"));
        repository.addMedal(new HeadMedal("Kuwagata"));
        repository.addMedal(new ArmMedal("Kamakiri"));
        repository.addMedal(new HeadMedal("Lion"));
        repository.addMedal(new LegMedal("Cheetah"));
        repository.addMedal(new ArmMedal("Kujaku"));
        repository.addMedal(new LegMedal("Condor"));

        boolean isRunning = true;

        System.out.println("===============================================");
        System.out.println("   OUGAMI FOUNDATION: OOO DRIVER SIMULATOR     ");
        System.out.println("===============================================");

        // 3. Main Loop Console UI
        while (isRunning) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. View Available Medals");
            System.out.println("2. Insert Medal to Driver");
            System.out.println("3. Eject All Medals from Driver");
            System.out.println("4. SCAN DRIVER!");
            System.out.println("5. TajaSpinner Menu (Bonus)");
            System.out.println("6. View Scan History");
            System.out.println("0. Exit");
            System.out.print("Choose action (0-6): ");

            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("\n--- MEDAL REPOSITORY ---");
                        for (int i = 0; i < repository.getSize(); i++) {
                            coreMedal m = repository.getMedalByIndex(i);
                            System.out.println((i + 1) + ". " + m.getName() + " [" + m.getPart() + "]");
                        }
                        break;

                    case 2:
                        System.out.print("Enter medal number from repository to insert: ");
                        int medalNum = scanner.nextInt();
                        coreMedal selectedMedal = repository.getMedalByIndex(medalNum - 1); // -1 karena index mulai
                                                                                            // dari 0
                        driver.insertMedal(selectedMedal);
                        break;

                    case 3:
                        driver.ejectAll();
                        break;

                    case 4:
                        oScanner.scan(driver);
                        break;

                    case 5:
                        System.out.print("\nTajaSpinner: [1] Add Medal [2] Giga Scan -> Choose: ");
                        int spinnerChoice = scanner.nextInt();
                        if (spinnerChoice == 1) {
                            System.out.print("Enter medal number to add to Spinner: ");
                            int spMedalNum = scanner.nextInt();
                            spinner.addMedal(repository.getMedalByIndex(spMedalNum - 1));
                        } else if (spinnerChoice == 2) {
                            spinner.gigaScan();
                        }
                        break;

                    case 6:
                        driver.printScanHistory();
                        break;

                    case 0:
                        System.out.println("Shutting down simulator... Goodbye!");
                        isRunning = false;
                        break;

                    default:
                        System.out.println("Invalid choice. Please pick 0-6.");
                }

                // --- SYARAT RUBRIK: EXCEPTION HANDLING ---
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Please enter a valid number!");
                scanner.nextLine(); // Membersihkan input yang rusak (Clear buffer)
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR: Medal number not found in repository!");
            } catch (IllegalArgumentException | IllegalStateException e) {
                // Menangkap error dari aturan bisnis (Slot penuh, scan sabuk kosong, spinner
                // penuh, dll)
                System.out.println("ACTION FAILED: " + e.getMessage());
            } catch (Exception e) {
                // Menangkap sisa error tak terduga
                System.out.println("UNEXPECTED ERROR: " + e.getMessage());
            }
        }

        scanner.close();
    }
}