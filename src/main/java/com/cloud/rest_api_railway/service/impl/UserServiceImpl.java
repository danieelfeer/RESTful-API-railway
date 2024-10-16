package com.cloud.rest_api_railway.service.impl;

import com.cloud.rest_api_railway.domain.model.User;
import com.cloud.rest_api_railway.domain.repository.UserRepository;
import com.cloud.rest_api_railway.service.UserService;
import com.cloud.rest_api_railway.service.exception.BusinessException;
import com.cloud.rest_api_railway.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    private static final Long UNCHANGEABLE_USER_ID = 1L;

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public User create(User userToCreate) {
        ofNullable(userToCreate).orElseThrow(() -> new BusinessException("User to create must not be null."));
        ofNullable(userToCreate.getAccount()).orElseThrow(()-> new BusinessException("User account must not be null."));
        ofNullable(userToCreate.getCard()).orElseThrow(() -> new BusinessException("User card must not be null."));

        validateChangeableId(userToCreate.getId(), "created");

        if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new BusinessException("This account number already exists.");
        }

        if(userRepository.existsByCardNumber(userToCreate.getCard().getNumber())){
            throw new BusinessException("This card number already exists.");
        }

        return userRepository.save(userToCreate);
    }

    @Transactional
    public User update(Long id, User userToUpdate) {
        validateChangeableId(id, "updated");
        User dbUser = findById(id);

        if(!dbUser.getId().equals(userToUpdate.getId())){
            throw new BusinessException("Update IDs must be the same.");
        }

        dbUser.setName(userToUpdate.getName());
        dbUser.setAccount(userToUpdate.getAccount());
        dbUser.setCard(userToUpdate.getCard());
        dbUser.setFeature(userToUpdate.getFeature());
        dbUser.setNews(userToUpdate.getNews());

        return userRepository.save(dbUser);
    }

    @Transactional
    public void delete(Long id) {
        validateChangeableId(id, "deleted");
        User dbUser = findById(id);
        userRepository.delete(dbUser);
    }

    private void validateChangeableId(Long id, String operation){
        if(UNCHANGEABLE_USER_ID.equals(id)){
            throw new BusinessException("User with ID %d can not be %s.".formatted(UNCHANGEABLE_USER_ID, operation));
        }
    }
}
