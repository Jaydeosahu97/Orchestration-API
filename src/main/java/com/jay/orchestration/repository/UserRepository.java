package com.jay.orchestration.repository;

import com.jay.orchestration.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findByRole(String role);

    Optional<User> findBySsn(String value);
}
