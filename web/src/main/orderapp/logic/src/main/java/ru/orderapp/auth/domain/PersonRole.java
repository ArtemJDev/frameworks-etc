package main.orderapp.logic.src.main.java.ru.orderapp.auth.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//дополнительная сущзность для связывания против manytoMany
@Entity
public class PersonRole {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  //Одна свзяь звено может быть у многих ролей
  //При извлечении листа сущностей
  @ManyToOne(fetch = FetchType.EAGER)
  private Role role;

  //Много персон
  @ManyToOne(fetch = FetchType.EAGER)//при извелечении сущностей personrole , поля заполнены сразу
  //Одна свзяь звено может быть у многих персон
  private PersonEntity personEntity;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public PersonEntity getPersonEntity() {
    return personEntity;
  }

  public void setPersonEntity(PersonEntity personEntity) {
    this.personEntity = personEntity;
  }
}
