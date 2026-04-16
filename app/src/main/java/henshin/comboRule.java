package henshin;

public class comboRule {
    private String comboName;
    private String headReq;
    private String armReq;
    private String legReq;

    public comboRule(String comboName, String headReq, String armReq, String legReq) {
        this.comboName = comboName;
        this.headReq = headReq;
        this.armReq = armReq;
        this.legReq = legReq;
    }

    public boolean isMatch(coreMedal h, coreMedal a, coreMedal l) {
        if (h == null || a == null || l == null)
            return false;

        return this.headReq.equalsIgnoreCase(h.getName()) &&
                this.armReq.equalsIgnoreCase(a.getName()) &&
                this.legReq.equalsIgnoreCase(l.getName());
    }

    public String getComboName() {
        return comboName;
    }
}
