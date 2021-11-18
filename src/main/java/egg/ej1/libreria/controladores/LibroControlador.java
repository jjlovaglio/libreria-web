/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.ej1.libreria.controladores;

import egg.ej1.libreria.entidades.Autor;
import egg.ej1.libreria.entidades.Editorial;
import egg.ej1.libreria.repositorios.AutorRepositorio;
import egg.ej1.libreria.repositorios.EditorialRepositorio;
import egg.ej1.libreria.servicios.LibroServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author josejlovaglio
 *
 * Esta clase tiene la responsabilidad de llevar adelante las funcionalidades
 * necesarias para operar con la vista del usuario diseñada para la gestión de
 * libros (guardar/modificar libro, listar libros, dar de baja).
 *
 *
 */
@Controller
@RequestMapping("/libros")
public class LibroControlador {

    @Autowired
    private LibroServicio libroServicio;
    
    @Autowired
    private AutorRepositorio autorRepositorio;
    
    @Autowired
    private EditorialRepositorio editorialRepositorio;
    
    @GetMapping("/")
    public String listarLibros(
        ModelMap model) {
        
        List<Autor> autores = autorRepositorio.findAll();
        model.put("autores", autores);
        
        List<Editorial> editoriales = editorialRepositorio.findAll();
        model.put("editoriales", editoriales);
        
        return "libro.html";
    }

    @PostMapping("/")
    public String cargarLibro(
            @RequestParam String isbn,
            @RequestParam String titulo,
            @RequestParam String anio,
            @RequestParam String ejemplares,
            @RequestParam String idAutor,
            @RequestParam String idEditorial,
            ModelMap model) {
        
        
        libroServicio.cargar(
                isbn,
                titulo,
                anio,
                ejemplares,
                idAutor,
                idEditorial);
        
        

        return "libro.html";
    }
    
}
