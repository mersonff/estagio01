package dao;
import java.util.List;

public interface GenericDAO<T> {

	public void save(T entity);
	
	//acrescentado por David Costa
	public void put(T entity);
	//
	
	public void delete(T entity);
	public T find(Object id);
	public List<T> find();
	public void beginTransaction();
	public void commit();
	public void rollback();
	public void close();

}
