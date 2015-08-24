package ch.fhnw.eval.ui;

import ch.fhnw.eval.business.CustomerRepository;
import ch.fhnw.eval.entities.Customer;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
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

    @PostConstruct
    protected void initialize() {
        setSizeFull();

        grid = new Grid();
        grid.setSizeFull();

        grid.addColumn("lastName", String.class);
        grid.addColumn("sureName", String.class);

        addComponent(grid);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        grid.setContainerDataSource(new BeanItemContainer<Customer>(Customer.class, repo.findAll()));
    }
}