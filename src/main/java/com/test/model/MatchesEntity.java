package com.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.hibernate.annotations.Target;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "matches", schema = "public", catalog = "d3h4emi1u049jp")
public class MatchesEntity {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(
            name = "leagueid",
            referencedColumnName = "id",
            nullable = false,insertable = false, updatable = false)
    @JsonIgnore
    private LeaguesEntity leaguesEntity;
    public LeaguesEntity getLeaguesEntity() {
        return leaguesEntity;
    }
    public void setLeaguesEntity(LeaguesEntity leaguesEntity) {
        this.leaguesEntity = leaguesEntity;
    }


    @Basic
    @Column(name = "hometeamid", nullable = false)
    private int hometeamid;
    public int getHometeamid() {
        return hometeamid;
    }

    public void setHometeamid(int hometeamid) {
        this.hometeamid = hometeamid;
    }

    @Basic
    @Column(name = "awayteamid", nullable = false)
    private int awayteamid;

    public int getAwayteamid() {
        return awayteamid;
    }

    public void setAwayteamid(int awayteamid) {
        this.awayteamid = awayteamid;
    }



    @Basic
    @Column(name = "homescore", nullable = false)
    private short homescore;

    public short getHomescore() {
        return homescore;
    }

    public void setHomescore(short homescore) {
        this.homescore = homescore;
    }

    @Basic
    @Column(name = "awayscore", nullable = false)
    private short awayscore;
    public short getAwayscore() {
        return awayscore;
    }

    public void setAwayscore(short awayscore) {
        this.awayscore = awayscore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MatchesEntity that = (MatchesEntity) o;

        if (id != that.id) return false;
       /* if (leagueid != that.leagueid) return false;*/
        if (hometeamid != that.hometeamid) return false;
        if (awayteamid != that.awayteamid) return false;
        if (homescore != that.homescore) return false;
        if (awayscore != that.awayscore) return false;;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        /*result = 31 * result + leagueid;*/
        result = 31 * result + hometeamid;
        result = 31 * result + awayteamid;
        result = 31 * result + (int) homescore;
        result = 31 * result + (int) awayscore;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "hometeamid", referencedColumnName = "id", nullable = false,insertable = false, updatable = false)

    private TeamsEntity teamsByHometeamid;
    public TeamsEntity getTeamsByHometeamid() {
        return teamsByHometeamid;
    }

    public void setTeamsByHometeamid(TeamsEntity teamsByHometeamid) {
        this.teamsByHometeamid = teamsByHometeamid;
    }

    @ManyToOne
    @JoinColumn(name = "awayteamid", referencedColumnName = "id", nullable = false,insertable = false, updatable = false)

    private TeamsEntity teamsByAwayteamid;
    public TeamsEntity getTeamsByAwayteamid() {
        return teamsByAwayteamid;
    }

    public void setTeamsByAwayteamid(TeamsEntity teamsByAwayteamid) {
        this.teamsByAwayteamid = teamsByAwayteamid;
    }


}
