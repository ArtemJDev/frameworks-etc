package main.orderapp.logic.src.main.java.ru.orderapp.auth.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resource_rights")
public class Right {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  //На одно право может быть много ресурсов
  @ManyToOne(fetch = FetchType.EAGER)
  private ResourceEntity resourceEntity;
  @ManyToOne
  private Role roles;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public ResourceEntity getResourceEntity() {
    return resourceEntity;
  }

  public void setResourceEntity(ResourceEntity resourceEntity) {
    this.resourceEntity = resourceEntity;
  }

  public Role getRoles() {
    return roles;
  }

  public void setRoles(Role roles) {
    this.roles = roles;
  }
}
