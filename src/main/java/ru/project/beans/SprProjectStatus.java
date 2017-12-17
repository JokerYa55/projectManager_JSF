/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.project.beans;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author vasiliy.andricov
 */
@Entity
@Table(name = "t_spr_project_status")
public class SprProjectStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spr_project_status_id_seq")
    @SequenceGenerator(name = "spr_project_status_id_seq", sequenceName = "spr_project_status_id_seq", allocationSize = 1)
    private Long id;
    @NotNull @Size(max = 30)
    @Column(name = "atatus_name", length = 30, unique = true)    
    private String statusName;

    public SprProjectStatus() {
    }

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
        if (!(object instanceof SprProjectStatus)) {
            return false;
        }
        SprProjectStatus other = (SprProjectStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.project.beans.SprProjectStatus[ id=" + id + " ]";
    }

}
