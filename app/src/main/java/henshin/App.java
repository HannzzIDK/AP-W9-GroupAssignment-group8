package henshin;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Inisialisasi Hardware & Engine
        OOODriver belt = new OOODriver();
        tajaSpinner spinner = new tajaSpinner();
        TransformationEngine engine = new TransformationEngine();
        
        // Menggunakan Generic Oscanner untuk IScannable
        Oscanner<IScannable> scannerDevice = new Oscanner<>();

        boolean running = true;

        System.out.println("   KAMEN RIDER OOO - SYSTEM START UP   ");

        while (running) {
            System.out.println("\nMAIN MENU");
            System.out.println("1. Masukkan Medal ke Belt (Slot 1-3)");
            System.out.println("2. Masukkan Medal ke Taja Spinner (Slot 1-7)");
            System.out.println("3. SCAN OOO DRIVER (Henshin!)");
            System.out.println("4. SCAN TAJA SPINNER (Giga Scan!)");
            System.out.println("5. Eject Semua Medal (Reset)");
            System.out.println("0. Matikan Sistem");
            System.out.print("Pilih aksi: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan Nama Medal (Taka, Tora, Batta, dll): ");
                    String beltMedalName = input.nextLine();
                    System.out.println("Pilih Tipe: [1] Head [2] Arms [3] Legs");
                    int type = input.nextInt();
                    
                    if (type == 1) belt.addMedal(new HeadMedal(beltMedalName));
                    else if (type == 2) belt.addMedal(new ArmsMedal(beltMedalName));
                    else if (type == 3) belt.addMedal(new LegsMedal(beltMedalName));
                    else System.out.println("(!) Tipe tidak valid.");
                    break;

                case 2:
                    System.out.print("Masukkan Nama Medal untuk Spinner: ");
                    String spinnerMedalName = input.nextLine();
                    spinner.addMedal(new HeadMedal(spinnerMedalName));
                    break;

                case 3:
                    try {
                        scannerDevice.scan(belt, engine);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        scannerDevice.scan(spinner, engine);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;

                case 5:
                    belt.ejectAll();
                    spinner = new tajaSpinner();
                    System.out.println("[SYSTEM] Semua device telah dikosongkan.");
                    break;

                case 0:
                    running = false;
                    System.out.println("Sistem dimatikan. Sampai jumpa, OOO!");
                    break;

                default:
                    System.out.println("(!) Pilihan tidak tersedia.");
            }
        }
        input.close();
    }
}