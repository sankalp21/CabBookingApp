package src.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import src.Model.Entity;
import src.Storage.Storage;

public class RepositoryImpl<I, T extends Entity<I>> implements IRepository<I, T>{
	
	private Map<I, T> db;
	
	public RepositoryImpl(Storage<I, T> storage) {
		this.db = storage.getDb();
	}
	
	@Override
	public Optional<T> save(T obj) {
		// TODO Auto-generated method stub
		db.put((I) obj.getId(), obj);
		return Optional.ofNullable(obj);
	}

	@Override
	public Optional<T> findById(I id) {
		// TODO Auto-generated method stub
		if(db.containsKey(id)) {
			return Optional.ofNullable(db.get(id));
		}
		
		return Optional.ofNullable(null);
	}

	@Override
	public Optional<T> update(T obj) {
		// TODO Auto-generated method stub
		if(db.containsKey(obj.getId())) {
			return Optional.ofNullable(db.put((I) ((T)obj).getId(), obj));
		}
		return Optional.ofNullable(null);
	}

	@Override
	public Boolean delete(T obj) {
		// TODO Auto-generated method stub
		if(db.containsKey(obj.getId())) {
			db.remove((T)obj);
			return true;
		}
		return false;
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		List<T> entity = new ArrayList<T>();
		
		for(I id : db.keySet()) {
			entity.add(db.get(id));
		}
		
		return entity;
	}

}
