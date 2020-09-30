package com.kassioschaider.avaliacao.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ExercicioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveriaObterMaiorNumeroIrmao() throws Exception {
        URI uri = new URI("/exercicio/123456");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri))
                .andExpect(MockMvcResultMatchers.status().is(200)).andReturn();

        assertEquals("654321", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void deveriaObterOMesmoNumeroPassadoNaUri() throws Exception {
        URI uri = new URI("/exercicio/553");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri))
                .andExpect(MockMvcResultMatchers.status().is(200)).andReturn();

        assertEquals("553", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void deveriaObterObterMaiorNumeroIrmaoMesmoComOValorDesordenado() throws Exception {
        URI uri = new URI("/exercicio/23198165");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri))
                .andExpect(MockMvcResultMatchers.status().is(200)).andReturn();

        assertEquals("98653211", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void deveriaObterMenosUmPorNumeroGrande() throws Exception {
        URI uri = new URI("/exercicio/000000011");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri))
                .andExpect(MockMvcResultMatchers.status().is(200)).andReturn();

        assertEquals("-1", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void deveriaObterONumeroMaximoPermitido() throws Exception {
        URI uri = new URI("/exercicio/000000001");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri))
                .andExpect(MockMvcResultMatchers.status().is(200)).andReturn();

        assertEquals("100000000", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void deveriaObterMenosUmPorNumeroRealmenteGrande() throws Exception {
        URI uri = new URI("/exercicio/534543634634634547647687697670999999");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri))
                .andExpect(MockMvcResultMatchers.status().is(200)).andReturn();

        assertEquals("-1", mvcResult.getResponse().getContentAsString());
    }
}