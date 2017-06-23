package java8.ocp.sg2.appendix_c;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.WatchService;

public class WatchServiceSample {


	public static void main(String[] args) throws IOException {
		
		// try with resources syntax
		
		try (WatchService service = FileSystems.getDefault().newWatchService()) {
			
			
			// do stuff
		}
		
		
		WatchService myService = FileSystems.getDefault().newWatchService();
		
		
		
		myService.close();
		
	}
}
