package br.com.beautique.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.beautique.dtos.BeautyProcedureDTO;
import br.com.beautique.services.BeautyProcedureService;

@RestController
@RequestMapping("beauty-procedure")
public class BeautyProcedureController {

    @Autowired
    private BeautyProcedureService beautyProcedureService;

    @PostMapping
    ResponseEntity<BeautyProcedureDTO> createBeautyProcedure(@RequestBody BeautyProcedureDTO beautyProcedureDTO) {
        return ResponseEntity.ok(beautyProcedureService.create(beautyProcedureDTO));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id) {
        beautyProcedureService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping
    ResponseEntity<BeautyProcedureDTO> update(@RequestBody BeautyProcedureDTO beautyProcedureDTO) {
        return ResponseEntity.ok(beautyProcedureService.update(beautyProcedureDTO));
    }
}
