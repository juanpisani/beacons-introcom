package com.introcom.beaconservice.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
public class Message {

    @Id
    private
    String id;

    private Long utcTime;

    @Indexed(unique = true)
    private String phoneId;

    private String uuid;

    private Integer minor;

    private Integer major;

    public Message(Long utcTime, String phoneId, String uuid, Integer minor, Integer major) {
        this.utcTime = utcTime;
        this.phoneId = phoneId;
        this.uuid = uuid;
        this.minor = minor;
        this.major = major;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getUtcTime() {
        return utcTime;
    }

    public void setUtcTime(Long utcTime) {
        this.utcTime = utcTime;
    }

    public String getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getMinor() {
        return minor;
    }

    public void setMinor(Integer minor) {
        this.minor = minor;
    }

    public Integer getMajor() {
        return major;
    }

    public void setMajor(Integer major) {
        this.major = major;
    }
}
