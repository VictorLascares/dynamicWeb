package com.mx.DynamicWeb.services;

import java.util.List;

import com.mx.DynamicWeb.models.Cliente;

public interface ClienteService {
	public void guardar(Cliente cliente);

	public Cliente editar(int id, Cliente cliente);
	
	public Cliente buscar(int id);

	public List<Cliente> listar();
}
