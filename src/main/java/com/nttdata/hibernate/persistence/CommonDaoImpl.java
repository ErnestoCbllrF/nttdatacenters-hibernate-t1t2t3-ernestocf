package com.nttdata.hibernate.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

/**
 * Talleres Hibernate
 * 
 * Implementación Dao Común
 * 
 * @author ernestocf
 *
 * @param <R>
 */
public abstract class CommonDaoImpl<R extends AbstractEntity> implements CommonDaoI<R> {

	/** Tipo de clase */
	private Class<R> entityClass;

	/** Sesión de conexión a BBDD */
	private Session session;

	/**
	 * Constructor
	 * 
	 * @param session
	 */

	@SuppressWarnings("unchecked")
	protected CommonDaoImpl(Session session) {
		setEntityClass(
				(Class<R>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
	}

	@Override
	public void insert(R paramR) {

		// Verificar la sesión
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.save(paramR);
		session.flush();

		// Commit.
		session.getTransaction().commit();
	}

	@Override
	public void update(R paramR) {

		// Verificar la sesión
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.saveOrUpdate(paramR);

		// Commit.
		session.getTransaction().commit();
	}

	@Override
	public void delete(R paramR) {
		// Verificar la sesión
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Inserción.
		session.delete(paramR);

		// Commit.
		session.getTransaction().commit();

	}

	@Override
	public R searchById(Long id) {

		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda por ID.
		return session.get(this.entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<R> searchAll() {

		// Verificar la sesión
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda de registros
		return session.createQuery("FROM " + this.entityClass.getName()).list();
	}

	/**
	 * @return the entityClass
	 */
	public Class<R> getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass the entityClass to set
	 * 
	 */
	public void setEntityClass(Class<R> entityClass) {
		this.entityClass = entityClass;
	}

}
