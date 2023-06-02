package com.proyecto.Libreria.Controllers;

import com.proyecto.Libreria.Entity.LibroEntity;
import com.proyecto.Libreria.Services.LibrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class LibroController {

    @Autowired
    private LibrosService librosService;

    @GetMapping(value = "getall")
    public ResponseEntity<List<LibroEntity>> consultaLibrosGeneral() {

        List<LibroEntity> listaLibros = librosService.consultaTodos();
        return new ResponseEntity<>(listaLibros, HttpStatus.OK);
    }

    @GetMapping(value = "getid/{id}")
    public ResponseEntity<Optional<LibroEntity>>consultaLibroPorId(@PathVariable Long id){
        Optional<LibroEntity> listaLibros = librosService.consultaPorId(id);
        return new ResponseEntity<>(listaLibros,HttpStatus.OK);
    }

    @PostMapping(value = "postbook")
    public ResponseEntity<String> insertarLibro(@RequestBody LibroEntity libro){
        LibroEntity libroInsertado = librosService.insertarLibro(libro);
        if(libroInsertado !=null){
            return new ResponseEntity<>("Libro insertado Correctamente",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Error al insertar el Libro",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/deletebook/{id}")
    public ResponseEntity<String> eliminarLibroPorId(@PathVariable("id") Long id) {
        Optional<LibroEntity> libroOptional = librosService.consultaPorId(id);

        if (libroOptional.isPresent()) {
            librosService.EliminarLibro(id);
            return new ResponseEntity<>("Libro eliminado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("El libro no existe", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/updatebook/{id}")
    public ResponseEntity<String> modificarLibro(@PathVariable("id") Long id, @RequestBody LibroEntity libro) {
        Optional<LibroEntity> libroOptional = librosService.consultaPorId(id);

        if (libroOptional.isPresent()) {
            LibroEntity libroExistente = libroOptional.get();
            libroExistente.setTitulo(libro.getTitulo());
            libroExistente.setFechaPublicacion(libro.getFechaPublicacion());
            //libroExistente.setEditorialId(libro.getEditorialId());
            libroExistente.setAutorId(libro.getAutorId());
            //libroExistente.setPrestamoId(libro.getPrestamoId());

            LibroEntity libroActualizado = librosService.ModificarLibro(libroExistente);
            return new ResponseEntity<>("Libro actualizado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("El libro no existe", HttpStatus.NOT_FOUND);
        }
    }



}
