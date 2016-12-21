package com.test.service.matches.dto;


public class MatchesWithDecodedTeamNames {
    public MatchesWithDecodedTeamNames(Long id, String homeTeam, String awayTeam, short homeScope, short awayScope) {
        this.id = id;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScope = homeScope;
        this.awayScope = awayScope;
    }

    private Long id;
    private String homeTeam;
    private String awayTeam;
    private short homeScope;
    private short awayScope;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public short getHomeScope() {
        return homeScope;
    }

    public void setHomeScope(short homeScope) {
        this.homeScope = homeScope;
    }

    public short getAwayScope() {
        return awayScope;
    }

    public void setAwayScope(short awayScope) {
        this.awayScope = awayScope;
    }
}
