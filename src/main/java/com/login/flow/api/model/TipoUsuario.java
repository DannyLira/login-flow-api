package com.login.flow.api.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class TipoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTipoUsuario;

    private String nomeTipoUsuario;

    public List<TipoUsuario> findAll() {
        return null;
    }

    public Optional<TipoUsuario> findById(long id) {
        return null;
    }

    public TipoUsuario save(TipoUsuario tipoUsuario) {
        return null;
    }

    public TipoUsuario upDate(long id, TipoUsuario tipoUsuario) {
        return null;
    }

    public static void delete(long id) {
    }

}