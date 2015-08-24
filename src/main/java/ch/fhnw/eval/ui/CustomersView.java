package ch.fhnw.eval.ui;

import ch.fhnw.eval.business.CustomerRepository;
import ch.fhnw.eval.entities.Customer;
import com.vaadin.data.Validator;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.validator.NullValidator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * @author Hasan Kara <hasan.kara@fhnw.ch>
 */
@SpringView(name = "customers")
public class CustomersView  extends VerticalLayout implements View {

    @Autowired
    private CustomerRepository repo;

    private Grid grid;
    private TextField lastNameField;

    @PostConstruct
    protected void initialize() {
        setSizeFull();

        HorizontalSplitPanel layout = new HorizontalSplitPanel();
        layout.setSizeFull();

        grid = new Grid();
        grid.setSizeFull();

        grid.addColumn("lastName", String.class);
        grid.addColumn("sureName", String.class);

        FormLayout form = new FormLayout();
        form.setSizeUndefined();
        form.setCaption("Creating new customer");

        lastNameField = new TextField("Last name");
        lastNameField.setIcon(FontAwesome.USER);
        lastNameField.setImmediate(true);
        lastNameField.setRequired(true);
        lastNameField.setRequiredError("Is required");
        lastNameField.addValidator(new NullValidator("Must be given", false));

        Button addButton = new Button("Add", event -> {

            try {
                lastNameField.validate();
            } catch (Validator.InvalidValueException ex) {
                lastNameField.setValidationVisible(true);
                Notification.show("Invalid value!");
                return;
            }

            String lastName = lastNameField.getValue();
            String sureName = lastName + "X";

            Customer savedCustomer = repo.save(new Customer(lastName, sureName));
            grid.getContainerDataSource().addItem(savedCustomer);

            Notification.show("Created customer",
                    Notification.Type.HUMANIZED_MESSAGE);
        });

        form.addComponents(lastNameField);
        form.addComponents(addButton);

        layout.addComponents(grid, form);

        addComponent(layout);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        grid.setContainerDataSource(new BeanItemContainer<Customer>(Customer.class, repo.findAll()));
    }
}