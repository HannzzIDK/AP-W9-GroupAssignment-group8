package henshin;

public class Oscanner<T extends IScannable> {
    
    public void scan(T device, TransformationEngine engine) {
        System.out.println("[SCANNER] Scanning " + device.getDeviceName() + "...");
        
        try {
            engine.processTransformation(device);
        } catch (IncompleteComboException e) {
            System.err.println("[!] Scan Failed: " + e.getMessage());
        }
    }
}