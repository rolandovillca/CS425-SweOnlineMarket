package edu.miu.cs.cs425.sweonlinemarketproject.service;

import edu.miu.cs.cs425.sweonlinemarketproject.model.Address;
import edu.miu.cs.cs425.sweonlinemarketproject.model.User;

import java.util.List;

public interface UserService {

    User getUserById(Long id);

    List<User> getAllUsers();

    User addUser(User user);

    User updateUser(User user, Long id);

    void deleteUserById(Long userId);

    List<User> getSellers();

    User approveSeller(long sellerId);

}
