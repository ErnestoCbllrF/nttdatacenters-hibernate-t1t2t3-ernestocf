package com.nttdata.hibernate.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Talleres Hibernate
 * 
 * Tabla/Entidad Contrato
 * 
 * @author ernestocf
 *
 */
@Entity
@Table(name = "NTTDATA_T_CONTRACT")
public class Contract extends AbstractEntity implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** ID de contrato */
	private Long contractID;

	/** Fecha de vigencia del contrato */
	private String validityDate;

	/** Fecha de caducidad del contrato */
	private String expiringDate;

	/** Precio del contrato */
	private Double contractPrice;

	/** Relación con cliente */
	private List<Customer> customers;

	/**
	 * 
	 * @return contractID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CONTRACT_ID")
	public Long getContractID() {
		return contractID;
	}

	/**
	 * 
	 * @param contractID
	 */
	public void setContractID(Long contractID) {
		this.contractID = contractID;
	}

	/**
	 * 
	 * @return validityDate
	 */
	@Column(name = "VALIDITY_DATE", nullable = false)
	public String getValidityDate() {
		return validityDate;
	}

	/**
	 * 
	 * @param validityDate
	 */
	public void setValidityDate(String string) {
		this.validityDate = string;
	}

	/**
	 * 
	 * @return expiringDate
	 */
	@Column(name = "EXPIRING_DATE", nullable = false)
	public String getExpiringDate() {
		return expiringDate;
	}

	/**
	 * 
	 * @param expiryDate
	 */
	public void setExpiringDate(String string) {
		this.expiringDate = string;
	}

	/**
	 * 
	 * @return contractPrice
	 */
	@Column(name = "CONTRACT_PRICE", nullable = false)
	public Double getContractPrice() {
		return contractPrice;
	}

	/**
	 * 
	 * @param contractPrice
	 */
	public void setContractPrice(Double contractPrice) {
		this.contractPrice = contractPrice;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "contract")
	public List<Customer> getCustomers() {

		return customers;
	}

	/**
	 * @param customers
	 */
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@Transient
	@Override
	public Long getId() {
		return this.contractID;
	}

}
