package com.lojainstrumentos.lojainstrumentos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/instrumentos")
public class LojaController {

    private List<Instrumento> lista = new ArrayList<>();


    @GetMapping
    public ResponseEntity listarInstrumentos(){
        if (lista.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.ok(lista);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity verificarInstrumento(@PathVariable int id){
//        Double total = 0.0;
//        for (Instrumento i: lista){
//           total =  i.lucroInstrumento();
//        }
        if (lista.size() >= id){
            return ResponseEntity.ok(lista.get(id-1).toString());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/bateria")
    public ResponseEntity criarInstrumento(@RequestBody Bateria bateria ){
        lista.add(bateria);
        return ResponseEntity.created(null).build();
    }

    @PostMapping("/guitarra")
    public ResponseEntity criarInstrumento(@RequestBody Guitarra guitarra ){
        lista.add(guitarra);
        return ResponseEntity.created(null).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluirInstrumento(@PathVariable int id){
        if (lista.size() >= id){
            lista.remove(id-1);
            return ResponseEntity.ok().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/populares/{valor}")
    public ResponseEntity instrumentosPopulares(@PathVariable Double valor){
        List<Instrumento> instrumentosPopulares = lista.stream().
                filter(instrumento -> instrumento.getPreco() <= valor).collect(Collectors.toList());
        if (instrumentosPopulares.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.ok(instrumentosPopulares);
        }


    }



}
