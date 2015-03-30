package org.mycompany.web.beans;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.mycompany.ejb.sb.EweatheruserFacade;

/**
 *
 * @author Branko
 */
@ManagedBean
@SessionScoped
public class Login {

    @EJB
    private EweatheruserFacade eweatheruserFacade;

    public String username;
    public String password;

    public Login() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void login() {
        if (eweatheruserFacade.checkUser(username, password).isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Username or password is not valid!"));
        } else {
            try {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", eweatheruserFacade.checkUser(username, password).get(0).getFirstname()+" "+eweatheruserFacade.checkUser(username, password).get(0).getSurname());
                FacesContext.getCurrentInstance().getExternalContext().redirect("portfolioSelection.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
