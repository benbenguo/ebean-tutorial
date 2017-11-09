package org.dean.ebean.tutorial.model;

import javax.persistence.*;

@Entity
@Table(name = "e_user")
public class User {
    private String id;
    private String loginName;
    private User crtBy;
    private User updBy;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login_name", nullable = false, length = 50, unique = true)
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @ManyToOne
    @JoinColumn(name = "crt_by", referencedColumnName = "id", nullable = false)
    public User getCrtBy() {
        return crtBy;
    }

    public void setCrtBy(User crtBy) {
        this.crtBy = crtBy;
    }

    @ManyToOne
    @JoinColumn(name = "upd_by", referencedColumnName = "id", nullable = false)
    public User getUpdBy() {
        return updBy;
    }

    public void setUpdBy(User updBy) {
        this.updBy = updBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (loginName != null ? !loginName.equals(user.loginName) : user.loginName != null) return false;
        if (crtBy != null ? !crtBy.equals(user.crtBy) : user.crtBy != null) return false;
        return updBy != null ? updBy.equals(user.updBy) : user.updBy == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (loginName != null ? loginName.hashCode() : 0);
        result = 31 * result + (crtBy != null ? crtBy.hashCode() : 0);
        result = 31 * result + (updBy != null ? updBy.hashCode() : 0);
        return result;
    }
}
