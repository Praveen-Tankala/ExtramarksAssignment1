package com.form.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.form.entity.NewUserEntry;

@Repository
public interface InterfaceNUE extends JpaRepository<NewUserEntry, Integer> {

}