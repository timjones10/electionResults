import java.io.File;
import java.util.*;

public class FileReader {

    private List<Result> results = new ArrayList<>();

    public void updateResults() throws Exception {
        Scanner scanner = new Scanner(new File("/Users/timjones/Documents/Tesco/electionResults/src/main/resources/Results.csv"));
        while (scanner.hasNextLine()) {
            Result result = new Result();
            String[]resultData = scanner.nextLine().split(",");
            result.setConstituencyName(resultData[0]);
            Map<String, String> votesByParty = new HashMap<>();
            for (int v = 1; v <= resultData.length -2; v+=2) {
                votesByParty.put(resultData[v], resultData[v+1]);
            }
            result.setVotesByParty(votesByParty);
            results.add(result);
        }
    }



    public List getResults() {
        return results;
    }
}
