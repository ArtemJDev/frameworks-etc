package main.orderapp.logic.src.main.java.ru.orderapp.auth.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Role {

  //прослойка которая содержит в себе набор прав
  //для того чтобы админ не назначал по одному
  @Id
  private String code;

  //Одной роли могут соответствовать много прав
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "roles")
  private List<Right> rights;

  //на одну и ту же роль могут ссылаться много person
  //одну и ту же роль можем назначить большому кол-ву пользователей
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "role")
  private List<PersonRole> personRoles;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public List<Right> getRights() {
    return rights;
  }

  public void setRights(List<Right> rights) {
    this.rights = rights;
  }
}
