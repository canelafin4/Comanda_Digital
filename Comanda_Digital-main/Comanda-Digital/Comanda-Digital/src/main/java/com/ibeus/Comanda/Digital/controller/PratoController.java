package com.ibeus.Comanda.Digital.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibeus.Comanda.Digital.model.Prato;
import com.ibeus.Comanda.Digital.service.PratoService;

@RestController
@RequestMapping("/pratos")
@CrossOrigin(origins = "http://localhost:4200")
public class PratoController {


    @Autowired
    private PratoService pratoService;

    @GetMapping
    public List<Prato> listarTodos() {
        return pratoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Prato> buscarPorId(@PathVariable Long id) {
        return pratoService.buscarPorId(id);
    }

    @PostMapping
    public Prato salvar(@RequestBody Prato prato) {
        return pratoService.salvar(prato);
    }

    @DeleteMapping("/{id}")
    public String deletarPorId(@PathVariable Long id) {
        pratoService.deletarPorId(id);
        return "Prato deletado com sucesso.";
    }
}
