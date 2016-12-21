package com.test.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "leagues", schema = "public", catalog = "d3h4emi1u049jp")
public class LeaguesEntity {
    private Long id;
    private String name;
    private String league;
    private int totalmatches;
    private int teamcount;
    private String icon;
   // private Collection<MatchesEntity> matchesById;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 40)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "league", nullable = false, length = 8)
    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    @Basic
    @Column(name = "totalmatches", nullable = false)
    public int getTotalmatches() {
        return totalmatches;
    }

    public void setTotalmatches(int totalmatches) {
        this.totalmatches = totalmatches;
    }

    @Basic
    @Column(name = "teamcount", nullable = false)
    public int getTeamcount() {
        return teamcount;
    }

    public void setTeamcount(int teamcount) {
        this.teamcount = teamcount;
    }

    @Basic
    @Column(name = "icon", nullable = true, length = 255)
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeaguesEntity that = (LeaguesEntity) o;

        if (id != that.id) return false;
        if (totalmatches != that.totalmatches) return false;
        if (teamcount != that.teamcount) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (league != null ? !league.equals(that.league) : that.league != null) return false;
        if (icon != null ? !icon.equals(that.icon) : that.icon != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (league != null ? league.hashCode() : 0);
        result = 31 * result + totalmatches;
        result = 31 * result + teamcount;
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        return result;
    }

   /* @OneToMany(mappedBy = "leaguesByLeagueid")
    public Collection<MatchesEntity> getMatchesById() {
        return matchesById;
    }

    public void setMatchesById(Collection<MatchesEntity> matchesById) {
        this.matchesById = matchesById;
    }*/
    @Override
    public String toString(){
        return "{id=" + id.toString() + ", name=" + name + ", league=" + league +
                ", totalmatches=" + totalmatches + ", teamcount=" + teamcount +
                ", icon=" + icon + "}";
    }
}
