package com.Reto2_G7.controller;

import com.Reto2_G7.model.User;
import com.Reto2_G7.service.UserService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Diego
 * 
 * con el "/api/user" definimos el complemento de la BASE_URL para acceder a la coleccion users
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService servicio;
/**
 *
 * con "/all" realizamos una peticion tipo get para visualizar los datos contenido en la coleccion
 *
 */
    @GetMapping("/all")
    public List<User> listAll() {
        return servicio.listAll();
    }
/**
 *
 * con "/new" realizamos una peticion tipo post para agregar un nuevo registro en la coleccion
 *
 */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return servicio.create(user);
    }
/**
 *
 * con "/update" realizamos una peticion tipo put para acualizar los datos de un registro especifico en la coleccion
 *
 */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return servicio.update(user);
    }
/**
 *
 * con "/emailexist/{email}" realizamos una peticion tipo get para validar si ya existe algun registro en la coleccion con el Email que estamos digitando
 *
 */
    @GetMapping("/emailexist/{email}")
    public boolean emailExist(@PathVariable("email") String email) {
        return servicio.emailExist(email);
    }
 /**
 *
 * con "/{id}" realizamos una peticion tipo delete para eliminar un registro de la coleccion por su Id
 *
 */   
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return servicio.delete(id);
    }
    
  /**
 *
 * con "/{email}/{password}" realizamos una peticion tipo get para autenticar a un usuario verificando que ya se encuentre registrado con una combinacion de Email y Password especifico
 *
 */  

    @GetMapping("/{email}/{password}")
    public User autenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return servicio.autenticateUser(email, password);
    }
}
