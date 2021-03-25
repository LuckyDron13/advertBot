package com.dron8.parserestate;

import lombok.Getter;

@Getter
public enum EstateType {
  //  PRIVATE_HOUSE("https://www.olx.ua/nedvizhimost/doma/prodazha-domov/odessa/?search%5Bprivate_business%5D=private", "-463630461"),
   // FLAT("https://www.olx.ua/nedvizhimost/kvartiry-komnaty/prodazha-kvartir-komnat/odessa/?search%5Bprivate_business%5D=private", "-463630461"),
  //  DRON_FLAT("https://www.olx.ua/nedvizhimost/kvartiry-komnaty/arenda-kvartir-komnat/odessa/?search%5Bfilter_float_price%3Afrom%5D=8000&search%5Bfilter_float_price%3Ato%5D=13000&search%5Bfilter_float_number_of_rooms%3Ato%5D=2&search%5Bdistrict_id%5D=89","-411897238"),
   // TORRI_FLAT("https://www.olx.ua/nedvizhimost/kvartiry-komnaty/arenda-kvartir-komnat/odessa/?search%5Bfilter_float_price%3Afrom%5D=5000&search%5Bfilter_float_price%3Ato%5D=7000&search%5Bfilter_float_number_of_rooms%3Ato%5D=2&search%5Bdist%5D=10", "-428708226"),
  //  URBAN_CRAZY("https://www.olx.ua/nedvizhimost/kvartiry-komnaty/arenda-kvartir-komnat/odessa/?search%5Bfilter_float_price%3Afrom%5D=11000&search%5Bfilter_float_price%3Ato%5D=20000&search%5Bfilter_float_number_of_rooms%3Ato%5D=2&search%5Bdistrict_id%5D=89", "-451689197");
    RENT_FLAT_OLYA("https://www.olx.ua/nedvizhimost/kvartiry-komnaty/arenda-kvartir-komnat/odessa/?search%5Bfilter_float_price%3Afrom%5D=7000&search%5Bfilter_float_price%3Ato%5D=11000&search%5Bfilter_enum_commission%5D%5B0%5D=1&search%5Bfilter_float_number_of_rooms%3Ato%5D=2&search%5Bdistrict_id%5D=89", "-558363920"),
    RENT_FLAT_OLYA_RIELTORS("https://www.olx.ua/nedvizhimost/kvartiry-komnaty/arenda-kvartir-komnat/odessa/?search%5Bfilter_float_price%3Afrom%5D=7000&search%5Bfilter_float_price%3Ato%5D=11000&search%5Bfilter_enum_commission%5D%5B0%5D=1&search%5Bfilter_enum_cooperate%5D%5B0%5D=1&search%5Bfilter_float_number_of_rooms%3Ato%5D=2&search%5Bdistrict_id%5D=89", "-558363920"),
    RENT_FLAT_OLYA_RIELTORS2("https://www.olx.ua/nedvizhimost/kvartiry-komnaty/arenda-kvartir-komnat/odessa/?search%5Bfilter_float_price%3Afrom%5D=7000&search%5Bfilter_float_price%3Ato%5D=11000&search%5Bfilter_enum_commission%5D%5B0%5D=1&search%5Bfilter_enum_cooperate%5D%5B0%5D=1&search%5Bfilter_float_number_of_rooms%3Ato%5D=2&search%5Bdistrict_id%5D=89", "-558363920"),
    RENT_FLAT_YANA_YURA3("https://www.olx.ua/nedvizhimost/kvartiry-komnaty/arenda-kvartir-komnat/odessa/?search%5Bfilter_float_price%3Ato%5D=6000&search%5Bfilter_float_number_of_rooms%3Ato%5D=2&search%5Bdistrict_id%5D=85", "-341829308"),
    RENT_FLAT_OLYA_RIELTORS4("https://www.olx.ua/nedvizhimost/kvartiry-komnaty/arenda-kvartir-komnat/odessa/?search%5Bfilter_float_price%3Ato%5D=14000&search%5Bfilter_float_price%3Afrom%5D=7000&search%5Bdistrict_id%5D=89", "-558363920");

   // NEW_YEAR_LVIV("https://www.olx.ua/nedvizhimost/posutochno-pochasovo/posutochno-pochasovo-doma/lvov/", "-375377312"),
    //NEW_YEAR_LVIV_FLAT("https://www.olx.ua/nedvizhimost/posutochno-pochasovo/posutochno-pochasovo-kvartiry/lvov/?search%5Bfilter_float_number_of_rooms%3Afrom%5D=3", "-375377312");


    private final String URL;
    private final String chatId;

    EstateType(String url, String chatId) {
        this.URL = url;
        this.chatId = chatId;
    }
}
