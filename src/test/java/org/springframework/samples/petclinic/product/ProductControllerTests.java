/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic.product;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;



@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTests {

    private static final int TEST_PRODUCT_ID = 1;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductRepository products;

    private Product golden;

    @Before
    public void setup() {
        golden = new Product();
        golden.setId(TEST_PRODUCT_ID);
        golden.setName("Golden gato adulto salmao");
        golden.setDescription("Formulada com ingredientes de alta qualidade e balanceada para suprir às particularidades nutricionais dos felinos, Golden Gatos Adultos Salmão oferece sabor irresistível  e cuidados especiais com o trato urinário, garantindo assim, sabor e saúde para seu gato.");
        
        //given(this.products.findById(TEST_PRODUCT_ID)).willReturn(golden);
    }

    @Test
    public void testProcessFindFormByLastName() throws Exception {
        given(this.products.findAll()).willReturn(Lists.newArrayList(golden));
        mockMvc.perform(get("/products"))
            .andExpect(status().isOk())
            .andExpect(model().attributeExists("products"));
    }

}
