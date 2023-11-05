package model;

import java.util.Date;
import jakarta.persistence.*;


@Entity
@Table
public class Tarefas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    @Column
    private String Nome;
    @Column
    private String disciplina;
    @Column
    private Date data_limite;
    @Column
    private String descricao;
    @Column
    private Double valor;
    @Column
    private boolean concluida;


    public String getNome() {
        return Nome;
    }
    public void setNome(String nome) {
        Nome = nome;
    }
    public String getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    public Date getData_limite() {
        return data_limite;
    }
    public void setData_limite(Date data_limite) {
        this.data_limite = data_limite;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public boolean isConcluida() {
        return concluida;
    }
    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }


}
