package com.pyda.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by jakubpyda on 03/09/16.
 */
interface AccountRepository extends JpaRepository<Account, Long> {

	Optional<Account> findByUsername(String username);

}