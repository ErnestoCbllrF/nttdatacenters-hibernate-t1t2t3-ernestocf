package com.nttdata.hibernate.persistence;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Taller 1 Hibernate
 * 
 * Entidad de tabla NTTDATA_HEX_PLAYER
 * 
 * @author ernestocf
 *
 */

@Entity
@Table(name = "NTTDATA_T_CUSTOMER")
public class Customer extends AbstractEntity implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long customerID;

	/** Nombre del cliente */
	private String customerName;

	/** Primer apellido del cliente */
	private String customerFirstSurname;

	/** Segundo apellido del cliente */
	private String customerSecondSurname;

	/** DNI del cliente */
	private String customerDNI;

	/** Contrato */
	private Contract contract;

	/**
	 * 
	 * @return customerId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CUSTOMER_ID")
	public Long getCustomerID() {
		return customerID;
	}

	/**
	 * 
	 * @param customerId
	 */
	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}

	/**
	 * 
	 * @return customerName
	 */
	@Column(name = "CUSTOMER_NAME", nullable = false)
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * 
	 * @param customerName
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * 
	 * @return customerFirstSurname
	 */
	@Column(name = "CUSTOMER_SURNAME", nullable = false)
	public String getCustomerFirstSurname() {
		return customerFirstSurname;
	}

	/**
	 * 
	 * @param customerFirstSurname
	 */
	public void setCustomerFirstSurname(String customerFirstSurname) {
		this.customerFirstSurname = customerFirstSurname;
	}

	/**
	 * 
	 * @return customerSecondSurname
	 */
	@Column(name = "CUSTOMER_SECOND_SURNAME", nullable = false)
	public String getCustomerSecondSurname() {
		return customerSecondSurname;
	}

	/**
	 * 
	 * @param customerSecondSurname
	 */
	public void setCustomerSecondSurname(String customerSecondSurname) {
		this.customerSecondSurname = customerSecondSurname;
	}

	/**
	 * 
	 * @return customerDNI
	 */
	@Column(name = "CUSTOMER_DNI", nullable = false, unique = true)
	@Digits(integer = 9, fraction = 0)
	@Min(value = 1, message = "Numero inferior al mínimo.")
	@Max(value = 99999999, message = "Numero que excede el máximo.")
	public String getCustomerDNI() {
		return customerDNI;
	}

	/**
	 * 
	 * @param customerDNI
	 */
	public void setCustomerDNI(String customerDNI) {
		this.customerDNI = customerDNI;
	}
	
	/**
	 * 
	 * @return contract
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CONTRACT_ID", referencedColumnName = "CONTRACT_ID")
	public Contract getContract() {
		return contract;
	}

	/**
	 * 
	 * @param contract
	 */
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	
	/**
	 * Método toString()
	 */
	@Override
	public String toString() {
		return "[customerID = " + customerID + ", customerName = " + customerName + ", customerFirstSurname = "
				+ customerFirstSurname + ", customerSecondSurname = " + customerSecondSurname + ", customerDNI = "
				+ customerDNI + "]";
	}

	@Transient
	public Class<?> getClase() {
		return Customer.class;
	}

	@Transient
	@Override
	public Long getId() {
		return this.customerID;
	}

}
