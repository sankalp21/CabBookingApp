package src.Repository;

import java.util.List;
import java.util.Optional;

public interface IRepository<I, T> {
	public Optional<T> save(T obj);
	public Optional<T> findById(I id);
	public Optional<T> update(T obj);
	public Boolean delete(T obj);
	public List<T> findAll();
}
