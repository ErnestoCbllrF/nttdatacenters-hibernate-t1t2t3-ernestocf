package com.nttdata.hibernate.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

/**
 * Talleres Hibernate
 * 
 * Implementación Dao Cliente
 * 
 * @author ernestocf
 *
 */
public class CustomerDaoImpl extends CommonDaoImpl<Customer> implements CustomerDaoI {
	
	/** Sesión conexión a BBDD */
	private Session session;

	/**
	 * Método constructor
	 */
	public CustomerDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> searchByNameAndSurnames(String customerName, String customerFirstSurname,
			String customerSecondSurname) {

		// Verificar la sesión.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Filtra clientes según su nombre completo.
		return session.createQuery("FROM Customer WHERE customerName='" + customerName + "' AND customerFirstSurname='"
				+ customerFirstSurname + "' AND customerSecondSurname='" + customerSecondSurname + "'").list();

	}

	@Override
	public List<Customer> searchByNameAndContractId(String customerName, Long contractID) {

		// Consultas criteria.
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<Customer> cquery = cb.createQuery(Customer.class);
		final Root<Customer> root = cquery.from(Customer.class);
		final Join<Customer, Contract> pJoinT = root.join("contract");

		// Clausulas Where.
		Predicate pre1 = cb.equal(pJoinT.<Long>get("contractID"), contractID);
		Predicate pre2 = cb.like(root.<String>get("customerName"), customerName);

		// Consulta completa.
		cquery.select(root).where(cb.and(pre1, pre2));

		// Ejecución de consulta.
		return session.createQuery(cquery).getResultList();
	}


}
