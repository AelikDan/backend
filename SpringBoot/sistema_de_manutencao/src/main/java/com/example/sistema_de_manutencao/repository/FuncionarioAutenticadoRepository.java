package com.example.sistema_de_manutencao.repository;
import java.util.Optional;
import com.example.sistema_de_manutencao.model.FuncionarioAutenticado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioAutenticadoRepository extends JpaRepository<FuncionarioAutenticado, Long> {
	Optional<FuncionarioAutenticado> findByNifAndAtivoTrue(String nif);
	boolean existsByNifAndNomeAndAtivoTrue(String nif, String nome);
}

