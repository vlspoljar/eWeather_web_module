package org.mycompany.web.beans;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Branko
 */
@ManagedBean
@SessionScoped
public class NewPortfolio {

    /**
     * Creates a new instance of NewPortfolio
     */
    public NewPortfolio() {
    }
    
    
    public void logout() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("user");
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(NewPortfolio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
