package com.example.app.user;

import org.springframework.data.jpa.repository.JpaRepository;

//user repository that will support user CRUD extended from JPA REPO
public interface UserRepository extends JpaRepository<User, Long> {

}
