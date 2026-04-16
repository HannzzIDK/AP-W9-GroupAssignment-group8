package henshin;

import java.util.ArrayList;
import java.util.List;

public class transformationEngine {
    private List<comboRule> officialCombo;

    public transformationEngine() {
        this.officialCombo = new ArrayList<>();
        loadOfficialCombos();
    }

    private void loadOfficialCombos() {
        officialCombo.add(new comboRule("Tatoba", "Taka", "Tora", "Batta"));
        officialCombo.add(new comboRule("Gatakiriba", "Kuwagata", "Kamakiri", "Batta"));
        officialCombo.add(new comboRule("Latorartar", "Lion", "Tora", "Cheetah"));
        officialCombo.add(new comboRule("Sagohzo", "Sai", "Gorilla", "Zou"));
        officialCombo.add(new comboRule("Shauta", "Shachi", "Unagi", "Tako"));
        officialCombo.add(new comboRule("Tajadol", "Taka", "Kujaku", "Condor"));
        officialCombo.add(new comboRule("Putotyra", "Ptera", "Tricera", "Tyranno"));
        officialCombo.add(new comboRule("Burakawani", "Cobra", "Kame", "Wani"));
    }

    public String identifyForm(coreMedal head, coreMedal arms, coreMedal legs) {
        if (head == null || arms == null || legs == null) {
            throw new IllegalStateException("Transformation Failed: All three slots must be filled!");
        }

        // Cek apakah cocok dengan Combo resmi
        for (comboRule rule : officialCombo) {
            if (rule.isMatch(head, arms, legs)) {
                return rule.getComboName() + " Combo!";
            }
        }

        // kalo combo tidak ada di officialCombo
        return "Mixed Form";
    }
}
