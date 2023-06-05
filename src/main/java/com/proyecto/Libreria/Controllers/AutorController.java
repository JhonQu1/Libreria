package com.proyecto.Libreria.Controllers;

import com.proyecto.Libreria.Entity.AutorEntity;
import com.proyecto.Libreria.Services.AutoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AutorController {

    @Autowired
    private AutoresService autoresService;

    @GetMapping(value = "getall")
    public ResponseEntity<List<AutorEntity>> consultaAutoresGeneral() {

        List<AutorEntity> listaAutores = autoresService.consultaTodos();
        return new ResponseEntity<>(listaAutores, HttpStatus.OK);
    }

    @GetMapping(value = "getid/{id}")
    public ResponseEntity<Optional<AutorEntity>>consultaAutorPorId(@PathVariable Long id){
        Optional<AutorEntity> listaAutores = autoresService.consultaPorId(id);
        return new ResponseEntity<>(listaAutores,HttpStatus.OK);
    }

    @PostMapping(value = "postauthor")
    public ResponseEntity<String> insertarAutor(@RequestBody AutorEntity autor){
        AutorEntity autorInsertado = autoresService.insertarAutor(autor);
        if(autorInsertado !=null){
            return new ResponseEntity<>("Autor insertado Correctamente",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Error al insertar el Autor",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/deleteauthor/{id}")
    public ResponseEntity<String> eliminarAutorPorId(@PathVariable("id") Long id) {
        Optional<AutorEntity> AutorOptional = autoresService.consultaPorId(id);

        if (AutorOptional.isPresent()) {
            autoresService.EliminarAutor(id);
            return new ResponseEntity<>("Autor eliminado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("El Autor No existe", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/updateauthor/{id}")
    public ResponseEntity<String> modificarAutor(@PathVariable("id") Long id, @RequestBody AutorEntity autor) {
        Optional<AutorEntity> AutorOptional = autoresService.consultaPorId(id);

        if (AutorOptional.isPresent()) {
            AutorEntity AutorExistente = AutorOptional.get();
            //AutorExistente.setId(autor.getId());
            AutorExistente.setNombreAutor(autor.getNombreAutor());
            AutorExistente.setApellidoAutor(autor.getApellidoAutor());
            AutorExistente.setFechaNacimiento(autor.getFechaNacimiento());
            //AutorExistente.setPaisId(autor.getPaisId());
            //AutorExistente.setLibros(autor.getLibros());

            AutorEntity AutorActualizado = autoresService.ModificarAutor(AutorExistente);

            return new ResponseEntity<>("Autor actualizado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("El Autor no existe", HttpStatus.NOT_FOUND);
        }
    }

}
