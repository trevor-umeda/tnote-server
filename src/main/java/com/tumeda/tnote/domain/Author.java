package com.tumeda.tnote.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Objects;

/**
 * A Author.
 */
@Entity
@Table(name = "author")
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "username")
    private String username;

    @OneToMany(mappedBy = "author")
    private List<Topic> profiles = new ArrayList<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public Author username(String username) {
        this.username = username;
        return this;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Topic> getProfiles() {
        return profiles;
    }

    public Author profiles(List<Topic> topics) {
        this.profiles = topics;
        return this;
    }

    public Author addProfiles(Topic topic) {
        this.profiles.add(topic);
        topic.setAuthor(this);
        return this;
    }

    public Author removeProfiles(Topic topic) {
        this.profiles.remove(topic);
        topic.setAuthor(null);
        return this;
    }

    public void setProfiles(List<Topic> topics) {
        this.profiles = topics;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Author author = (Author) o;
        if (author.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), author.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Author{" +
            "id=" + getId() +
            ", username='" + getUsername() + "'" +
            "}";
    }
}
