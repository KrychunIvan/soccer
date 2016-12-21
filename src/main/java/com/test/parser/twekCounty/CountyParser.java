package com.test.parser.twekCounty;

import com.test.parser.dto.CountryFromWiki;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CountyParser {
    public CountyParser(String htmlForCode, String htmlForIcon) {
        this.htmlForCode = htmlForCode;
        this.htmlForIcon = htmlForIcon;
    }

    private String htmlForCode;
    private String htmlForIcon;
    private static Long nextId = new Long(0);
    private static Map<Long,CountryFromWiki> countryFromWikiMap = new HashMap<Long, CountryFromWiki>();
    private static final String flagIcon166 = "//upload.wikimedia.org/wikipedia/commons/thumb/7/74/Flag_of_the_Cocos_%28Keeling%29_Islands.svg/22px-Flag_of_the_Cocos_%28Keeling%29_Islands.svg.png";
    private static final String flagIcon316 = "//upload.wikimedia.org/wikipedia/commons/thumb/0/07/Flag_of_Guam.svg/22px-Flag_of_Guam.svg.png";

    public Document getDoc(String html){
        try {
            Document doc = Jsoup.connect(html).get();
            return doc;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            Document doc = new Document("");
            return doc;
        }}

    public String getNameFromTr(Element tr){
        return tr.getElementsByTag("td").get(0).text();
    }
    public String getAlpha2FromTr(Element tr){
        return tr.getElementsByTag("td").get(1).text();
    }

    public String getCountryCodeFromTr(Element tr){
        return tr.getElementsByTag("td").get(3).text();
    }

    public int findSameAlpha2(String countryCode, Elements table){
        if (countryCode.equals("166")) return -2;
        if (countryCode.equals("316")) return -3;

        int i = 0;
        while (!table.get(i).text().contains(countryCode)){
            i++;
            if(i>table.size()) return -1;
        }
        return i;
    }

    private String getIconFromTr(Element tr){
        String countryCode = getCountryCodeFromTr(tr);
        Document doc = getDoc(htmlForIcon);
        Elements keyTable = doc.getElementsByClass("wikitable").first().getElementsByTag("tr");
        int indexOfNeedsTr = findSameAlpha2(countryCode,keyTable);

        switch (indexOfNeedsTr){
            case -1: return "";
            case -2: return flagIcon166;
            case -3: return flagIcon316;
            default: break;
        }
        return keyTable.get(indexOfNeedsTr).
                select("img[width~=([1-9][0-9])]").first().attributes().get("src");
    }
    public Map<Long,CountryFromWiki> getData() {

        Document doc = getDoc(htmlForCode);
        Element keyTable = doc.getElementsByClass("wikitable").get(0);
        Elements keyTr = keyTable.getElementsByTag("tr");

        while (keyTr.size()>nextId+1){
            CountryFromWiki countryFromWiki = new CountryFromWiki(
                    getNameFromTr(keyTr.get((int)(long)nextId+1)),
                    getAlpha2FromTr(keyTr.get((int)(long)nextId+1)),
                    getCountryCodeFromTr(keyTr.get((int)(long)nextId+1)),
                    getIconFromTr(keyTr.get((int)(long)nextId+1)));
            countryFromWikiMap.put(nextId,countryFromWiki);
            nextId += 1;
        }

        return countryFromWikiMap;
    }

}
