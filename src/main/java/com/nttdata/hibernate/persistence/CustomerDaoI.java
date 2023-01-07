package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * Taller Practico 1 Hibernate
 * 
 * DAO de clientes
 * 
 * @author ernestocf
 *
 */
public interface CustomerDaoI extends CommonDaoI<Customer>{
	/**
	 * Obtener clientes por nombre y apellidos.
	 * 
	 * @param customerName
	 * @param customerFirstSurname
	 * @param customerSecondSurname
	 * @return List<Customer>
	 */
	public List<Customer> searchByNameAndSurnames(final String customerName, final String customerFirstSurname,
			final String customerSecondSurname);

	/**
	 * Obtener nombre y el ID del contrato
	 * 
	 * @param customerName
	 * @param contractId
	 * @return
	 */
	List<Customer> searchByNameAndContractId(String customerName, Long contractId);

}
