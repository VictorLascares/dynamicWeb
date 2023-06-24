package com.mx.DynamicWeb.controllers;

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

import com.mx.DynamicWeb.models.Consignatario;
import com.mx.DynamicWeb.services.ConsignatarioServiceImplementation;

@RestController
@RequestMapping("ConsignatarioWebService")
@CrossOrigin
public class ConsignatarioWebService {
	@Autowired
	ConsignatarioServiceImplementation consignatarioServImp;

	@GetMapping("listar")
	public List<Consignatario> listar() {
		return consignatarioServImp.listar();
	}
	
	@GetMapping("buscar/{id}")
	public Consignatario buscar(@PathVariable int id) {
		return consignatarioServImp.buscar(id);
	}

	@PostMapping("guardar")
	public void guardar(@RequestBody Consignatario consignatario) {
		consignatarioServImp.guardar(consignatario);
	}

	@PutMapping("editar/{id}")
	public void editar(@PathVariable int id, @RequestBody Consignatario consignatario) {
		consignatarioServImp.editar(id, consignatario);
	}
}
