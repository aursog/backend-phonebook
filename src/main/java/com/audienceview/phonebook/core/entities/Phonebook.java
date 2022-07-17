package com.audienceview.phonebook.core.entities;

import java.time.LocalDateTime;

public class Phonebook {

    private final Long id;
    private final String fullname;
    private final String phone;
    private final LocalDateTime creationAt;
    private final LocalDateTime modifyAt;
    private final Boolean active;

    private static class Builder {
        private Long id;
        private String fullname;
        private String phone;
        private LocalDateTime creationAt;
        private LocalDateTime modifyAt;
        private Boolean active;

        public Builder() { }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder fullname(String fullname) {
            this.fullname = fullname;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder creationAt(LocalDateTime creationAt) {
            this.creationAt = creationAt;
            return this;
        }

        public Builder modifyAt(LocalDateTime modifyAt) {
            this.modifyAt = modifyAt;
            return this;
        }

        public Builder active(Boolean active) {
            this.active = active;
            return this;
        }

        public Phonebook build() {
            return new Phonebook(this);
        }
    }

    public Phonebook(Builder builder) {
        this.id = builder.id;
        this.fullname = builder.fullname;
        this.phone = builder.phone;
        this.creationAt = builder.creationAt;
        this.modifyAt = builder.modifyAt;
        this.active = builder.active;
    }

    public Long getId() {
        return this.id;
    }

    public String getFullname() {
        return this.fullname;
    }

    public String getPhone() {
        return this.phone;
    }

    public LocalDateTime getCreationAt() {
        return this.creationAt;
    }

    public LocalDateTime getModifyAt() {
        return this.modifyAt;
    }

    public Boolean getActive() {
        return this.active;
    }
}