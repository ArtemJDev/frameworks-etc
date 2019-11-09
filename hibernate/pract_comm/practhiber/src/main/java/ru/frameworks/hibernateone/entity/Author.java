package ru.frameworks.hibernateone.entity;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor // для параметров NN
@DynamicUpdate //Обьновление одного поля
@EqualsAndHashCode (of="id") //генерация Equals hashCode
@ToString (of="name", includeFieldNames = false) //Вывод тоСтринг
public class Author implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // генерация ID через Autoincrement в MySQL
  private long id;

  @NonNull
  private String name;

  @OneToMany(mappedBy="author") //один автор, может быть автором нескольких книг
  @Basic(fetch = FetchType.LAZY) //Поздняя закгрузка полей объекта, есть ранняя eager
  private List<Book> books = new ArrayList<>();

  @Column(name = "second_name")
  private String second_name;

  public Author(long id, String name) {
    this.id = id;
    this.name = name;
  }


}
