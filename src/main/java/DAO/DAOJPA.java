package DAO;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

public class DAOJPA<T> implements DAO<T> {

	
	protected EntityManager entityManager;

	private Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public DAOJPA() {

		entityManager = EntityManagers.createEntityManager();

		 ParameterizedType genericSuperclass = (ParameterizedType) getClass()
	             .getGenericSuperclass();
	        this.entityClass = (Class<T>) genericSuperclass
	             .getActualTypeArguments()[0];
	}
	

	public T crear(T t) {

		entityManager.getTransaction().begin();		
		entityManager.persist(t);		
		entityManager.getTransaction().commit();
		
		return t;
	}
	
	public T actualizar(T t){
		entityManager.getTransaction().begin();		
		T resultado = this.entityManager.merge(t);
		entityManager.getTransaction().commit();
		
		return resultado;
	}
	
	public void cerrar() {
		entityManager.close();
	}
	
	public void eliminar(T t){

		entityManager.getTransaction().begin();

		  t = this.entityManager.merge(t);
	      this.entityManager.remove(t);
		entityManager.getTransaction().commit();	
	}

	public T porId(long id){
		entityManager.getTransaction().begin();

		 T resultado = (T) this.entityManager.find(entityClass, id);
		 
		 entityManager.getTransaction().commit();
		 
		 return resultado;
	}
	
	public List<T> todos(){
		entityManager.getTransaction().begin();
		
		@SuppressWarnings("unchecked")
		List<T> resultados = entityManager.createQuery( "from " + entityClass.getName() ).getResultList();
		
		entityManager.getTransaction().commit();
		
		return resultados;
	}
	
}
