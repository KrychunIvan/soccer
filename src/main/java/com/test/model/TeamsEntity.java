package com.test.model;

import javax.persistence.*;


@Entity
@Table(name = "teams", schema = "soccerdb")
public class TeamsEntity {
    private Long id;
    private String team;

    @Id
    @Column(name = "ID", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "team", nullable = true, length = 45)
    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamsEntity that = (TeamsEntity) o;

        if (id != that.id) return false;
        if (team != null ? !team.equals(that.team) : that.team != null) return false;

        return true;
    }

    @Override
    public int hashCode() {

        return id.hashCode();
    }
}
