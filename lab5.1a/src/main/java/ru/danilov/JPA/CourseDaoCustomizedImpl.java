package ru.danilov.JPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collections;
import java.util.List;



public class CourseDaoCustomizedImpl implements CourseDaoCustomized {


    @PersistenceContext
    private EntityManager entityManager;

    private static double average(List<Integer> m) {
        int summa = 0;
        for (int i = 0; i < m.size(); i++)
            summa += m.get(i);
        return (double)summa / m.size();
    }

    // O(n^2)
    private static double mediana(List<Integer> m) {
        Collections.sort(m);
        if (m.size() % 2 == 1)
            return m.get(m.size() / 2);
        else
            return (m.get(m.size() / 2) + m.get(m.size() / 2-1)) / 2.0;
    }

    //get all lengths and collect it to array
    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public double medianaLength() {
        return mediana(entityManager.createQuery("SELECT c.length FROM Course c").getResultList());
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public double averageLength() {
        return (double)entityManager.createQuery("SELECT AVG(c.length) FROM Course c").getResultList().get(0);
       // return average(entityManager.createQuery("SELECT c.length FROM Course c").getResultList());
    }

    @Override
    @Transactional(readOnly = true)
    public medianaAverage getMedianaAverage() {
        return new medianaAverage(medianaLength(), averageLength());
    }

    public record medianaAverage(double mediana, double average) {

        @Override
        public String toString() {
            return "mediana: " + mediana + ", average: " + average;
        }
    }
}
