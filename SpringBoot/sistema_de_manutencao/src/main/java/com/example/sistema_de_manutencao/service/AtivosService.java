package com.example.sistema_de_manutencao.service;
import com.example.sistema_de_manutencao.model.Ativos;
import com.example.sistema_de_manutencao.repository.AtivosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AtivosService {

    @Autowired
    private AtivosRepository repository;

    public List<Ativos> listar() {
        return repository.findAll();
    }

    public void salvar(Ativos ativo) {
        repository.save(ativo);
    }

    public Ativos buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Ativo não encontrado."));
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}