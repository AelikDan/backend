package com.example.sistema_de_manutencao.model;
import jakarta.persistence.*;

@Entity
@Table(name = "materiais")
public class Materiais {
    @Id
    @GeneratedValue
    (strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column
    (nullable = false)
    private String nome;

    @Column
    (nullable = false)
    private String tipo;

    @Column
    (nullable = false)
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
