package com.example.sistema_de_manutencao.service;
import com.example.sistema_de_manutencao.model.Movimentacoes;
import com.example.sistema_de_manutencao.repository.MovimentacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacoesRepository repository;

    public List<Movimentacoes> listar() {
        return repository.findAll();
    }

    public void salvar(Movimentacoes movimentacao) {
        repository.save(movimentacao);
    }

    public Movimentacoes buscarPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Movimentação não encontrada."));
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}