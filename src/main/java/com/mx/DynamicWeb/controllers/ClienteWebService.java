package com.mx.DynamicWeb.controllers;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.DynamicWeb.dao.ClienteDao;
import com.mx.DynamicWeb.models.Cliente;
import com.mx.DynamicWeb.services.ClienteServiceImplementation;

@RestController
@RequestMapping("ClienteWebService")
@CrossOrigin
public class ClienteWebService {
	@Autowired
	ClienteServiceImplementation clienteServImp;
	@Autowired
	ClienteDao clienteDao;

	@GetMapping("listar")
	public List<Cliente> listar() {
		return clienteServImp.listar();
	}

	@PostMapping("guardar")
	public void guardar(@RequestBody Cliente cliente) {
		clienteServImp.guardar(cliente);
	}

	@PutMapping("editar/{id}")
	public void editar(@PathVariable int id, @RequestBody Cliente detallesCliente) {
		Cliente updateCliente = clienteServImp.editar(id, detallesCliente);
		updateCliente.setClienteActivo(detallesCliente.getClienteActivo());
		updateCliente.setClienteNombre(detallesCliente.getClienteNombre());
		updateCliente.setClientefechamodificacion(Timestamp.valueOf(LocalDateTime.now()));
		clienteDao.save(updateCliente);
	}
	
	@GetMapping("buscar/{id}")
	public Cliente buscar(@PathVariable int id) {
		return clienteServImp.buscar(id);
	}
	

}
