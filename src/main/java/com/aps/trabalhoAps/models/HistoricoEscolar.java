package com.aps.trabalhoAps.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Historico_Escolar")
public class HistoricoEscolar {


    @Id
    private UUID idHistorico;

    public UUID getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(UUID idHistorico) {
        this.idHistorico = idHistorico;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idHistorico", referencedColumnName = "matricula")
    private Aluno aluno;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idHistorico", referencedColumnName = "idMateria")
    private Materia materia;
}
