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
//            Team team=new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member= new Member();
//            member.setUsername("member1");
//
//            team.getMembers().add(member);
//            member.setTeam(team);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//            Member findMember=em.find(Member.class,member.getId());
//
//            Team findTeam=findMember.getTeam();
//            System.out.println("findTeam=" + findTeam.getName());

            Book book=new Book();
            book.setName("JPA");
            book.setAuthor("김영한");

            em.persist(book);
            tx.commit();
        } catch(Exception e){
            tx.rollback();
        } finally{
            em.close();
        }
        emf.close();
    }
}
