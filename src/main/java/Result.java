import java.util.Map;

public class Result {

    public void setConstituencyName(String constituencyName) {
        this.constituencyName = constituencyName;
    }

    private String constituencyName = new String();

    public void setVotesByParty(Map votesByParty) {
        this.votesByParty = votesByParty;
    }

    private Map<String, String> votesByParty;

    public String getConstituencyName() {
        return constituencyName;
    }

    public Map<String, String> getVotesByParty() {
        return votesByParty;
    }
}
