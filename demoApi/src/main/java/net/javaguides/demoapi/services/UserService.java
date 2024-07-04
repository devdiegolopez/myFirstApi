package net.javaguides.demoapi.services;

import net.javaguides.demoapi.models.UserModel;
import net.javaguides.demoapi.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;

    public ArrayList<UserModel> getUsers() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }
    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }
    public Optional<UserModel> getUserById(long id) {
        return userRepository.findById(id);
    }
    public UserModel updateById(UserModel user, long id) {
        UserModel userModel = userRepository.findById(id).get();
        userModel.setFirstName(user.getFirstName());
        userModel.setLastName(user.getLastName());
        userModel.setEmail(user.getEmail());
        return userModel;
    }
    public boolean deleteById(long id) {
        try {
            userRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}