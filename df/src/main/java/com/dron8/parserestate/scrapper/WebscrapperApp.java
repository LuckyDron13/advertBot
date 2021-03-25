package com.dron8.parserestate.scrapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebWindow;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class WebscrapperApp
{
  public static WebWindow lol;

  public static HtmlPage loginToSite(String url){
    WebClient webClient = new WebClient();
    webClient.addRequestHeader("Access-control-allow-origin", "Origin");
    webClient.getOptions().setThrowExceptionOnScriptError(false);
    webClient.getOptions().setCssEnabled(false);
    webClient.getOptions().setJavaScriptEnabled(false);
    try {
      return webClient.getPage(url);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      webClient.close();
    }
    return null;
  }

  public static WebWindow getWebWindow(String url)  {
    WebClient webClient = new WebClient();
    webClient.addRequestHeader("Access-control-allow-origin", "Origin");
    webClient.getOptions().setThrowExceptionOnScriptError(false);
    webClient.getOptions().setCssEnabled(false);
    URL urL = null;
    try {
      urL = new URL(url);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return webClient.openWindow(urL, "lol");

  }

  public static HtmlPage clicker(DomElement domElement) {
    HtmlPage result = null;
    try {
      HtmlPage page = domElement.click();
      Thread.sleep(3000);
      return page;
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
    return result;
  }





}
