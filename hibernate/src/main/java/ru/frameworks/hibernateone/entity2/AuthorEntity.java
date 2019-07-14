package ru.frameworks.hibernateone.entity2;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "author", schema = "hibertest", catalog = "")
public class AuthorEntity {

  private long id;
  private String name;
  private String secondName;

  @Id
  @Column(name = "id", nullable = false)
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @Basic
  @Column(name = "name", nullable = false, length = 255)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Basic
  @Column(name = "second_name", nullable = true, length = 50)
  public String getSecondName() {
    return secondName;
  }

  public void setSecondName(String secondName) {
    this.secondName = secondName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthorEntity that = (AuthorEntity) o;
    return id == that.id &&
        Objects.equals(name, that.name) &&
        Objects.equals(secondName, that.secondName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, secondName);
  }
}
