package com.trustmeenglish.core.services;

import com.trustmeenglish.core.model.User;
import com.trustmeenglish.core.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServise {

  private final UserRepository userRepository;


  @Override
  public User getUser(Long id) {
    return userRepository.findById(id).get();
  }
}
