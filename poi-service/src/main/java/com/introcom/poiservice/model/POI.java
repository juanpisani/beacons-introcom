package com.introcom.poiservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class POI {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String html;

    private Long beacon;

    public POI(String title, String html, Long beacon) {
        this.title = title;
        this.html = html;
        this.beacon = beacon;
    }

    public POI(String title, String html) {
        this.title = title;
        this.html = html;
    }

    public POI() {
    }

    public Long getBeacon() {
        return beacon;
    }

    public void setBeacon(Long beacon) {
        this.beacon = beacon;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
