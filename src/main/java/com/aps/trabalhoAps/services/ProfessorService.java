package com.aps.trabalhoAps.services;

import com.aps.trabalhoAps.models.Aluno;
import com.aps.trabalhoAps.models.Professor;
import com.aps.trabalhoAps.repositories.ProfessorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProfessorService {

    final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Transactional
    public Professor save(Professor professor){
        return professorRepository.save(professor);
    }

    public Page<Professor> recuperarTodos(Pageable pageable) {
        return professorRepository.findAll(pageable);
    }
}
