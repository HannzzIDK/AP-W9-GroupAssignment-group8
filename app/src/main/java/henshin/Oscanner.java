package henshin;

public class Oscanner {
    private transformationEngine engine;

    public Oscanner(transformationEngine engine) {
        this.engine = engine;
    }

    public void scan(OOOdriver driver) {
        System.out.println("\n=== SCANNING ===");
        try {
            // Panggil mesin untuk mengecek kombinasi koin
            String result = engine.identifyForm(driver.getHead(), driver.getArms(), driver.getLegs());

            // Logika Scanning Charge: Jika form tidak berubah dari sebelumnya
            if (result.equals(driver.getCurrentForm())) {
                System.out.println(">>> SCANNING CHARGE!!! <<<");
                driver.recordScan("Scanning Charge (" + result + ")");
            } else {
                // Transformasi baru
                System.out.println(">>> " + result.toUpperCase() + "!!! <<<");
                driver.recordScan(result);
            }

        } catch (IllegalStateException e) {
            // Menangkap error jika slot belum penuh (dari TransformationEngine)
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}