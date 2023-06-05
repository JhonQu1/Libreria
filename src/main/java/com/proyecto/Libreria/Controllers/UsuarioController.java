package com.proyecto.Libreria.Controllers;

import com.proyecto.Libreria.Entity.UsuarioEntity;
import com.proyecto.Libreria.Services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    private UsuariosService usuariosService;


    @GetMapping(value = "getall")
    public ResponseEntity<List<UsuarioEntity>> consultaUsuariosGeneral() {

        List<UsuarioEntity> listaUsuarios = usuariosService.consultaTodos();
        return new ResponseEntity<>(listaUsuarios, HttpStatus.OK);
    }


    @GetMapping(value = "getid/{id}")
    public ResponseEntity<Optional<UsuarioEntity>>consultaUsuarioPorId(@PathVariable Long id){
        Optional<UsuarioEntity> listaUsuarios = usuariosService.consultaPorId(id);
        return new ResponseEntity<>(listaUsuarios,HttpStatus.OK);
    }


    @PostMapping(value = "postuser")
    public ResponseEntity<String> insertarUsuario(@RequestBody UsuarioEntity usuario){
        UsuarioEntity usuarioInsertado = usuariosService.insertarUsuario(usuario);
        if(usuarioInsertado !=null){
            return new ResponseEntity<>("Usuario insertado Correctamente",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Error al insertar el Usuario",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping(value = "/deleteuser/{id}")
    public ResponseEntity<String> eliminarUsuarioPorId(@PathVariable("id") Long id) {
        Optional<UsuarioEntity> UsuarioOptional = usuariosService.consultaPorId(id);

        if (UsuarioOptional.isPresent()) {
            usuariosService.EliminarUsuario(id);
            return new ResponseEntity<>("Usuario eliminado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("El Usuario no existe", HttpStatus.NOT_FOUND);
        }
    }



    @PostMapping(value = "/updateuser/{id}")
    public ResponseEntity<String> modificarUsuario(@PathVariable("id") Long id, @RequestBody UsuarioEntity usuario) {

        Optional<UsuarioEntity> UsuarioOptional = usuariosService.consultaPorId(id);

        if (UsuarioOptional.isPresent()) {

            UsuarioEntity usuarioExistente = UsuarioOptional.get();

            //usuarioExistente.setId(usuario.getId());
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setApellido(usuario.getApellido());
            usuarioExistente.setTelefono(usuario.getTelefono());
            usuarioExistente.setRolId(usuario.getRolId());
            usuarioExistente.setPrestamos(usuario.getPrestamos());

            UsuarioEntity usuarioActualizado = usuariosService.ModificarUsuario(usuarioExistente);

            return new ResponseEntity<>("Usuario actualizado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("El Usuario No existe", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<UsuarioEntity> consultarPorNombre(@PathVariable String nombre) {
        Optional<UsuarioEntity> usuario = usuariosService.consultaPornombre(nombre);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
