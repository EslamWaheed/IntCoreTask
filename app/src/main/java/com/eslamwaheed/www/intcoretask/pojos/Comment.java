package com.eslamwaheed.www.intcoretask.pojos;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comment implements Serializable {

    @SerializedName("postId")
    @Expose
    private Long postId;
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("body")
    @Expose
    private String body;
    private final static long serialVersionUID = 4183865211789670431L;

    /**
     * No args constructor for use in serialization
     */
    public Comment() {
    }

    /**
     * @param id
     * @param body
     * @param email
     * @param name
     * @param postId
     */
    public Comment(Long postId, Long id, String name, String email, String body) {
        super();
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}