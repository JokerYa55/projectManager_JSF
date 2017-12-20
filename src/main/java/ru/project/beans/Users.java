/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.project.beans;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.jboss.logging.Logger;
import static ru.project.util.hashUtil.encodeToHex;
import static ru.project.util.hashUtil.sha1;

/**
 *
 * @author vasiliy.andricov
 */
@Entity
@Table(name = "t_spr_users")
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT t FROM Users t order by t.name")
    , @NamedQuery(name = "Users.findById", query = "SELECT t FROM Users t WHERE t.id = :id")
})
public class Users implements Serializable {

    private Logger log = Logger.getLogger(getClass().getName());
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spr_users_id_seq")
    @SequenceGenerator(name = "spr_users_id_seq", sequenceName = "spr_users_id_seq", allocationSize = 1)
    private Long id;
    @Column(name = "name", length = 50, unique = true, nullable = false)
    private String name;
    @Column(name = "password", length = 100, nullable = false)
    private String password;
    @Column(name = "salt", length = 100, nullable = false)
    private String salt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.project.beans.Users[ id=" + id + " ]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.salt = encodeToHex(UUID.randomUUID().toString().getBytes());
        this.password = encodeToHex(sha1(password + this.salt));
        log.info("password => " + this.password);
    }

    public String getSalt() {
        return salt;
    }

}
