package org.example.repository;


import org.example.controller.Contanct;

import java.util.List;
import java.util.Optional;

public interface ContactsRepository {
    List<Contanct> getAll();

    Optional<Contanct> getById(Long id);

    Contanct save(Contanct contanct);

    Optional<Contanct> update(Long id, Contanct contanct);

    void delete(Long id);

}
