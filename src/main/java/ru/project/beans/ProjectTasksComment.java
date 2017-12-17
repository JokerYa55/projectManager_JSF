/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.project.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author vasiliy.andricov
 */

@Entity
@Table(name = "t_project_tasks_comment")
public class ProjectTasksComment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_tasks_comment_id_seq")
    @SequenceGenerator(name = "project_tasks_comment_id_seq", sequenceName = "project_tasks_comment_id_seq", allocationSize = 1)
    private Long id;
    @Column(name = "comment", length = 5000)
    private String comment;
    @ManyToOne
    private ProjectTasks progectTask;

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
        if (!(object instanceof ProjectTasksComment)) {
            return false;
        }
        ProjectTasksComment other = (ProjectTasksComment) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "ProjectTasksComment{" + "id=" + id + '}';
    }

    public ProjectTasks getProgectTask() {
        return progectTask;
    }

    public void setProgectTask(ProjectTasks progectTask) {
        this.progectTask = progectTask;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
