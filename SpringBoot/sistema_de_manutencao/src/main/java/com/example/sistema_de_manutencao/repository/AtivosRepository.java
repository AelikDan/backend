package com.example.sistema_de_manutencao.repository;
import com.example.sistema_de_manutencao.model.Ativos;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface AtivosRepository extends JpaRepository<Ativos, Long>{
    List<Ativos> findByNome(String nome);
}