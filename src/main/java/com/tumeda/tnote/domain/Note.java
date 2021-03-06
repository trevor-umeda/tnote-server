package com.tumeda.tnote.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * The Employee entity.
 */
@ApiModel(description = "The Employee entity.")
@Entity
@Table(name = "note")
public class Note implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    /**
     * The firstname attribute.
     */
    @ApiModelProperty(value = "The firstname attribute.")
    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @Column(name = "created")
    private ZonedDateTime created;

    @Column(name = "tag")
    private String tag;

    @ManyToOne
    private Note note;

    @OneToMany(mappedBy = "note")
    @JsonIgnore
    private Set<Note> children = new HashSet<>();

    @ManyToOne
    private Topic topic;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Note title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public Note text(String text) {
        this.text = text;
        return this;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ZonedDateTime getCreated() {
        return created;
    }

    public Note created(ZonedDateTime created) {
        this.created = created;
        return this;
    }

    public void setCreated(ZonedDateTime created) {
        this.created = created;
    }

    public String getTag() {
        return tag;
    }

    public Note tag(String tag) {
        this.tag = tag;
        return this;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Note getNote() {
        return note;
    }

    public Note note(Note note) {
        this.note = note;
        return this;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public Set<Note> getChildren() {
        return children;
    }

    public Note children(Set<Note> notes) {
        this.children = notes;
        return this;
    }

    public Note addChildren(Note note) {
        this.children.add(note);
        note.setNote(this);
        return this;
    }

    public Note removeChildren(Note note) {
        this.children.remove(note);
        note.setNote(null);
        return this;
    }

    public void setChildren(Set<Note> notes) {
        this.children = notes;
    }

    public Topic getTopic() {
        return topic;
    }

    public Note topic(Topic topic) {
        this.topic = topic;
        return this;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
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
        Note note = (Note) o;
        if (note.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), note.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Note{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", text='" + getText() + "'" +
            ", created='" + getCreated() + "'" +
            ", tag='" + getTag() + "'" +
            "}";
    }
}
