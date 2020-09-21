package com.kassioschaider.avaliacao.repository;

import com.kassioschaider.avaliacao.model.Patrimonio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatrimonioRepository extends JpaRepository<Patrimonio, Long> {

}
