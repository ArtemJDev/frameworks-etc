package main.orderapp.logic.src.main.java.ru.orderapp.auth;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.lang3.StringUtils;
import ru.orderapp.auth.domain.PersonEntity;
import ru.orderapp.auth.domain.PersonRole;
import ru.orderapp.auth.domain.ResourceEntity;
import ru.orderapp.auth.domain.Right;
import ru.orderapp.auth.domain.Role;

//логика в ejb
@Stateless
public class AuthenticateBean {


  @PersistenceContext(unitName = "examplePU")
  private EntityManager entityManager;

  //метод проверки доступности ресурса для персоны
  public boolean isGranted(String login, String resource) {
    if (StringUtils.isEmpty(login) || StringUtils.isEmpty(resource)) {
      return false;
    }
    ResourceEntity resourceEntity = entityManager.find(ResourceEntity.class, resource);
    if (resourceEntity == null) {
      return false;
    }
    PersonEntity personEntity = entityManager.find(PersonEntity.class, login);
    if (personEntity == null) {
      return false;
    }

    List<PersonRole> personRoles = personEntity.getPersonRoles();
    if (personRoles == null || personRoles.isEmpty()) {
      return false;
    }

      //поставить eager
      for(PersonRole personRole : personRoles) {
        Role role = personRole.getRole();
        if(role == null) {
          continue;
        }
        List <Right> rights = role.getRights();
        for(Right right : rights) {
          if(right == null) {
            continue;
          }
          //если id найденного в праве ресурса соответствеует иидентификатору переданому true
          ResourceEntity rightResource = right.getResourceEntity();
            if(rightResource.getId().equalsIgnoreCase(resource)) {
                  return true;
            }
        }
      }

    return false;

  }
}
