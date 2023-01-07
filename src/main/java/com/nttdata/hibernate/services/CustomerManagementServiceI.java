package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.Contract;
import com.nttdata.hibernate.persistence.Customer;

/**
 * Talleres Hibernate
 * 
 * Servicio gestión de clientes
 * 
 * @author ernestocf
 *
 */
public interface CustomerManagementServiceI {

	/**
	 * Insertar cliente.
	 * 
	 * @param customer
	 */
	public void insertNewCustomer(Customer customer);

	/**
	 * Actualizar cliente.
	 * 
	 * @param customer
	 */
	public void updateCustomer(Customer customer);

	/**
	 * Eliminar cliente.
	 * 
	 * @param customer
	 */
	public void deleteCustomer(Customer customer);

	/**
	 * Obtener todos los clientes.
	 * 
	 * @return List<Customer>
	 */

	public List<Customer> searchAll();

	/**
	 * 
	 * @param customerID
	 * @return
	 */
	public Customer searchById(Long customerID);

	/**
	 * Insertar nuevo contrato.
	 * 
	 * @param contract
	 */
	public void insertNewContract(Contract contract);

	/**
	 * Actualizar contrato.
	 * 
	 * @param contract
	 */
	public void updateContract(Contract contract);

	/**
	 * Eliminar contrato.
	 * 
	 * @param contract
	 */
	public void deleteContract(Contract contract);

	/**
	 * Obtener contrato por ID
	 * 
	 * @param contractId
	 */
	public List<Customer> searchByNameAndContractId(String name, Long contractId);

	/**
	 * Obtiene todos los contratos existentes.
	 * 
	 * @return List<Contract>
	 */
	public List<Contract> searchAllContract();

	/**
	 * Obtiene el nombre del cliente completo
	 * 
	 * @param customerName
	 * @param customerFirstSurname
	 * @param customerSecondSurname
	 * @return
	 */
	List<Customer> searchByNameAndSurnames(String customerName, String customerFirstSurname,
			String customerSecondSurname);

}
