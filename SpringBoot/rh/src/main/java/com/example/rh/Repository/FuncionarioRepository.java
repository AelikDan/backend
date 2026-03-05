package com.example.rh.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.rh.Model.Funcionario;
import java.util.List;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long>{
    //Metodos para realizar o crud do funcionario

    //Criar uma busca pela chave primária do funcionario
    Funcionario findById (long id);
    
    //Busca pelo nome
    Funcionario findByNome (String nome);

    //Busca para varios nomes //Não existe no JPA
    @Query(value = "select u from Funcionario u where u.nome like %?1%")
    List<Funcionario> findByNomes(String nome); 

}
