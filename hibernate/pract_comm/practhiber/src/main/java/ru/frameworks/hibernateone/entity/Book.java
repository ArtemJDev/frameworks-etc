package ru.frameworks.hibernateone.entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@Setter
@DynamicUpdate //Обьновление одного поля
@DynamicInsert
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // генерация ID через Autoincrement в MySQL
    private long id;

    private String name;

    private long authorId;

    @ManyToOne //имеет ссылку FC на таблицу autho, у многих книг один автор
    @JoinColumn //Связать с полем автор, юудет подставляться вмиесто  author
    private Author author;

}
