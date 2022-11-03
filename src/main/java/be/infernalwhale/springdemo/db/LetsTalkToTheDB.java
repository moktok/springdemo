package be.infernalwhale.springdemo.db;

import be.infernalwhale.springdemo.controller.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Transactional
public class LetsTalkToTheDB {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
    private EntityManager em = emf.createEntityManager();

    EmployeeRepository repository;

    public void method() {
        Employee employee = new Employee();

        try {
            em.getTransaction().begin();
            em.persist(employee);
            em.merge(employee);
            em.remove(employee);
            em.getTransaction().commit();
        } catch (Exception ex) {
            // maybe try to recover before rollbacking (if possible)
            em.getTransaction().rollback();
        }
    }

    public void anotherMethod() {
        Employee emp = em.find(Employee.class, 1);

        // CB == a royal pain in the ass (it's complicated)
        // Queries:
            // JPA Query Language>> JPQL
            //
    }

    public List<Employee> findAllByNameContaining(String partialName) {
        String sql = "SELECT * FROM XYZ WHERE Name LIKE '%" + partialName + "%'";
        EntityManager em = emf.createEntityManager();
        Query q = em.createNativeQuery(sql);
        List<Employee> result = q.getResultList();
        return result;
    }

    @Transactional
    public void test() {
        // Start transaction
        repository.save(new Employee());
        repository.save(new Employee());
        // Commit transaction
    }

    @Transactional
    public void methodA() {

    }

    @Transactional
    public void methodB() {

    }

    @Transactional
    public void methodC() {
        methodA();
        methodB();
    }

}
