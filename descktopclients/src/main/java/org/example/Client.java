package org.example;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class Client {
    public static void main(String[] args) {
        try {
            // Set JNDI properties
            Properties props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
            props.put(Context.PROVIDER_URL, "remote://localhost:8080/");
            props.put(Context.SECURITY_PRINCIPAL, "alpha");
            props.put(Context.SECURITY_CREDENTIALS, "Jawda123@");

            // Create the initial context
            Context context = new InitialContext(props);
            InterfaceAdmin helloService = (InterfaceAdmin) context.lookup("java:global/EJBbackend/InterfaceAdminBean!org.example.InterfaceAdmin");

            String response = helloService.sayHello("World");
            System.out.println(response);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }}