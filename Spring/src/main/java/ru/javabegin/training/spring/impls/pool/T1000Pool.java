package ru.javabegin.training.spring.impls.pool;

import java.util.Collection;
import java.util.Map;
import ru.javabegin.training.spring.interfaces.Robot;
import ru.javabegin.training.spring.interfaces.RobotPool;

public class T1000Pool implements RobotPool {

  private Collection<Robot> robotCollection;

//  public void setRobotCollection(Map<String, Robot> robotCollection) {
//    this.robotCollection = robotCollection;

//  }
public void beginShow() {
  for (Robot robot : robotCollection) {
    robot.action();
  }
}
public T1000Pool(Collection<Robot>  robotCollection) {
  super();
  this.robotCollection = robotCollection;
}

  @Override
  public Collection<Robot> getRobotCollection() {
    return robotCollection;
  }



  /*@Override
  public Map<String, Robot> getRobotPool() {
    return robotCollection;
  }

  public void action() {
    for(Map.Entry<String, Robot> entry : robotCollection.entrySet()) {
      System.out.println(entry.getKey());
      entry.getValue().action();
    }
  }*/


}
