package com.example.sistema_de_manutencao.repository;
import com.example.sistema_de_manutencao.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    List<Categoria> findByNome(String nome);
    
    
}
