package ImageHoster.repository;

import ImageHoster.model.Comments;
import ImageHoster.model.Image;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class CommentsRepository {

    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;

    public void writecomment(Comments comment) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        System.out.println(comment);
        try {
            transaction.begin();
            em.persist(comment);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Exception occured");
            transaction.rollback();
        }
    }

    public List<Comments> getComment(Image image) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Comments> typedQuery = em.createQuery("SELECT C from Comments C where C.image =:image", Comments.class).setParameter("image", image);
            return typedQuery.getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public void deleteComments(List<Comments> comments) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        for (Comments comment : comments) {
            try {
                transaction.begin();
                Comments oneComment = em.find(Comments.class, comment.getId());
                em.remove(oneComment);
                transaction.commit();
            } catch (Exception e) {
                System.out.println("error occured in comment repository" + e);
                transaction.rollback();

            }
        }
    }
}
