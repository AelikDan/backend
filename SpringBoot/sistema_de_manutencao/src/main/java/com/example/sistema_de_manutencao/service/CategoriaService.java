package com.example.sistema_de_manutencao.service;
import com.example.sistema_de_manutencao.model.Categoria;
import com.example.sistema_de_manutencao.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> listar() {
        return repository.findAll();
    }

    public void salvar(Categoria categoria) {
        repository.save(categoria);
    }

    public Categoria buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada."));
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}