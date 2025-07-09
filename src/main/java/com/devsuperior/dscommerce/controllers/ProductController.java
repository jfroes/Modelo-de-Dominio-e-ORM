package com.devsuperior.dscommerce.controllers;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable Long id){
        ProductDTO dto = service.findByID(id);
        return dto;
    }

    @GetMapping
    public Page<ProductDTO> findAll(@PageableDefault(size = 12) Pageable pageable){
        return service.findAll(pageable);
    }

    @PostMapping
    public ProductDTO insert(@RequestBody ProductDTO dto) {
            return service.insert(dto);
    }

}
