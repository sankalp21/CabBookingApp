package src.Storage;

import java.util.HashMap;
import java.util.Map;

public class Storage<I, T> {
	private Map<I, T> db;
	
	public Storage() {
		this.db = new HashMap<I, T>();
	}

	public Map<I, T> getDb() {
		return db;
	}

	public void setDb(Map<I, T> db) {
		this.db = db;
	}
	
}
