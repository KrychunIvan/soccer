package com.test.model;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "teams", schema = "public", catalog = "d3h4emi1u049jp")
public class TeamsEntity {
    private Long id;
    private String name;
    private String logo;
   /* private Collection<MatchesEntity> matchesById;
    private Collection<MatchesEntity> matchesById_0;*/

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "logo", nullable = true, length = 255)
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamsEntity that = (TeamsEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (logo != null ? !logo.equals(that.logo) : that.logo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (logo != null ? logo.hashCode() : 0);
        return result;
    }

    /*@OneToMany(mappedBy = "teamsByHometeamid")
    public Collection<MatchesEntity> getMatchesById() {
        return matchesById;
    }

    public void setMatchesById(Collection<MatchesEntity> matchesById) {
        this.matchesById = matchesById;
    }

    @OneToMany(mappedBy = "teamsByAwayteamid")
    public Collection<MatchesEntity> getMatchesById_0() {
        return matchesById_0;
    }

    public void setMatchesById_0(Collection<MatchesEntity> matchesById_0) {
        this.matchesById_0 = matchesById_0;
    }*/
}
