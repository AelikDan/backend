package com.example.sistema_de_manutencao.service;
import com.example.sistema_de_manutencao.model.Funcionario;
import com.example.sistema_de_manutencao.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public boolean autenticar(String nif, String senha) {
        return repository.findByNif(nif)
            .map(f -> f.getSenha().equals(senha))
            .orElse(false);
    }

    public void cadastrar(String nome, String nif, String senha) {
        if (repository.findByNif(nif).isPresent()) {
            throw new RuntimeException("NIF já cadastrado.");
        }
        Funcionario f = new Funcionario();
        f.setNome(nome);
        f.setNif(nif);
        f.setSenha(senha);
        repository.save(f);
    }
}