package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * Talleres Hibernate
 * 
 * Interfaz Dao Común
 * 
 * @author ernestocf
 *
 */
public interface CommonDaoI<R> {

	/**
	 * Insertar registro en BBDD.
	 * 
	 * @param paramR
	 */
	public void insert(R paramR);

	/**
	 * Actualizar registro en BBDD.
	 * 
	 * @param paramR
	 */
	public void update(R paramR);

	/**
	 * Eliminar registro en BBDD.
	 * 
	 * @param paramU
	 */
	public void delete(R paramR);

	/**
	 * Obtener registro por ID en BBDD.
	 * 
	 * @param paramU
	 */
	public R searchById(Long id);

	/**
	 * Buscar todos los registros en BBDD.
	 * 
	 * @return List<R>
	 */
	public List<R> searchAll();

}
