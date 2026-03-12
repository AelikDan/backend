package com.example.sistema_de_manutencao.repository;
import com.example.sistema_de_manutencao.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	Optional<Funcionario> findByNif(String nif);
	boolean existsByNif(String nif);
}


