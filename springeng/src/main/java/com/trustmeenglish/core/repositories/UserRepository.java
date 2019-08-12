package com.trustmeenglish.core.repositories;

import com.trustmeenglish.core.model.User;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepository  extends  CrudRepository<User,Long>{ //параметризация crud репозитория


}
