package com.dron8.parserestate.config;

import com.dron8.parserestate.service.OlxService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.HttpClientErrorException;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
@Slf4j
public class OlxConfig
{
  private final OlxService olxService;

  @Scheduled(fixedRate = 120000)
  public void parseOlx() {
    log.info("Call Tolik");
    try {
      olxService.getAds();
    }
    catch (HttpClientErrorException e) {
      log.info(e.getMessage());
    }
  }
}


