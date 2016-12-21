package com.test.parser.twekTeam;


import com.test.parser.dto.TeamFromWiki;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

abstract public class TeamParcer {
    public TeamParcer(String html) {
        this.html = html;
    }
    private String html;
    public Document getDoc(){
        try {
            Document doc = Jsoup.connect(html).get();
            return doc;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            Document doc = new Document("");
            return doc;
        }}
    abstract public TeamFromWiki getData();
}
