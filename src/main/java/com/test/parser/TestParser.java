package com.test.parser;


import com.test.parser.twekTeam.TeamParcer;
import com.test.parser.twekTeam.concreteParser.*;
import com.test.parser.twekTeam.factory.ParcerFactory;
import com.test.parser.twekCounty.CountyParser;

public class TestParser {

    public static void main(String[] args){
        /*ParcerFactory parcerFactory = new ParcerFactory();
        TeamParcer objForTest = parcerFactory.factoryMethod(
                "https://no.wikipedia.org/wiki/FK_Chornomorets_Odesa"
        );*/
        CountyParser objForTest = new CountyParser(
                "https://en.wikipedia.org/wiki/ISO_3166-1","https://ru.wikipedia.org/wiki/ISO_3166-1"
        );
        String test = objForTest.getData().toString();
        System.out.println(test);
    }
}
