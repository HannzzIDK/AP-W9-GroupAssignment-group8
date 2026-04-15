package henshin;
import java.util.List;

public interface IScannable {
    List<CoreMedal> getMedalsForScanning();
    String getDeviceName();
}