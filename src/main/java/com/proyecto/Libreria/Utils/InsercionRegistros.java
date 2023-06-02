/*package com.proyecto.Libreria.Utils;

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
    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private GeneroRepository generoRepository;


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
        LibroEntity libro = new LibroEntity();
        LibroEntity libro2 = new LibroEntity();
        EstadoEntity estado = new EstadoEntity();
        GeneroEntity genero = new GeneroEntity();

        //pais.setId(1L);
        pais.setNombre("Colombia");
        pais.setAutorId(autor);
        paisRepository.save(pais);

        //pais2.setId(2L);
        pais2.setNombre("perú");
        pais2.setAutorId(autor);
        paisRepository.save(pais2);

        //rol.setIdRol(1L);
        rol.setNombreRol("Usuario");
        rol.setListaUsuarios(usuario);
        rolRepository.save(rol);

        //usuario.setId(1L);
        usuario.setNombre("Jhon");
        usuario.setAutenticado(true);
        usuario.setTelefono("114587");
        usuario.setRolId(rol);
        usuario.setListaPrestamos(prestamo);
        usuarioRepository.save(usuario);

        //autor.setId(1L);
        autor.setNombreAutor("Gabriel");
        autor.setApellidoAutor("García Marquez");
        autor.setPaisId(pais);
        autor.setFechaNacimiento("1900");
        //autor.setLibros(libro);
        autorRepository.save(autor);

        //editorial.setId(1L);
        editorial.setNombreEditorial("Planeta");
        editorial.setLibros(libro);
        editorialRepository.save(editorial);


        //prestamo.setId(1L);
        prestamo.setFechaPrestamo("11-feb-2023");
        prestamo.setFechaEntrega("11-jul-2023");
        prestamo.setUsuarioId(usuario);
        prestamo.setListaEstados(estado);
        prestamo.setListaLibros(libro);
        prestamoRepository.save(prestamo);

        //libro.setId(1L);
        libro.setAutorId(autor);
        libro.setTitulo("Cien Años de soledad");
        libro.setEditorialId(editorial);
        libro.setGenero(genero);
        libro.setPrestamoId(prestamo);
        libro.setFechaPublicacion("20 mayo de 1920");
        libroRepository.save(libro);

        //libro2.setId(2L);
        //libro2.setAutorId(autor);
        //libro2.setTitulo("pepa pig");
        //libro2.setEditorialId(editorial);
        //libro2.setPrestamoId(prestamo);
        //libro2.setFechaPublicacion("13 febrero de 2000");
        //libroRepository.save(libro2);

        estado.setEstado("En Consulta");
        estado.setPrestamoId(prestamo);
        //estado.setId(1L);
        estadoRepository.save(estado);

        genero.setNombreGenero("Comedia");
        //genero.setId(1L);
        genero.setLibroId(libro);
        generoRepository.save(genero);


    }

}
*/