/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.project.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vasiliy.andricov
 */
@Entity
@Table(name = "t_projects")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT t FROM Project t order by t.projectName")
    , @NamedQuery(name = "Project.findById", query = "SELECT t FROM Project t WHERE t.id = :id")
})
public class Project implements Serializable {

    @Id
    @Basic
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_id_seq")
    @SequenceGenerator(name = "project_id_seq", sequenceName = "project_id_seq", allocationSize = 1)
    private Long id;
    @NotNull
    @Size(max = 30)
    @Column(name = "project_name", unique = true, length = 30)
    private String projectName;
    @NotNull
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_b;
    @NotNull
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_e;
    @NotNull
    @ManyToOne
    private SprProjectStatus status;

    public Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getDate_b() {
        return date_b;
    }

    public void setDate_b(Date date_b) {
        this.date_b = date_b;
    }

    public Date getDate_e() {
        return date_e;
    }

    public void setDate_e(Date date_e) {
        this.date_e = date_e;
    }

    @Override
    public String toString() {
        return this.projectName;
    }

    public SprProjectStatus getStatus() {
        return status;
    }

    public void setStatus(SprProjectStatus status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Project other = (Project) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    

}
