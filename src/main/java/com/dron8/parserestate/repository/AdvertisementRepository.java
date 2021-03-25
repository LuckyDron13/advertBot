package com.dron8.parserestate.repository;

import com.dron8.parserestate.entity.Advertisement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementRepository extends CrudRepository <Advertisement, Integer>
{
  boolean existsAdvertisementByLink(String link);
}
