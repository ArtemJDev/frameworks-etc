package practise_springboot_store.src.main.java.ru.javagain.springstore.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

// common behavioral for all objects
public interface GeneralDAO<T>{

    // getting all records without pagination
    List<T> getAll();

    // find records by params
    List<T> search(String... searchString);

    // getting object by id
    T get(long id);

    // save - update or save objects
    T save(T obj);

    // delete objects
    void delete(T object);

    // getting all records with sorting
    List<T> getAll(Sort sort);

    // getting all records with pagination
    Page<T> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection);

    // find records with paginations
    Page<T> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection,
        String... searchString);


}
