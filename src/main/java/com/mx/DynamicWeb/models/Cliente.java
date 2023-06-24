package com.mx.DynamicWeb.models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clienteid;
	private boolean clienteactivo;
	private String clientenombre;
	
	@CreationTimestamp(source = SourceType.DB)
	private Timestamp clientefechacreacion;
	@UpdateTimestamp(source = SourceType.DB)
	private Timestamp clientefechamodificacion;
	
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	List<Consignatario> consignatarios = new ArrayList<>();
	
	@Override
	public String toString() {
		return "Cliente [clienteid=" + clienteid + ", clienteactivo=" + clienteactivo + ", clientenombre="
				+ clientenombre + ", clientefechacreacion=" + clientefechacreacion + ", clientefechamodificacion="
				+ clientefechamodificacion + "]";
	}
	
	

	public void setClienteid(int clienteid) {
		this.clienteid = clienteid;
	}



	public int getClienteId() {
		return clienteid;
	}

	public boolean getClienteActivo() {
		return clienteactivo;
	}

	public void setClienteActivo(boolean clienteactivo) {
		this.clienteactivo = clienteactivo;
	}

	public String getClienteNombre() {
		return clientenombre;
	}

	public void setClienteNombre(String clientenombre) {
		this.clientenombre = clientenombre;
	}


	public Timestamp getClientefechacreacion() {
		return clientefechacreacion;
	}

	public void setClientefechacreacion(Timestamp clientefechacreacion) {
		this.clientefechacreacion = clientefechacreacion;
	}

	public Timestamp getClientefechamodificacion() {
		return clientefechamodificacion;
	}

	public void setClientefechamodificacion(Timestamp clientefechamodificacion) {
		this.clientefechamodificacion = clientefechamodificacion;
	}
}
