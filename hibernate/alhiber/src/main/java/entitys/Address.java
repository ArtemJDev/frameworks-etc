package entitys;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Address {

  @Transient
  String street;

  int number;

  public Address(String street, int number) {
    this.street = street;
    this.number = number;
  }

  public Address() {
  }


}
