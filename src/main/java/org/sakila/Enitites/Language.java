package org.sakila.Enitites;

// Generated 20/10/2012 11:23:03 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Language generated by hbm2java
 */
@Entity
@Table(name = "language", catalog = "sakila")
public class Language implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private Byte languageId;
    private String name;
    private Date lastUpdate;
    private List<Film> filmsForOriginalLanguageId;
    private List<Film> filmsForLanguageId;

    public Language() {
    }

    public Language(String name, Date lastUpdate) {
        this.name = name;
        this.lastUpdate = lastUpdate;
    }

    public Language(String name, Date lastUpdate,
                    List<Film> filmsForOriginalLanguageId, List<Film> filmsForLanguageId) {
        this.name = name;
        this.lastUpdate = lastUpdate;
        this.filmsForOriginalLanguageId = filmsForOriginalLanguageId;
        this.filmsForLanguageId = filmsForLanguageId;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "language_id", unique = true, nullable = false)
    public Byte getLanguageId() {
        return this.languageId;
    }

    public void setLanguageId(Byte languageId) {
        this.languageId = languageId;
    }

    @Column(name = "name", nullable = false, length = 20)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update", nullable = false, length = 19)
    public Date getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "languageByOriginalLanguageId")
    public List<Film> getFilmsForOriginalLanguageId() {
        return this.filmsForOriginalLanguageId;
    }

    public void setFilmsForOriginalLanguageId(
            List<Film> filmsForOriginalLanguageId) {
        this.filmsForOriginalLanguageId = filmsForOriginalLanguageId;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "languageByLanguageId")
    public List<Film> getFilmsForLanguageId() {
        return this.filmsForLanguageId;
    }

    public void setFilmsForLanguageId(List<Film> filmsForLanguageId) {
        this.filmsForLanguageId = filmsForLanguageId;
    }

}
