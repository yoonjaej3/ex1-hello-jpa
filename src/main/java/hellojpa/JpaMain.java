package hellojpa;

import hellojpa.domain.Book;
import hellojpa.domain.Member;
import hellojpa.domain.Order;
import hellojpa.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx=em.getTransaction();
        tx.begin();

        try{
            Member member1 =new Member();
            member1.setUsername("member1");
            em.persist(member1);

            em.flush();
            em.clear();

            Member refMember=em.getReference(Member.class,member1.getId());
            //JPA 표준에는 강체고기화가없다. 하이버네이트 호출로 ...
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
