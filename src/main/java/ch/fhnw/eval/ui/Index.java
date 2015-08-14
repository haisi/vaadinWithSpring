package ch.fhnw.eval.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Hasan Kara <hasan.kara@fhnw.ch>
 */
@SpringUI(path = "/ui")
@Theme("valo")
@Title("Market User Interface")
public class Index extends UI {

    @Autowired
    private SpringViewProvider viewProvider;

    private Navigator navigator;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout layout = new VerticalLayout();
        MenuBar menu = new MenuBar();
        Panel panel = new Panel();

        layout.addComponents(menu, panel);
        layout.setSizeFull();

        panel.setSizeFull();
        layout.setExpandRatio(panel, 1);

        navigator = new Navigator(this, panel);
        navigator.addProvider(viewProvider);

        menu.addItem("Dashboard", e -> onDashboardClicked());
        menu.addItem("Customers", e -> onCustomersClicked());

        setContent(layout);

        navigator.navigateTo("dashboard");
    }

    private void onCustomersClicked() {
        navigator.navigateTo("customers");
    }

    private void onDashboardClicked() {
        navigator.navigateTo("dashboard");
    }

}
