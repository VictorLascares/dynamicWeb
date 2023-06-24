package com.mx.DynamicWeb.models;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "consignatario")
public class Consignatario {
	@Id
	private int consignatarioid;
	private boolean consignatarioactivo;
	private String consignatarionombre;

	@CreationTimestamp(source = SourceType.DB)
	private Timestamp consignatariofechacreacion;
	@UpdateTimestamp(source = SourceType.DB)
	private Timestamp consignatariofechamodificacion;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "clienteid")
	Cliente cliente;
	
	
	
	@Override
	public String toString() {
		return "Consignatario [consignatarioid=" + consignatarioid + ", consignatarioactivo=" + consignatarioactivo
				+ ", consignatarionombre=" + consignatarionombre + ", cliente=" + cliente + "]";
	}

	public int getConsignatarioid() {
		return consignatarioid;
	}

	public void setConsignatarioid(int consignatarioid) {
		this.consignatarioid = consignatarioid;
	}

	public boolean getConsignatarioActivo() {
		return consignatarioactivo;
	}

	public void setConsignatarioactivo(boolean consignatarioactivo) {
		this.consignatarioactivo = consignatarioactivo;
	}

	public String getConsignatarionombre() {
		return consignatarionombre;
	}

	public void setConsignatarioNombre(String consignatarionombre) {
		this.consignatarionombre = consignatarionombre;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Timestamp getConsignatariofechacreacion() {
		return consignatariofechacreacion;
	}

	public void setConsignatariofechacreacion(Timestamp consignatariofechacreacion) {
		this.consignatariofechacreacion = consignatariofechacreacion;
	}

	public Timestamp getConsignatariofechamodificacion() {
		return consignatariofechamodificacion;
	}

	public void setConsignatariofechamodificacion(Timestamp consignatariofechamodificacion) {
		this.consignatariofechamodificacion = consignatariofechamodificacion;
	}

}
