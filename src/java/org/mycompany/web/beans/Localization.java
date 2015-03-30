package org.mycompany.web.beans;

import javax.faces.bean.SessionScoped;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Branko
 */
@ManagedBean
@SessionScoped
public class Localization {
    
    private static Map<String, Object> supportedLanguages;
    private String selectedLanguage;
    private Locale validLocalization;
    
    static {
        supportedLanguages = new LinkedHashMap<String, Object>();
        supportedLanguages.put("Hrvatski", new Locale("hr"));
        supportedLanguages.put("English", Locale.ENGLISH);
    }
    
    public Localization() {
        validLocalization =  FacesContext.getCurrentInstance().getViewRoot().getLocale();
        selectedLanguage = validLocalization.getLanguage();
    }

    public Map<String, Object> getSupportedLanguages() {
        return supportedLanguages;
    }

    public void setSupportedLanguages(Map<String, Object> supportedLanguages) {
        Localization.supportedLanguages = supportedLanguages;
    }

    public String getSelectedLanguage() {
        return selectedLanguage;
    }

    public void setSelectedLanguage(String selectedLanguage) {
        this.selectedLanguage = selectedLanguage;
    }

    public Locale getValidLocalization() {
        return validLocalization;
    }

    public void setValidLocalization(Locale validLocalization) {
        this.validLocalization = validLocalization;
    }
    
    public Object selectLanguage() {
        Iterator i = supportedLanguages.keySet().iterator();
        while(i.hasNext()) {
            String key = (String) i.next();
            Locale l = (Locale) supportedLanguages.get(key);
            if (selectedLanguage.compareTo(l.getLanguage()) == 0) {
                FacesContext.getCurrentInstance().getViewRoot().setLocale(l);
                validLocalization = l;
                break;
            }
        }
        return "OK";
    }
    
}
