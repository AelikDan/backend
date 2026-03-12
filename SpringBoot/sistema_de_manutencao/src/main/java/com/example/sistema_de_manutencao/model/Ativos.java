package com.example.sistema_de_manutencao.model;
import jakarta.persistence.*;
@Entity
@Table(name = "ativos")
public class Ativos {
    
    @Id
    @GeneratedValue
    (strategy = GenerationType.IDENTITY)
	private Long id;

    @Column
    (nullable = false)
	private String nome;

    @Column
    (nullable = false)
	private String descricao;

    @Column
    (nullable = false)
	private String numeroPatrimonio;

    @Column
    (nullable = false)
	private String localizacao;

    @Column
    (nullable = false)
	private String Responsavel;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNumeroPatrimonio() {
        return numeroPatrimonio;
    }

    public void setNumeroPatrimonio(String numeroPatrimonio) {
        this.numeroPatrimonio = numeroPatrimonio;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getResponsavel() {
        return Responsavel;
    }

    public void setResponsavel(String responsavel) {
        Responsavel = responsavel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

}
