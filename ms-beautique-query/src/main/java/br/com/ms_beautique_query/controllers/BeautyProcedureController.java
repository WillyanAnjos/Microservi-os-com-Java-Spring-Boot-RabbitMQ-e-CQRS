package br.com.ms_beautique_query.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ms_beautique_query.dtos.beautyprocedures.BeautyProcedureDTO;
import br.com.ms_beautique_query.services.BeautyProcedureService;

@RestController
@RequestMapping("/beauty-procedure")
public class BeautyProcedureController {

    private final BeautyProcedureService beautyProcedureService;

    public BeautyProcedureController(BeautyProcedureService beautyProcedureService) {
        this.beautyProcedureService = beautyProcedureService;
    }

    @GetMapping
    ResponseEntity<List<BeautyProcedureDTO>> listAllBeautyProcedures() {
        return ResponseEntity.ok(beautyProcedureService.listAllBeautyProcedures());
    }

    @GetMapping("name/{name}")
    ResponseEntity<List<BeautyProcedureDTO>> listByNameLikeIgnoreCase(@PathVariable String name) {
        return ResponseEntity.ok(beautyProcedureService.listByNameIgnoreCase(name));
    }

    @GetMapping("description/{description}")
    ResponseEntity<List<BeautyProcedureDTO>> listByDescriptionLikeIgnoreCase(@PathVariable String description) {
        return ResponseEntity.ok(beautyProcedureService.listByDescriptionIgnoreCase(description));
    }

}
