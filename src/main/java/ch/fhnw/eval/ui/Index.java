package ch.fhnw.eval.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * @author Hasan Kara <hasan.kara@fhnw.ch>
 */
@SpringUI(path = "/ui")
@Theme("valo")
@Title("Market User Interface")
public class Index extends UI {



    @Override
    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout layout = new VerticalLayout();
        MenuBar menu = new MenuBar();
        Panel panel = new Panel();

        layout.addComponents(menu, panel);
        layout.setSizeFull();

        panel.setSizeFull();
        layout.setExpandRatio(panel, 1);

        setContent(layout);
    }

}
