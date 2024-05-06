package com.pangisha.pangisha_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// import java.util.List;

import com.pangisha.pangisha_backend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    // @Query(value = "SELECT * FROM users", nativeQuery = true)
    // List<User> AllUser();

    @Query(value = "SELECT * FROM users A WHERE A.phone_no=:name ", nativeQuery = true)
    User UserByName(String name);

    @Query(value = "SELECT * FROM users A WHERE A.user_id=:id ", nativeQuery = true)
    User getUserId(Long id);

    @Query(value = "SELECT * FROM users A WHERE A.email=:username ", nativeQuery = true)
    User findByUsername(String username);

    @Query(value = "SELECT * FROM users A WHERE A.phone_no=:phone ", nativeQuery = true)
    User findByPhoneNo(String phone);

}
