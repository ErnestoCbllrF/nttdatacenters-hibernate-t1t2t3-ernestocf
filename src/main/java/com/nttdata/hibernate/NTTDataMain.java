package com.nttdata.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Contract;
import com.nttdata.hibernate.persistence.Customer;
import com.nttdata.hibernate.services.CustomerManagementServiceI;
import com.nttdata.hibernate.services.CustomerManagementServiceImpl;

/**
 * Talleres Hibernate
 * 
 * Clase Main
 * 
 * @author ernestocf
 *
 */
public class NTTDataMain {
	public static void main(String[] args) {
		// Apertura de sesión.
		Session session = NTTDataHibernateUtil.getSessionFactory().openSession();

		// Inicializar servicios.
		CustomerManagementServiceI contractService = new CustomerManagementServiceImpl(session);

		// Auditoria.
		String updatedUser = "ErnestoCF";
		Date updatedDate = new Date();

		// Creación de clientes.
		Customer c1 = new Customer();
		c1.setCustomerName("Lionel");
		c1.setCustomerFirstSurname("Messi");
		c1.setCustomerSecondSurname("Cuccittini");
		c1.setCustomerDNI("10101010");
		c1.setUpdatedUser(updatedUser);
		c1.setUpdatedDate(updatedDate);

		Customer c2 = new Customer();
		c2.setCustomerName("Maria Isabel");
		c2.setCustomerFirstSurname("Rodríguez");
		c2.setCustomerSecondSurname("Rosario");
		c2.setCustomerDNI("12345678");
		c2.setUpdatedUser(updatedUser);
		c2.setUpdatedDate(updatedDate);

		// Insercción de clientes
		contractService.insertNewCustomer(c1);
		contractService.insertNewCustomer(c2);

		// Creación contrato
		Contract co1 = new Contract();
		co1.setValidityDate("2021-01-14");
		co1.setExpiringDate("2024-12-12");
		co1.setContractPrice(50000.00);
		co1.setUpdatedUser(updatedUser);
		co1.setUpdatedDate(updatedDate);

		// Asignación de contrato a clientes
		c1.setContract(co1);
		c2.setContract(co1);

		// Insercción nuevos contratos
		contractService.insertNewContract(co1);

		// Búsqueda de cliente por nombre completo
		List<Customer> customerFullName = contractService.searchByNameAndSurnames("Lionel", "Messi", "Cuccittini");

		// Búsqueda de todos los clientes
		List<Customer> customerNames = contractService.searchAll();

		// Búsqueda de los clientes por su ID
		long customerID = 2L;
		Customer searchID = contractService.searchById(customerID);
		if (searchID != null) {
			System.out.println("Cliente con la ID: " + customerID);
			System.out.println(searchID.toString());
		}

		// Busqueda de clientes por nombre e Id de contrato.
		// Criteria.
		List<Customer> customerNameContract = contractService.searchByNameAndContractId("L%", 3L);

		// Generacion de resultados: Consulta HQL.
		for (Customer customer : customerFullName) {

			System.out.println(customer.getCustomerName() + " " + customer.getCustomerFirstSurname() + " "
					+ customer.getCustomerSecondSurname());
		}

		for (Customer customer : customerNames) {
			System.out.println(customer.toString());
		}

		// Consulta Criteria.
		for (final Customer customer : customerNameContract) {
			String price = String.format("%.0f", customer.getContract().getContractPrice());

			System.out.println(
					"Nombre: " + customer.getCustomerName() + ", " + " Apellido: " + customer.getCustomerFirstSurname()
							+ ", " + "Segundo Apellido : " + customer.getCustomerSecondSurname() + ", "
							+ "ID Contrato : " + customer.getContract().getContractID() + ", " + "Fecha de expiración :"
							+ customer.getContract().getExpiringDate() + ", " + "Precio de contrato: " + price);

		}

		// Cierre de sesión.
		session.close();

	}
}
