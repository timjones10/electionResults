import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ResultsPrinterTest {

    ResultsPrinter printer;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Mock
    private Result resultMock;

    private Map<String,String> votesByParty = new HashMap<>();

    List<Result> results = new ArrayList<>();

    @Before
    public void setUp(){
        printer = new ResultsPrinter();
    }
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void print_method_sends_rendered_result_to_Out(){
        results.add(resultMock);
        votesByParty.put("1234", "L");
        votesByParty.put("123", "C");
        when(resultMock.getConstituencyName()).thenReturn("Islington");
        when(resultMock.getVotesByParty()).thenReturn(votesByParty);
        printer.print(results);
        assertEquals("Islington\nConservatives: 123 votes\nLabour: 1234 votes\n", outContent.toString());
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}