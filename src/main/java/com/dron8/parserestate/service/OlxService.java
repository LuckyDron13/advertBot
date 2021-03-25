package com.dron8.parserestate.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.dron8.parserestate.EstateType;
import com.dron8.parserestate.entity.Advertisement;
import com.dron8.parserestate.entity.LastOlxId;
import com.dron8.parserestate.repository.AdvertisementRepository;
import com.dron8.parserestate.repository.LastOlxIdRepository;
import com.dron8.parserestate.scrapper.WebscrapperApp;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.protocol.HTTP;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
@Slf4j
public class OlxService {
    private final AdvertisementRepository advertisementRepository;

    private final LastOlxIdRepository lastOlxIdRepository;

    public Set<Advertisement> getAds(EstateType estateType) {
        List<LastOlxId> byEstateType = lastOlxIdRepository.findByEstateType(estateType);
        LastOlxId lastOlxIdEntity = !byEstateType.isEmpty() ? byEstateType.get(0) : new LastOlxId(688221630, estateType);
        Integer lastOlxId = lastOlxIdEntity.getLastOlxId();

        log.info("lastOlxId {}", lastOlxId);
        HtmlPage htmlPage = WebscrapperApp
                .loginToSite(estateType.getURL());

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
        for (Advertisement advertisement : advertisementSet) {
            String messageText = "id+" + advertisement.getOlxId() + "+" + advertisement.getLink();
            sendMessageToTelegramChat(messageText, estateType.getChatId());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            advertisementRepository.save(advertisement);
            lastOlxIdEntity.setLastOlxId(advertisement.getOlxId());
            lastOlxIdRepository.save(lastOlxIdEntity);
        }

/*        if (advertisementSet.isEmpty()) {
            sendMessageToTelegramChat("Нет+новых+объявлений+по+продаже+"+estateType.toString()+"."+lastOlxId , estateType.getChatId());
        }*/

        return advertisementSet;
    }

    private void sendMessageToTelegramChat(String messageText, String chatId) {
        RestTemplate restTemplate = new RestTemplate();

        String fooResourceUrl
                =
                "https://api.telegram.org/bot1347957785:AAFZETefWSnjph-O7kVhuDai7k2C1ks3CrI/sendMessage?chat_id="+chatId+"&text=" +

                        messageText;
        HttpHeaders httpHeaders = new HttpHeaders();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(fooResourceUrl);

        HttpEntity<?> requestEntity = new HttpEntity<>(null, httpHeaders);


        HttpEntity<String> response = restTemplate.exchange(
                builder.build(false).toUri(),
                HttpMethod.GET,
                requestEntity,
                String.class);
    }
}
