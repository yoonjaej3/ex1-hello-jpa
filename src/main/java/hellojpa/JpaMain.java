package hellojpa;

import hellojpa.domain.Address;
import hellojpa.domain.Book;
import hellojpa.domain.Member;
import hellojpa.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static <Members> void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx=em.getTransaction();
        tx.begin();

        try{
            Address address = new Address("city","street","10000");

            Member member= new Member();
            member.setUsername("member1");
            member.setHomeAddress(address);
            em.persist(member);

            Address copyAddress = new Address(address.getCity(),address.getStreet(),address.getZipcode());

            Member member2= new Member();
            member2.setUsername("member2");
            member2.setHomeAddress(copyAddress);
            em.persist(member2);

            member.getHomeAddress().setCity("newcity");
            tx.commit();
        } catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        } finally{
            em.close();
        }
        emf.close();
    }
}
