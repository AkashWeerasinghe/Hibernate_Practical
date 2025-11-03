package lk.jiat.webii.hp;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class Main {

    private static final int SERVER_PORT = 8080;


    public static void main(String[] args) {
        try {
            Tomcat tomcat = new Tomcat();
            tomcat.setPort(SERVER_PORT);
            tomcat.getConnector();
            tomcat.addWebapp("/hibernate_practical", new File("src/main/webapp").getAbsolutePath());
            tomcat.start();
            tomcat.getServer().await();
        }catch (LifecycleException e){
            throw new RuntimeException(e);
        }
    }
}
