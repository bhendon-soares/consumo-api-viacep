package com.bhendonsoares.consumoapiviacep.repository;

import com.bhendonsoares.consumoapiviacep.model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
