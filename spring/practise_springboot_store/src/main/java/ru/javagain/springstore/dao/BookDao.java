package practise_springboot_store.src.main.java.ru.javagain.springstore.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface BookDao extends GeneralDAO<Book>{

    // find topof book
    List<Book> findTopBooks(int limit);

    // getting content by id
    byte[] getContent(long id);

    // page output of books of a certain genre
    Page<Book> findByGenre(int pageNumber, int pageSize, String sortField,
        Sort.Direction sortDirection, long genreId);

}