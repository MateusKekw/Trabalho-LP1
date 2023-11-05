package model;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table
public class Materias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    @Column
    private String nome;
    @Column
    private List<String> professores;
    @OneToMany(mappedBy = "Materias", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tarefas> tarefasList;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<String> getProfessores() {
        return professores;
    }
    public void setProfessores(List<String> professores) {
        this.professores = professores;
    }
}
