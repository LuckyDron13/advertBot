package com.dron8.parserestate.config;

import com.dron8.parserestate.EstateType;
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

  @Scheduled(fixedRate = 3600000)
  public void parseOlxOlya() {
    log.info("RENT_FLAT_OLYA_RIELTORS");
    try {
      olxService.getAds(EstateType.RENT_FLAT_OLYA_RIELTORS4);
    }
    catch (HttpClientErrorException e) {
      log.info(e.getMessage());
    }
  }

/*    @Scheduled(fixedRate = 3600000)
    public void parseOlxYANAYURA() {
        log.info("Call Private House");
        try {
            olxService.getAds(EstateType.RENT_FLAT_YANA_YURA3);
        }
        catch (HttpClientErrorException e) {
            log.info(e.getMessage());
        }
    }*/

/*    @Scheduled(fixedRate = 3600000)
    public void parseOlxPrivateHouseLviv() {
        log.info("Call Private House");
        try {
            olxService.getAds(EstateType.NEW_YEAR_LVIV);
        }
        catch (HttpClientErrorException e) {
            log.info(e.getMessage());
        }
    }*/

/*    @Scheduled(fixedRate = 3600000)
    public void parseOlxPrivateHouseLvivFlat() {
        log.info("Call Private House");
        try {
            olxService.getAds(EstateType.NEW_YEAR_LVIV_FLAT);
        }
        catch (HttpClientErrorException e) {
            log.info(e.getMessage());
        }
    }*/

/*  @Scheduled(fixedRate = 3600000)
public void parseOlxFlat() {
  log.info("Call Flat");
  try {
    olxService.getAds(EstateType.FLAT);
  }
  catch (HttpClientErrorException e) {
    log.info(e.getMessage());
  }
}

  @Scheduled(fixedRate = 10800000)
  public void parseOlxDronFlat() {
    log.info("Call Dron Flat");
    try {
      olxService.getAds(EstateType.DRON_FLAT);
    }
    catch (HttpClientErrorException e) {
      log.info(e.getMessage());
    }
  }

  @Scheduled(fixedRate = 10800000)
  public void parseOlxTorriFlat() {
    log.info("Call Dron Flat");
    try {
      olxService.getAds(EstateType.TORRI_FLAT);
    }
    catch (HttpClientErrorException e) {
      log.info(e.getMessage());
    }
  }

  @Scheduled(fixedRate = 10800000)
  public void parseOlxHmelnFlat() {
    log.info("Call URBAN_CRAZY Flat");
    try {
      olxService.getAds(EstateType.URBAN_CRAZY);
    }
    catch (HttpClientErrorException e) {
      log.info(e.getMessage());
    }
  }*/
}


