package com.example.sistema_de_manutencao.repository;
import com.example.sistema_de_manutencao.model.Movimentacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface MovimentacoesRepository extends JpaRepository<Movimentacoes, Long>{
    List<Movimentacoes> findByData(String data);
}