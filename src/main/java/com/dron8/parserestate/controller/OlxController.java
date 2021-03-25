package com.dron8.parserestate.controller;

import java.util.List;
import java.util.Set;

import com.dron8.parserestate.EstateType;
import com.dron8.parserestate.service.OlxService;
import com.dron8.parserestate.entity.Advertisement;
import jdk.internal.dynalink.linker.LinkerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/olx")
public class OlxController
{
  private final OlxService olxService;

  @GetMapping("/ads")
  public ResponseEntity<Set<Advertisement>> getOlxAds() {

    return new ResponseEntity<>(olxService.getAds(EstateType.RENT_FLAT_OLYA), HttpStatus.OK);
  }
}
