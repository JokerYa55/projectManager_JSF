/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.project.controllers;

import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.jboss.logging.Logger;
import ru.project.DAO.ProjectDAO;
import ru.project.beans.Project;

/**
 *
 * @author vasiliy.andricov
 */
@ManagedBean
@SessionScoped
public class projectController {

    /**
     * Creates a new instance of projectController
     */
    private final Logger log = Logger.getLogger(getClass().getName());
    private HashMap<Long, Project> map = new HashMap();

    public projectController() {
        (new ProjectDAO()).getList("Project.findAll", Project.class).forEach((t) -> {
            map.put(t.getId(), t);
        });
    }

    public List<Project> getProjectList() {
        List<Project> res = null;
        try {
            res = (new ProjectDAO()).getList("Project.findAll", Project.class);
        } catch (Exception e) {
        }
        return res;
    }
;

}
