package com.cloud.rest_api_railway.service;

import com.cloud.rest_api_railway.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);


}
