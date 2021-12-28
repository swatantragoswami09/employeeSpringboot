package com.nagarro.thread;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Map;

import com.nagarro.readcsv.ReadCSV;

public class Watcher extends Thread {

	ReadCSV obj;

	public Watcher(ReadCSV obj) {
		this.obj = obj;
	}

	@Override
	public void run() {
		Map<WatchKey, Path> keyMap = new HashMap<WatchKey, Path>();

		WatchService service;
		try {
			service = FileSystems.getDefault().newWatchService();

			keyMap = new HashMap<WatchKey, Path>();

			Path path = Paths.get("D:\\Eclipse Projects Workspace\\ProductSearchUsingSpring\\ProductSearchUsingSpring\\CSVFiles");
			keyMap.put(
					path.register(service, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
							StandardWatchEventKinds.ENTRY_MODIFY),

					path);
			WatchKey watchKey;
			do {

				watchKey = service.take();

				String helper = "";
				Path eventDir = keyMap.get(watchKey);

				for (WatchEvent<?> event : watchKey.pollEvents()) {
					WatchEvent.Kind<?> kind = event.kind();
					Path eventPath = (Path) event.context();
					helper += kind + " " + eventPath + "|";
				}
				if (helper.length() > 0) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					obj.readCSV();

				}

			} while (watchKey.reset());
			watchKey.cancel();

		} catch (

		Exception e) {
			e.printStackTrace();
		}

	}

}
