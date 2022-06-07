package org.example;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.example.repository.ContactsRepository;
import org.example.repository.DummyContactRepository;
import org.example.resource.ContactsResource;

import java.text.SimpleDateFormat;


public class ContactsRunner extends Application<ContactsConfiguration>
{
    public static void main(final String[] args ) throws Exception {
        new ContactsRunner().run(args);
    }

    @Override
    public String getName() {
        return "Contacts";
    }

    @Override
    public void initialize(final Bootstrap<ContactsConfiguration> bootstrap) {
        // TODO: application initialization
    }


    @Override
    public void run(final ContactsConfiguration contactsConfiguration,
                    final Environment environment){
        environment.getObjectMapper().setDateFormat(new SimpleDateFormat(contactsConfiguration.getDateFormat()));

        ContactsRepository repository = new DummyContactRepository();

        ContactsResource contactResource = new ContactsResource(repository);

        environment.jersey().register(contactResource);
    }
}
