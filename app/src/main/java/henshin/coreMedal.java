package henshin;

public abstract class coreMedal implements IScannable {
    protected String part;
    protected String name;

    public coreMedal(String part, String name) {
        this.part = part;
        this.name = name;
    }

    public String getPart() {
        return part;
    }

    public String getName() {
        return name;
    }

    @Override
    public void scan() {
        System.out.println(this.name + "!");
    }
}

class headMedal extends coreMedal {
    public headMedal(String name) {
        super("Head", name);
    }
}

class armsMedal extends coreMedal {
    public armsMedal(String name) {
        super("Arms", name);
    }
}

class legsMedal extends coreMedal {
    public legsMedal(String name) {
        super("Legs", name);
    }
}
