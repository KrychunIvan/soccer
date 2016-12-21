package com.test.parser.twekTeam.concreteParser;

import com.test.parser.dto.TeamFromWiki;
import com.test.parser.twekTeam.TeamParcer;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class TeamParcerForRoWiki extends TeamParcer {
    public TeamParcerForRoWiki(String html) {
        super(html);
    }
    @Override
    public TeamFromWiki getData() {

    String teamLogo;
    String teamName;

    Document doc = getDoc();
    Elements keyTable = doc.getElementsByClass("infocaseta");
    teamName = keyTable.first().getElementsByTag("tr").first().text();

    Elements logo = keyTable.first().getElementsByTag("tr").select("img[width~=([2-9][0-9][0-9])]");
        if (logo.size()!= 0){
        teamLogo = logo.first().attributes().get("src");
    }else {
        teamLogo = "";
    }

        return new TeamFromWiki(teamName,teamLogo);
}
}
