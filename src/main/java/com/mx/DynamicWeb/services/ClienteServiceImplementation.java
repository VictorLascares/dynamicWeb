package com.mx.DynamicWeb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.DynamicWeb.dao.ClienteDao;
import com.mx.DynamicWeb.models.Cliente;

@Service
public class ClienteServiceImplementation implements ClienteService {
	@Autowired
	ClienteDao clienteDao;

	@Transactional
	@Override
	public void guardar(Cliente cliente) {
		clienteDao.save(cliente);
	}

	@Transactional
	@Override
	public Cliente editar(int id, Cliente cliente) {
		return clienteDao.findById(id).orElseThrow(IllegalArgumentException::new);
	}
	
	@Transactional(readOnly = true) 
	@Override
	public Cliente buscar(int id) {
		return clienteDao.findById(id).orElseThrow(IllegalArgumentException::new);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Cliente> listar() {
		return clienteDao.findAll();
	}

}
