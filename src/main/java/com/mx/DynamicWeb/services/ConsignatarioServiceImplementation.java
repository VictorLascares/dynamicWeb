package com.mx.DynamicWeb.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.DynamicWeb.dao.ClienteDao;
import com.mx.DynamicWeb.dao.ConsignatarioDao;
import com.mx.DynamicWeb.models.Consignatario;

@Service
public class ConsignatarioServiceImplementation implements ConsignatarioService {
	@Autowired
	ConsignatarioDao consignatarioDao;
	@Autowired
	ClienteDao clienteDao;

	@Transactional
	@Override
	public void guardar(Consignatario consignatario) {
		Consignatario newConsignatario = new Consignatario();
		newConsignatario.setCliente(clienteDao.findById(consignatario.getCliente().getClienteId())
				.orElseThrow(IllegalArgumentException::new));
		newConsignatario.setConsignatarioactivo(consignatario.getConsignatarioActivo());
		newConsignatario.setConsignatarioNombre(consignatario.getConsignatarionombre());
		newConsignatario.setConsignatariofechacreacion(consignatario.getConsignatariofechacreacion());
		newConsignatario.setConsignatariofechamodificacion(consignatario.getConsignatariofechamodificacion());
		newConsignatario.setConsignatarioid(consignatario.getConsignatarioid());
		consignatarioDao.save(newConsignatario);
	}

	@Transactional
	@Override
	public void editar(int id, Consignatario consignatario) {
		Consignatario updateConsignatario = buscar(id);
		updateConsignatario.setConsignatarioactivo(consignatario.getConsignatarioActivo());
		updateConsignatario.setConsignatarioNombre(consignatario.getConsignatarionombre());
		updateConsignatario.setConsignatariofechamodificacion(Timestamp.valueOf(LocalDateTime.now()));
		consignatarioDao.save(updateConsignatario);
	}

	@Transactional(readOnly = true)
	@Override
	public Consignatario buscar(int id) {
		return consignatarioDao.findById(id).orElseThrow(null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Consignatario> listar() {
		return consignatarioDao.findAll();
	}

}
