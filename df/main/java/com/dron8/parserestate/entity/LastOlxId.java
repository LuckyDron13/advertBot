package com.dron8.parserestate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class LastOlxId
{

  public LastOlxId(Integer lastOlxId){
    this.id = 1;
    this.lastOlxId = lastOlxId;
  }

  @Id
  private Integer id = 1;
  private Integer lastOlxId;
}
