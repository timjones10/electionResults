import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultsPrinter {

    static Map<String, String> partyNames;

    static {
        partyNames = new HashMap<>();
        partyNames.put("L", "Labour");
        partyNames.put("C", "Conservatives");
    }

    public void print(List<Result> results) {
        for (int r = 0; r < results.size(); r++) {
                System.out.println(results.get(r).getConstituencyName());
                results.get(r).getVotesByParty().forEach((key, value) -> {
                    System.out.println(lookUpPartyName(value) + ": " + key + " votes");
                });
            }
        }

    private String lookUpPartyName(String value) {
        return partyNames.get(value);
    }

}