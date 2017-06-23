/**
 * 
 */
package java8.ocp.sg2.appendix_c;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 * @author Pete
 *
 */
public class WatchServiceSample2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		try (WatchService service = FileSystems.getDefault().newWatchService()) {
			// Register for events
			Path tempData = Paths.get("C:\\temp");
			Path devData = Paths.get("C:\\OmnixDev");
			tempData.register(service, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
					StandardWatchEventKinds.ENTRY_MODIFY);
			devData.register(service, StandardWatchEventKinds.ENTRY_MODIFY);

			// create infinite loop
			// Poll for events
			for (;;) {// while(true)
				// Handling of events
				WatchKey key;
				try {
					key = service.take();
				} catch (InterruptedException x) {
					break;
				}

				// Retrieve events for key
				for (WatchEvent<?> event : key.pollEvents()) {
					WatchEvent.Kind<?> kind = event.kind();
					if (kind == StandardWatchEventKinds.OVERFLOW) { // recommended, but not always required
						continue;
					}
					// Process event
					WatchEvent<Path> watchEvent = (WatchEvent<Path>) event;
					Path path = watchEvent.context();
					System.out.println("[eventType=" + kind + ", path=" + path.getFileName() + "]");
				}
				// Remember to always reset event key
				if (!key.reset()) {
					break;
				}

			}

		}
	}
}