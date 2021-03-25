package com.dron8.parserestate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Advertisement
    implements Comparable<Advertisement>
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String link;

  private Integer olxId;

  @Override
  public int compareTo(final Advertisement o) {
    return Integer.compare(this.getOlxId(), o.getOlxId());
  }
}
