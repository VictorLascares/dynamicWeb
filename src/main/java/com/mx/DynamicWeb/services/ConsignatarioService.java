package com.mx.DynamicWeb.services;

import java.util.List;

import com.mx.DynamicWeb.models.Consignatario;

public interface ConsignatarioService {
	public void guardar(Consignatario consignatario);

	public void editar(int id, Consignatario consignatario);
	
	public Consignatario buscar(int id);

	public List<Consignatario> listar();
}
