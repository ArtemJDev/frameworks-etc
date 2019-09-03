package main.orderapp.logic.src.main.java.ru.orderapp.auth.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "resource")

public class ResourceEntity {
    @Id
  private String id;

    //одному ресурсу может соответствовать много прав
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "resourceEntity")
    private List<Right> rights;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<Right> getRights() {
    return rights;
  }

  public void setRights(List<Right> rights) {
    this.rights = rights;
  }
}
