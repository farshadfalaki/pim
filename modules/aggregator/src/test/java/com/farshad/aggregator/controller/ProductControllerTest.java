package com.farshad.aggregator.controller;

import com.farshad.aggregator.dto.ProductDto;
import com.farshad.aggregator.model.Product;
import com.farshad.aggregator.service.ProductService;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.CoreMatchers.is;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ProductController.class)
public class ProductControllerTest {
    @MockBean
    ProductService productService;
    @Autowired
    private MockMvc mockMvc;
    private Gson gson;
    @Before
    public void init(){
        gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }
    @Test
    public void listAllProducts_noProduct_shouldReturnEmptyList() throws Exception {
        //given
        when(productService.listProducts()).thenReturn(null);
        //when then
        mockMvc.perform(get("/product/all").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)))
        ;
    }
    @Test
    public void listAllProducts_oneProduct_shouldListWithOneProductDto() throws Exception {
        //given
        List<ProductDto> expectedProductDtoList = new ArrayList<>();
        Product product = new Product("e1956da7-99a8-4e1a-9b15-01e337e2e7e3","OnePlus Mobile","smart phone","OnePlus",true,"PC");
        when(productService.listProducts()).thenReturn(Arrays.asList(product));
        //when then
        mockMvc.perform(get("/product/all").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].uuid",is(product.getUuid())))
                .andExpect(jsonPath("$[0].name",is(product.getName())))
                .andExpect(jsonPath("$[0].description",is(product.getDescription())))
                .andExpect(jsonPath("$[0].provider",is(product.getProvider())))
                .andExpect(jsonPath("$[0].measurement_units",is(product.getMeasurementUnits())))
        ;
    }
}