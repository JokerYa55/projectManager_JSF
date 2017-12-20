/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.project.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import org.jboss.logging.Logger;
import ru.project.beans.Project;

/**
 *
 * @author vasiliy.andricov
 */
@FacesConverter("projectConverter")
public class projectConverter implements Converter{

    private final Logger log = Logger.getLogger(getClass().getName());

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        log.info("getAsObject => " + value);
        if (value != null && value.trim().length() > 0) {
            try {
                //Project service = (Project) fc.getExternalContext().getApplicationMap().get("themeService");
                return null;
                        //service.getThemes().get(Integer.parseInt(value));
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        log.info("getAsString => " );
        if (object != null) {
            return String.valueOf(((Project) object).getId());
        } else {
            return null;
        }
    }
}
