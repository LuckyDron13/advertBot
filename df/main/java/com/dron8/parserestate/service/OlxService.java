package com.dron8.parserestate.service;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.dron8.parserestate.entity.Advertisement;
import com.dron8.parserestate.entity.LastOlxId;
import com.dron8.parserestate.repository.AdvertisementRepository;
import com.dron8.parserestate.repository.LastOlxIdRepository;
import com.dron8.parserestate.scrapper.WebscrapperApp;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class OlxService
{
  private final AdvertisementRepository advertisementRepository;

  private final LastOlxIdRepository lastOlxIdRepository;

  public Set<Advertisement> getAds() {
    Integer lastOlxId = lastOlxIdRepository.findById(1).orElse(new LastOlxId(1)).getLastOlxId();
    HtmlPage htmlPage = WebscrapperApp
        .loginToSite(
            "https://www.olx.ua/nedvizhimost/doma/prodazha-domov/odessa/?search%5Bprivate_business%5D=private");

    DomNodeList<DomNode> domNodes = !htmlPage.querySelectorAll("table[summary='Оголошення']").isEmpty() ?
        htmlPage.querySelectorAll("table[summary='Оголошення']") :
        htmlPage.querySelectorAll("table[summary='Объявление']");

    TreeSet<Advertisement> advertisementSet = domNodes.stream()
        .filter(x -> Integer.parseInt(x.getAttributes().getNamedItem("data-id").getNodeValue()) > lastOlxId)
        .map(x ->
            {
              Advertisement advertisement = new Advertisement();
              advertisement.setOlxId(Integer.parseInt(x.getAttributes().getNamedItem("data-id").getNodeValue()));
              advertisement.setLink(x.querySelector(".detailsLink").getAttributes().getNamedItem("href").getNodeValue());
              return advertisement;
            }
        )
        .collect(Collectors.toCollection(TreeSet::new));

/*    Set<Advertisement> advertisementSet = htmlPage.querySelectorAll(".detailsLink").stream()
        .map(domNode -> domNode.getAttributes().getNamedItem("href").getNodeValue())
        .map(link -> {
          Advertisement advertisement = new Advertisement();
          advertisement.setLink(link);
          return advertisement;
        })
        .collect(Collectors.toSet());*/

 /*   StringBuilder sb = new StringBuilder();
    for (Advertisement s : advertisementSet)
    {
      sb.append(s.getLink());
      sb.append("%0A");
    }*/
    for (Advertisement advertisement : advertisementSet) {
      RestTemplate restTemplate = new RestTemplate();

      String fooResourceUrl
          =
          "https://api.telegram.org/bot1380441454:AAFSO5DH7i5C8w1brTYHQpAo_igzMKI_Me4/sendMessage?chat_id=-463630461&text=" +
              advertisement.getLink();
      HttpHeaders httpHeaders = new HttpHeaders();
      UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(fooResourceUrl);

      HttpEntity<?> requestEntity = new HttpEntity<>(null, httpHeaders);

      HttpEntity<String> response = restTemplate.exchange(
          builder.toUriString(),
          HttpMethod.GET,
          requestEntity,
          String.class);
      advertisementRepository.save(advertisement);
      lastOlxIdRepository.save(new LastOlxId(advertisement.getOlxId()));
    }

    //   String body = response.getBody();
    return advertisementSet;
  }
}
