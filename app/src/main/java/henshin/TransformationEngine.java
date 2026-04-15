package henshin;

import java.util.List;

public class TransformationEngine {
    public void processTransformation(IScannable device) throws IncompleteComboException {
        List<CoreMedal> currentMedals = device.getMedalsForScanning();
        int medalCount = currentMedals.size();

        if (device instanceof OOODriver) {
            if (medalCount != 3) {
                throw new IncompleteComboException("(!) Error: OOO Driver butuh tepat 3 medal untuk transformasi! (Saat ini: " + medalCount + ")");
            }

            CoreMedal hMedal = null;
            CoreMedal aMedal = null;
            CoreMedal lMedal = null;

            for (CoreMedal m : currentMedals) {
                if (m instanceof HeadMedal) hMedal = m;
                else if (m instanceof ArmsMedal) aMedal = m;
                else if (m instanceof LegsMedal) lMedal = m;
            }

            if (hMedal == null || aMedal == null || lMedal == null) {
                throw new IncompleteComboException("(!) Konfigurasi Salah: Harus ada 1 Head, 1 Arms, dan 1 Legs medal!");
            }

            String result = ComboCatalogue.checkCombo(hMedal.getName(), aMedal.getName(), lMedal.getName());

            System.out.println("\n--- SCANNING " + device.getDeviceName().toUpperCase() + " ---");
            System.out.println("Result: " + result);
            System.out.println("----------------\n");

        } 
        else if (device instanceof tajaSpinner) {
            tajaSpinner spinner = (tajaSpinner) device;
            int powerResult = spinner.calculatePower();

            System.out.println("\n--- SCANNING " + device.getDeviceName().toUpperCase() + " ---");
            System.out.println("Medals Scanned: " + medalCount);
            System.out.println("Total Power: " + powerResult);
            
            if (medalCount == 7) {
                System.out.println("STATUS: GIGA SCAN READY!");
            }
            System.out.println("----------------\n");
        }
    }
}