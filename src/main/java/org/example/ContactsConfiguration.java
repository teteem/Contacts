package org.example;

//import javax.security.auth.login.Configuration;
import io.dropwizard.Configuration;
import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;
import javax.validation.constraints.NotEmpty;

public class ContactsConfiguration extends Configuration {
   // @NotEmpty
    private String dateFormat;

    public String getDateFormat() {
        return dateFormat;
    }
//    @Override
//    public AppConfigurationEntry[] getAppConfigurationEntry(String name) {
//        return new AppConfigurationEntry[0];
//    }
}
