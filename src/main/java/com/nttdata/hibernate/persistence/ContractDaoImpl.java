package com.nttdata.hibernate.persistence;

import org.hibernate.Session;
/**
 * Talleres Hibernate
 * 
 * Implementación Dao Contrato
 * 
 * @author ernestocf
 *
 */

public class ContractDaoImpl extends CommonDaoImpl<Contract> implements ContractDaoI {
	/**
	 * Constructor
	 * 
	 * @param session
	 */
	public ContractDaoImpl(Session session) {
		super(session);
	}

}
