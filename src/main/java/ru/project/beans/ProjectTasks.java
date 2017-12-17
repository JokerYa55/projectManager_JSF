/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.project.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author vasiliy.andricov
 */
@Entity
@Table(name = "t_project_tasks")
public class ProjectTasks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_tasks_id_seq")
    @SequenceGenerator(name = "project_tasks_id_seq", sequenceName = "project_tasks_id_seq", allocationSize = 1)
    private Long id;
    @Column(name = "task_name", length = 30, nullable = false)
    private String taskName;
    @NotNull
    //@Column(name = "user_created_id")
    @ManyToOne
    Users userCreated;
    //@Column(name = "user_executor_id")
    @ManyToOne
    Users userExecutor;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "date_created")
    Date dateCreated;
    @Column(name = "date_execute")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dateExecute;

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
        if (!(object instanceof ProjectTasks)) {
            return false;
        }
        ProjectTasks other = (ProjectTasks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.project.beans.ProjectTasks[ id=" + id + " ]";
    }

}
