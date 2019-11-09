package main.orderapp.logic.src.main.java.ru.orderapp.auth.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class PersonEntity {
//идентификатор, каким способом мы можем идентифицировать персону
  @Id
  private String login;
  private String password;
  private String name;


  //Одной персоне много ролей
  @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE,mappedBy = "personEntity")
  private List<PersonRole> personRoles;



  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<PersonRole> getPersonRoles() {
    return personRoles;
  }

  public void setPersonRoles(List<PersonRole> personRoles) {
    this.personRoles = personRoles;
  }
}
