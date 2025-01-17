package com.cloud.rest_api_railway.domain.repository;

import com.cloud.rest_api_railway.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByAccountNumber(String accountNumber);

    boolean existsByCardNumber(String number);

}
