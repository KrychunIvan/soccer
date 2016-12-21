package com.test.parser.twekTeam.concreteParser;

import com.test.parser.dto.TeamFromWiki;
import com.test.parser.twekTeam.TeamParcer;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import static com.test.parser.twekTeam.concreteParser.TeamParcerTypeDetect.parcerType.en;
import static com.test.parser.twekTeam.concreteParser.TeamParcerTypeDetect.parcerType.ro;
import static com.test.parser.twekTeam.concreteParser.TeamParcerTypeDetect.parcerType.ru;


public class TeamParcerTypeDetect extends TeamParcer {
    public enum parcerType{en,ru,ro};
    public static parcerType thisParcerType;
    public TeamParcerTypeDetect(String html) {
        super(html);
    }

    @Override
    public TeamFromWiki getData() {
        Document doc = getDoc();
        Elements keyTable = doc.getElementsByClass("org");

        if (keyTable.size() == 0) {
             if (doc.getElementsByClass("infocaseta").size() != 0){
            thisParcerType = ro;
             }else {
                 thisParcerType = ru;
             }
        }else {
            thisParcerType = en;
        }

        return null;
    }
}
