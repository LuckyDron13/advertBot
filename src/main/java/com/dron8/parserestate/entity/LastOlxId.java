package com.dron8.parserestate.entity;

import javax.persistence.*;

import com.dron8.parserestate.EstateType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class LastOlxId
{

  public LastOlxId(Integer lastOlxId, EstateType estateType){
    this.id = 1;
    this.lastOlxId = lastOlxId;
    this.estateType = estateType;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id = 1;
  private Integer lastOlxId;
  @Enumerated(EnumType.ORDINAL)
  private EstateType estateType;
}
