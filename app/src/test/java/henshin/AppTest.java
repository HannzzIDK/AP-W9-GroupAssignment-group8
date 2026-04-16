package henshin;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    private final PrintStream standardOut = System.out;
    private final InputStream standardIn = System.in;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
        System.setIn(standardIn);
    }

    @Test
    void testAllSwitchCases() {
        // Simulasi input untuk semua switch case (1 sampai 6, default, Exception, dan 0 untuk exit)
        // 1: View Available Medals
        // 2: Insert Medal (Pilih medal 1)
        // 3: Eject All Medals
        // 4: SCAN DRIVER (akan fail karena kosong / dsb, tapi tercatch dengan aman)
        // 5: TajaSpinner (Pilih 1 Add Medal, pilih medal 1)
        // 5: TajaSpinner (Pilih 2 Giga Scan)
        // 6: View Scan History
        // 9: Invalid choice (menguji branch default)
        // a: InputMismatchException (menguji error handling input bukan angka)
        // 0: Exit
        String simulatedUserInput = "1\n" +
                "2\n1\n" + 
                "3\n" +
                "4\n" +
                "5\n1\n1\n" +
                "5\n2\n" +
                "6\n" +
                "9\n" +
                "a\n" +
                "0\n";
        
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        
        App.main(new String[]{});
        
        String output = outputStreamCaptor.toString();
        
        // Memastikan program masuk ke setiap case yang diuji
        assertTrue(output.contains("MAIN MENU"), "Harus menampilkan menu");
        assertTrue(output.contains("MEDAL REPOSITORY"), "Case 1 gagal dijalankan"); 
        assertTrue(output.contains("Enter medal number from repository to insert"), "Case 2 gagal dijalankan");
        assertTrue(output.contains("TajaSpinner: [1] Add Medal [2] Giga Scan -> Choose"), "Case 5 gagal dijalankan");
        assertTrue(output.contains("Invalid choice. Please pick 0-6."), "Branch default gagal dijalankan");
        assertTrue(output.contains("ERROR: Please enter a valid number!"), "Exception handling gagal dijalankan");
        assertTrue(output.contains("Shutting down simulator"), "Case 0 gagal dijalankan");
    }
}
