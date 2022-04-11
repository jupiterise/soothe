package br.com.hominid.soothe.service.crud;

import java.util.List;
import java.util.UUID;

public interface CrudService<T> {

    T getById(UUID id);

    List<T> getAll();

    T create(T t);

    T update(T t);

    void delete(UUID id);

}
