import static org.junit.Assert.*;
import org.junit.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;

public class TestDocSearch {
	@Test 
	public void testIndex() throws URISyntaxException, IOException {
    Handler h = new Handler("./technical/");
    URI rootPath = new URI("http://localhost/");
    assertEquals("There are 1392 total files to search.", h.handleRequest(rootPath));
	}
	@Test 
	public void testSearch() throws URISyntaxException, IOException {
    Handler h = new Handler("./technical/");
    URI rootPath = new URI("http://localhost/search?q=Resonance");
    String expect = "Found 2 paths:\n./technical/biomed/ar615.txt\n./technical/plos/journal.pbio.0020150.txt";
    assertEquals(expect, h.handleRequest(rootPath));
	}

    @Test
    public void testSearch2() throws URISyntaxException, IOException {
        Handler h = new Handler("./technical/");
        URI rootPath = new URI("http://localhost/search?q=hello");
        String expect = "Found 0 paths:\n";
        assertEquals(expect, h.handleRequest(rootPath));
    }

    @Test 
	public void testSearch3() throws URISyntaxException, IOException {
    Handler h = new Handler("./technical/");
    URI rootPath = new URI("http://localhost/search?q=pizza");
    String expect = "Found 2 paths:\n./technical/911report/chapter-7.txt\n./technical/plos/journal.pbio.0020012.txt";
    assertEquals(expect, h.handleRequest(rootPath));
	}

    @Test 
	public void testSearch3() throws URISyntaxException, IOException {
    Handler h = new Handler("./technical/");
    URI rootPath = new URI("http://localhost/search?title=my-text");
    String expect = "Found 1 paths:\n./technical/911report/my-text.txt\n";
    assertEquals(expect, h.handleRequest(rootPath));
	}
}

