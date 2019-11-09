package entitys;

import enums.Days;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Formula;

@Entity@Table
public class Student {

  int id;
  String name;
  @Access(AccessType.FIELD)
  @Enumerated (EnumType.STRING)//хранит enum в числовом или стринговом представлении
  private Days days;

//  @Temporal(TemporalType.DATE)//меняем
//  @CreationTimestamp //всегда время создание объекта
//  @UpdateTimestamp //-каждый раз при запуске будет апдейтить дату
//  private Date date;

  private int age =20;

  @Formula("id + age")
  private int idPlusAge;
  @Embedded
  private Address address;

  public int getIdPlusAge() {
    return idPlusAge;
  }

  public void setIdPlusAge(int idPlusAge) {
    this.idPlusAge = idPlusAge;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
//  public entitys.Student(String name, Days days, Date date) {
//      this.name = name;
//      this.days = days;
//      this.date = date;
//    }

    public Days getDays() {
      return days;
    }

    public void setDays(Days days) {
      this.days = days;
    }

    public Student(String name, Days days) {
      this.name = name;
      this.days = days;
    }
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Student(String name) {
    this.name = name;
  }

  public String getName() {
    return name + " from";
  }

  public void setName(String name) {
    this.name = name;
  }

  public Student() {
  }
}
