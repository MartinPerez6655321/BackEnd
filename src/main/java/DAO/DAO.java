package DAO;

import java.util.List;

public interface DAO<T> {
	
	public T crear(T t);
	public void eliminar(T t);	
	public T porId(long id);	
	public List<T> todos();
	public T actualizar(T t);
	
	
	//en esta forma de trabajar, no nos queda alternativa a tener este método para cerrar el EM.
	public void cerrar();

}

