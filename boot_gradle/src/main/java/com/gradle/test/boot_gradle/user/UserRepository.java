package com.gradle.test.boot_gradle.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gradle.test.boot_gradle.vo.SiteUser;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
    Optional<SiteUser> findByusername(String username);
}
