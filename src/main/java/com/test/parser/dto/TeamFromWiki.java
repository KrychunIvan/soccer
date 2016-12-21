package com.test.parser.dto;


public class TeamFromWiki {
    public TeamFromWiki(String name, String logo) {
        this.name = name;
        this.logo = logo;
    }

    private String name;
    private String logo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString(){
        return "{teamName="+getName()+", logo="+getLogo()+"}";
    }

}
