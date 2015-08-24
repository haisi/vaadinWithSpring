package ch.fhnw.eval.ui;

import ch.fhnw.eval.business.CustomerRepository;
import ch.fhnw.eval.entities.Customer;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
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

        VerticalLayout form = new VerticalLayout();
        lastNameField = new TextField("E.g. hansi");

        Button addButton = new Button("Add", event -> {
            String lastName = lastNameField.getValue();
            String sureName = lastName + "X";

            Customer savedCustomer = repo.save(new Customer(lastName, sureName));
            grid.getContainerDataSource().addItem(savedCustomer);

            Notification.show("Created customer",
                    Notification.Type.HUMANIZED_MESSAGE);
        });

        form.addComponent(new Label("Name"));
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