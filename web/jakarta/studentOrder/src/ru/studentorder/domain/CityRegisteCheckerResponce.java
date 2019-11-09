package main.studentOrder.src.ru.studentorder.domain;

public class CityRegisteCheckerResponce {

  private boolean isExist;
  private Boolean temporal;

  public boolean isExist() {
    return isExist;
  }

  public void setExist(boolean exist) {
    isExist = exist;
  }

  public Boolean getTemporal() {
    return temporal;
  }

  public void setTemporal(Boolean temporal) {
    this.temporal = temporal;
  }
}
