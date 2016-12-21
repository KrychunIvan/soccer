package com.test.parser.twekTeam.factory;


import com.test.parser.twekTeam.TeamParcer;
import com.test.parser.twekTeam.concreteParser.*;

 public class ParcerFactory {

      public TeamParcer factoryMethod(String html){
          TeamParcerTypeDetect teamParcerTypeDetect = new TeamParcerTypeDetect(html);
          teamParcerTypeDetect.getData();
          switch (TeamParcerTypeDetect.thisParcerType){
              case en:  return new TeamParserForEnWiki(html);

              case ru:  return new TeamParcerForRuWiki(html);

              case ro:  return new TeamParcerForRoWiki(html);

              default: return null;
          }


      }
}
