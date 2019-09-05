package task.springjdbc.src.main.java.jdbc.example;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

@Named
@SessionScoped
public class JdbcBean implements Serializable {

  @Resource(lookup = "java:jboss/springjsbc")
  private DataSource dataSource;


  private JdbcTemplate jdbcTemplate;
 //если джелать пост констракт бин будет сразу конструирован
  @PostConstruct
  private void initialize() {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public void execute() {
    List<PersonValue> personValues = jdbcTemplate.query("select * from person", new PersonValueMapper());
    jdbcTemplate.update("update person set name='name2' WHERE id='1'");
  }

}
