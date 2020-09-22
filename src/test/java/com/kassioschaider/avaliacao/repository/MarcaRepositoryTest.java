package com.kassioschaider.avaliacao.repository;

import com.kassioschaider.avaliacao.model.Marca;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class MarcaRepositoryTest {

    @Autowired
    private MarcaRepository marcaRepository;

    @Before
    public void init() {
        Marca marca = new Marca(1L, "Marca Test");
        marcaRepository.save(marca);
    }

    @Test
    public void carregarTodasAsMarcas() {
        Assert.assertEquals(1, marcaRepository.findAll().size());
    }

    @Test
    public void carregarTodasAsMarcas2() {
        Assert.assertEquals(1, marcaRepository.findAll().size());
    }

    @Test
    public void salvarMarcaComMesmoNome() {
        Marca marca2 = new Marca(2L, "Marca Test");
    }
}