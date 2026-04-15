package henshin;

public class ComboCatalogue {

    public static String checkCombo(String head, String arms, String legs) {
        switch (head.toLowerCase()) {
            case "taka":
                if (arms.equalsIgnoreCase("tora") && legs.equalsIgnoreCase("batta")) {
                    return "TATOBA! (Taka, Tora, Batta)";
                } else if (arms.equalsIgnoreCase("kujaku") && legs.equalsIgnoreCase("condor")) {
                    return "TAJADOL! (Taka, Kujaku, Condor)";
                }
                break;

            case "kuwagata":
                if (arms.equalsIgnoreCase("kamakiri") && legs.equalsIgnoreCase("batta")) {
                    return "GATAKIRIBA! (Kuwagata, Kamakiri, Batta)";
                }
                break;

            case "lion":
                if (arms.equalsIgnoreCase("tora") && legs.equalsIgnoreCase("cheetah")) {
                    return "LATORARTAR! (Lion, Tora, Cheetah)";
                }
                break;

            case "sai":
                if (arms.equalsIgnoreCase("gorilla") && legs.equalsIgnoreCase("zou")) {
                    return "SAGOHZO! (Sai, Gorilla, Zou)";
                }
                break;

            case "shachi":
                if (arms.equalsIgnoreCase("unagi") && legs.equalsIgnoreCase("tako")) {
                    return "SHAUTA! (Shachi, Unagi, Tako)";
                }
                break;

            case "ptera":
                if (arms.equalsIgnoreCase("tricera") && legs.equalsIgnoreCase("tyranno")) {
                    return "PUTOTYRA! (Ptera, Tricera, Tyranno)";
                }
                break;

            case "cobra":
                if (arms.equalsIgnoreCase("kame") && legs.equalsIgnoreCase("wani")) {
                    return "BURAKAWANI! (Cobra, Kame, Wani)";
                }
                break;

            default:
                return "UNKNOWN"; 
        }
        return "MIXED FORM"; 
    }
}