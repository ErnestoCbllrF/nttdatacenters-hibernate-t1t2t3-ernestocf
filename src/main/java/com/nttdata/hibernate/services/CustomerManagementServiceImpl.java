package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Contract;
import com.nttdata.hibernate.persistence.ContractDaoI;
import com.nttdata.hibernate.persistence.ContractDaoImpl;
import com.nttdata.hibernate.persistence.Customer;
import com.nttdata.hibernate.persistence.CustomerDaoI;
import com.nttdata.hibernate.persistence.CustomerDaoImpl;

/**
 * Talleres Hibernate
 * 
 * Implementación servicio gestión de clientes
 * 
 * @author ernestocf
 *
 */
public class CustomerManagementServiceImpl implements CustomerManagementServiceI {

	/**
	 * Dao Cliente
	 */
	private CustomerDaoI customerDao;

	/**
	 * Dao Contrato
	 */
	private ContractDaoI contractDao;

	/**
	 * Constructor
	 * 
	 * @param session
	 */
	public CustomerManagementServiceImpl(Session session) {
		this.customerDao = new CustomerDaoImpl(session);
		this.contractDao = new ContractDaoImpl(session);
	}

	@Override
	public void insertNewCustomer(Customer customer) {
		// Comprobación de si el cliente es nulo
		if (customer != null && customer.getCustomerID() == null) {

			// Insertar nuevo cliente
			customerDao.insert(customer);
		}
	}

	@Override
	public void updateCustomer(Customer customer) {
		// Comprobación de si existe o es nulo
		if (customer != null && customer.getCustomerID() == null) {
			// Actualizar cliente
			customerDao.update(customer);
		}
	}

	@Override
	public void deleteCustomer(Customer customer) {
		if (customer != null && customer.getCustomerID() == null) {
			// Borrar cliente
			customerDao.delete(customer);
		}

	}

	@Override
	public List<Customer> searchAll() {

		List<Customer> customerListResult;

		customerListResult = customerDao.searchAll();

		return customerListResult;
	}

	@Override
	public Customer searchById(Long customerID) {
		// Variable auxiliar para el resultado.
		Customer customerRes = null;

		// Comprobación de nulo
		if (customerID != null) {

			// Obtención de la busqueda.
			customerRes = customerDao.searchById(customerID);
		}

		return customerRes;
	}

	@Override
	public void insertNewContract(Contract contract) {
		if (contract != null && contract.getContractID() == null) {
			// Insertar nuevo contrato.
			contractDao.insert(contract);
		}
	}

	@Override
	public void updateContract(Contract contract) {
		if (contract != null && contract.getContractID() == null) {
			// Actualizar contrato existente.
			contractDao.update(contract);
		}
	}

	@Override
	public void deleteContract(Contract contract) {
		if (contract != null && contract.getContractID() == null) {
			// Borrar contrato.
			contractDao.delete(contract);
		}

	}

	@Override
	public List<Customer> searchByNameAndContractId(String customerName, Long contractId) {
		List<Customer> clientListResult;

		// Resultado con el patrón especificado.
		clientListResult = customerDao.searchByNameAndContractId(customerName, contractId);
		return clientListResult;
	}

	@Override
	public List<Contract> searchAllContract() {
		// Lista auxiliar
		List<Contract> contractListResult;

		// Obtencion de contratos.
		contractListResult = contractDao.searchAll();

		return contractListResult;
	}

	@Override
	public List<Customer> searchByNameAndSurnames(String customerName, String customerFirstSurname,
			String customerSecondSurname) {
		// Lista auxiliar
		List<Customer> customerListResult = new ArrayList<>();

		// Comprobación de si el nombre es nulo
		if (StringUtils.isNotBlank(customerName)) {
			customerListResult = customerDao.searchByNameAndSurnames(customerName, customerFirstSurname, customerSecondSurname);
		}
		return customerListResult;
	}

}
