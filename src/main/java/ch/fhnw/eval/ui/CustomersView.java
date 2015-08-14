package ch.fhnw.eval.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * @author Hasan Kara <hasan.kara@fhnw.ch>
 */
@SpringView(name = "customers")
public class CustomersView  extends VerticalLayout implements View {

    @PostConstruct
    protected void initialize() {
        addComponent(new Label("Customers"));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }
}