package com.example.sistema_de_manutencao.service;
import com.example.sistema_de_manutencao.model.Materiais;
import com.example.sistema_de_manutencao.repository.MateriaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class MateriaisService {

    @Autowired
    private MateriaisRepository repository;

    public List<Materiais> listar() {
        return repository.findAll();
    }

    public void salvar(Materiais material) {
        repository.save(material);
    }

    public Materiais buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Material não encontrado."));
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}