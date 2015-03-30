package org.mycompany.web.beans;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Size;
import org.mycompany.ejb.eb.Eweatheruser;
import org.mycompany.ejb.eb.Usertype;
import org.mycompany.ejb.sb.EweatheruserFacade;
import org.mycompany.ejb.sb.UsertypeFacade;

/**
 *
 * @author Branko
 */
@ManagedBean
@SessionScoped
public class Registration { 
    @EJB
    private EweatheruserFacade eweatheruserFacade;
    @EJB
    private UsertypeFacade usertypeFacade;

    @Size(min = 2, max = 25)
    public String firstname;

    @Size(min = 2, max = 25)
    public String surname;

    @Size(min = 2, max = 25)
    public String username;

    @Size(min = 8, max = 25)
    public String password;

    @Size(min = 8, max = 25)
    public String repeatedPassword;

    @Size(min = 10, max = 25)
    public String email;

    public String gender;

    public String dateOfBirth;

    public Registration() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void saveUser() {
        Usertype ut = usertypeFacade.getUsertype(2);
        //System.out.println(Integer.SIZE + "," + firstname + "," + surname + "," + username + "," + password + "," + email + "," + gender + "," + dateOfBirth + "," + ut.getDescription());
        Eweatheruser ewu = new Eweatheruser(Integer.SIZE, firstname, surname, username, password, email, gender, dateOfBirth);
        ewu.setIdtype(ut);
        eweatheruserFacade.registerUser(ewu);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
