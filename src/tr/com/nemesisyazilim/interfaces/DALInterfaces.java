package tr.com.nemesisyazilim.interfaces;

import java.util.List;

public interface DALInterfaces<T> {

	public void Insert(T entity);
	public List<T> getAll();
	public T Delete(T entity);
	public void Update(T entity);
	public List<T> getById(int id);
	
}
