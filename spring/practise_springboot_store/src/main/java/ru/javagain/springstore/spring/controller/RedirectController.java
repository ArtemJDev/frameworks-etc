package practise_springboot_store.src.main.java.ru.javagain.springstore.spring.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import practise_springboot_store.src.main.java.ru.javagain.springstore.domain.Author;
import ru.javabegin.training.library.dao.impl.AuthorService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
@Log
public class RedirectController {

    @Autowired
    private AuthorService authorService;


    // when starting a project - the first request gets here
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String baseUrlRedirect(HttpServletRequest request, HttpServletResponse httpServletResponse) {

        Page<Author> authors = authorService.getAll(0, 10, "fio", Sort.Direction.DESC);

        Author a = new Author();
        a.setFio("тестовый автор");
        a.setBirthday(new Date(1454284800000L));


        Author newAuthor = authorService.save(a);

        return "ok";
    }


}
