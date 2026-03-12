package com.example.sistema_de_manutencao.repository;
import com.example.sistema_de_manutencao.model.Materiais;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface MateriaisRepository extends JpaRepository<Materiais, Long> {
    List<Materiais> findByNome(String nome);
}