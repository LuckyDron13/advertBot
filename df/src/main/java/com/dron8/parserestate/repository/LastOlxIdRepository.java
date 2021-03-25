package com.dron8.parserestate.repository;

import com.dron8.parserestate.entity.Advertisement;
import com.dron8.parserestate.entity.LastOlxId;
import org.springframework.data.repository.CrudRepository;

public interface LastOlxIdRepository extends CrudRepository<LastOlxId, Integer>
{
}
