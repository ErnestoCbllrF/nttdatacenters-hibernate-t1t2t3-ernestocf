package com.nttdata.hibernate.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Transient;

/**
 * Talleres Hibernate
 * 
 * Entidad Abstracta
 * 
 * @author ernestocf
 *
 */

public abstract class AbstractEntity implements Serializable {
	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;

	/** Usuario actualizado */
	private String updatedUser;

	/** Fecha actualizada */
	private Date updatedDate;

	/**
	 * Obtener el ID de usuario
	 * 
	 * @return Long
	 */
	@Transient
	public abstract Long getId();

	/**
	 * @return updatedUser
	 */
	@Column(name = "ABSTRACT_UPDATED_USER", nullable = false)
	public String getUpdatedUser() {
		return updatedUser;
	}

	/**
	 * @param updatedUser
	 */

	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	/**
	 * @return updatedDate
	 */
	@Column(name = "ABSTRACT_UPDATED_DATE")
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
