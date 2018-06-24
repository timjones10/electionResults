import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class FileReaderTest {

    FileReader fileReader;

    @Before
    public void setUp(){
    fileReader = new FileReader();
    }

    @Test
    public void updateResults_Creates_Results_Object() throws Exception {
    fileReader.updateResults();
    assertEquals(2, fileReader.getResults().size());
    }

}