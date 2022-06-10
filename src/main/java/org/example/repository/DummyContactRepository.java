package org.example.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.example.controller.Contanct;
import org.example.resources.resources.*;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

public class DummyContactRepository implements ContactsRepository {
    private static final String DATA_SOURCE = "dummy_data.json";

    private List<Contanct> contancts;

    public DummyContactRepository() {
        try {
            initData();
        } catch (IOException e) {
            throw new RuntimeException(DATA_SOURCE +
                    " is missing or is unreadable");
        }
    }

    private void initData() throws IOException {
        URL url = Resources.getResource(DATA_SOURCE);
        String json = Resources.toString(url, Charsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        CollectionType type = mapper.getTypeFactory()
                .constructCollectionType(List.class, Contanct.class);
        contancts = mapper.readValue(json, type);
    }

    @Override
    public List<Contanct> getAll(){
        return contancts;
    }
    @Override
    public Optional<Contanct> getById(Long id){
        return contancts.stream().filter(e -> e.getId() == id).findFirst();
    }
    @Override
    public Contanct save(Contanct contanct){
        Optional<Long> maxId = contancts.stream()
                .map(Contanct::getId)
                .max(Long::compare);
        long nextId = maxId.map(x -> x + 1).orElse(1L);
        contanct.setId(nextId);
        contancts.add(contanct);
        return contanct;
    }
    @Override
    public Optional<Contanct> update(Long id, Contanct contanct) {
        Optional<Contanct> existingContact = getById(id);
        existingContact.ifPresent(e -> e.updateExceptId(contanct));
        return existingContact;
    }

    @Override
    public void delete(Long id) {
        contancts.removeIf(e -> e.getId() == id);
    }

}
