package com.dron8.parserestate.repository;

import com.dron8.parserestate.EstateType;
import com.dron8.parserestate.entity.Advertisement;
import com.dron8.parserestate.entity.LastOlxId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface LastOlxIdRepository extends JpaRepository<LastOlxId, Integer>
{
    List <LastOlxId> findByEstateType(EstateType estateType);
}
