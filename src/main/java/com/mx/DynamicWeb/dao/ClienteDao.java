package com.mx.DynamicWeb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.DynamicWeb.models.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Integer> {

}
