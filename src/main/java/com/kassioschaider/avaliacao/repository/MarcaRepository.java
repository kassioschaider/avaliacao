package com.kassioschaider.avaliacao.repository;

import com.kassioschaider.avaliacao.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {}
