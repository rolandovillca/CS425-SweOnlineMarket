package edu.miu.cs.cs425.sweonlinemarketproject.repository;

import edu.miu.cs.cs425.sweonlinemarketproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    //@Query(value= "select u from User u where u.userName = :userName")
    Optional<User> findByUserName(String userName);

    @Query(value = "select u from User u inner join u.roles roles where roles.roleType = 'SELLER'")
    List<User> findUsersBySellerRole();
}
