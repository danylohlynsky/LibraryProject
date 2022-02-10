package com.group4;

import com.group4.config.SpringConfig;
import com.group4.model.Role;
import com.group4.service.impl.RoleInterface;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main {
    private final RoleInterface roleInterface;

    public Main(RoleInterface roleInterface) {
        this.roleInterface = roleInterface;
    }

    public void init() {
        Role role = new Role();
        role.setRole_name("Manager");
        roleInterface.save(role);
        role.setRole_name("User");
        roleInterface.update(role);

    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Main main = context.getBean("main", Main.class);
        main.init();
        context.close();
    }
}
