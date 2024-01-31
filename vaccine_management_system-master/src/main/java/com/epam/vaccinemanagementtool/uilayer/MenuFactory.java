package com.epam.vaccinemanagementtool.uilayer;

import org.springframework.stereotype.Component;

@Component
public class MenuFactory {
    //@Autowired
    //@Qualifier("registration")
    Menus menu;

    public Menus getMenu() {
        return menu;
    }

    public void setMenu(Menus menu) {
        this.menu = menu;
    }
}

