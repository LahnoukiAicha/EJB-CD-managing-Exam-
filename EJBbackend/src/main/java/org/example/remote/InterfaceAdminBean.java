package org.example.remote;


import org.example.CD;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateful
@LocalBean
public class InterfaceAdminBean implements InterfaceAdmin{

    @PersistenceContext(unitName = "cd")
    private EntityManager entityManager;
    @Override
    public String sayHello() {
        return "hello from server admin";
    }

    @Override
    public CD saveCD(CD cd) {
        entityManager.persist(cd);
        return cd;
    }

    @Override
    public List<CD> retrieveAllCDs() {
        return null;
    }

    @Override
    public CD findCD(CD project) {
        CD p = entityManager.find(CD.class, project.getId());
        return p;
    }

    @Override
    public CD update(CD project) {
        return null;
    }

    @Override
    public void delete(CD project) {
        entityManager.remove(entityManager.merge(project));
        entityManager.flush();

    }
}
