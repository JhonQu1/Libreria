package com.proyecto.Libreria.Utils;

import com.proyecto.Libreria.Entity.*;
import com.proyecto.Libreria.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InsercionRegistros implements CommandLineRunner {

    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private EditorialRepository editorialRepository;
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PrestamoRepository prestamoRepository;


    //Importante: Realizar las inserciones a la base de datos en base a las relaciones de las entidades
    //EJEMPLO: no se puede insertar un usuario sin antes haber insertado un pais,
    // //ya que usuario necesita el id del pais para crearse
    @Override
    public void run(String... args) throws Exception {
        PaisEntity pais = new PaisEntity();
        PaisEntity pais2 = new PaisEntity();
        AutorEntity autor = new AutorEntity();
        EditorialEntity editorial = new EditorialEntity();
        RolEntity rol = new RolEntity();
        UsuarioEntity usuario = new UsuarioEntity();
        PrestamoEntity prestamo = new PrestamoEntity();

        pais.setId(1L);
        pais.setNombre("Colombia");
        paisRepository.save(pais);

        pais2.setId(2L);
        pais2.setNombre("perú");
        paisRepository.save(pais2);


        autor.setId(1L);
        autor.setNombreAutor("Gabriel");
        autor.setApellidoAutor("García Marquez");
        autor.setPaisId(pais);
        autor.setFechaNacimiento("1900");
        autorRepository.save(autor);

        editorial.setId(1L);
        editorial.setNombreEditorial("Planeta");
        editorialRepository.save(editorial);

        rol.setIdRol(1L);
        rol.setNombreRol("Usuario");
        rolRepository.save(rol);

        usuario.setId(1L);
        usuario.setNombre("Jhon");
        usuario.setAutenticado(true);
        usuario.setTelefono("114587");
        usuario.setRolId(rol);
        usuarioRepository.save(usuario);

        prestamo.setId(1L);
        prestamo.setFechaPrestamo("11-feb-2023");
        prestamo.setFechaEntrega("11-jul-2023");
        prestamo.setUsuarioId(usuario);
        prestamoRepository.save(prestamo);

    }

}
