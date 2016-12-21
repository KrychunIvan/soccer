package com.test.parser.twekTeam.concreteParser;

import com.test.parser.twekTeam.TeamParcer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;

import org.jsoup.select.Elements;


import com.test.parser.dto.TeamFromWiki;

public class TeamParserForEnWiki extends TeamParcer{
    public TeamParserForEnWiki(String html) {
        super(html);
    }

    public TeamFromWiki getData() {
        String teamLogo;
        String teamName;
        Document doc = getDoc();

        Elements keyTable = doc.getElementsByClass("fn");
        teamName = keyTable.get(0).text();

        Elements logo = doc.getElementsByClass("infobox").first().getElementsByTag("tr").select("img[width~=([2-9][0-9][0-9])]");
        if (logo.size()!= 0){
            teamLogo = logo.first().attributes().get("src");
        }else {
            teamLogo = "";
        }

        return new TeamFromWiki(teamName,teamLogo);
    }
}
