package conference;

import conference.Speaker;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by green on 13.09.2015.
 *
 * DAO
 *
 */
@Repository
public class SpeakerRepository {
    @PersistenceContext
    private EntityManager em;

    /unchecked/
    public List<Speaker> findByName(String name){

        Query query = em.createQuery("select s from Speaker as s where s.name=:name");
        return query.setParameter("name", name).getResultList();
    }

    /unchecked/
    public List<Speaker> getAllSpeakers(){ return em.createQuery("from Speaker").getResultList();}

    public  void save(List<Speaker> speakers){

        for (Speaker speaker : speakers){
            em.persist(speaker);}
    }

    public long count() {return (long) em.createQuery("select count (s.name) from Speaker s").getSingleResult()}

    public void deleteAll() {em.createQuery("delete Speaker ").executeUpdate();}

}