package com.checkbeep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.checkbeep.model.Tags;


@Repository
public interface TagsRepository extends JpaRepository<Tags, Long> {

}