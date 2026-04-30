/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.devops.proyecto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author Junal
 */
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    // Test 1: Smoke test — el endpoint existe y responde
    @Test
    void getProducts_returns200() throws Exception {
        mockMvc.perform(get("/productos"))
                .andExpect(status().isOk());
    }

    // Test 2: El guardián — protege la regla de negocio
    // ⭐ ESTE es el que vamos a romper en la etapa OPERATE
    @Test
    void createProduct_returns201() throws Exception {
        String json = """
                {
                  "name": "Television",
                  "price": 999.99
                }
                """;
        mockMvc.perform(post("/productos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());
    }

    // Test 3: Error handling — recurso inexistente → 404
    @Test
    void getProduct_notFound_returns404() throws Exception {
        mockMvc.perform(get("/productos/999"))
                .andExpect(status().isNotFound());
    }
}