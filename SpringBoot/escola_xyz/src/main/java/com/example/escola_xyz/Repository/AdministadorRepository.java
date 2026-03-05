package com.example.escola_xyz.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.escola_xyz.model.Administrador;

public interface AdministadorRepository extends CrudRepository<Administrador, String>{

    Administrador findByCpf(String cpf);

}
