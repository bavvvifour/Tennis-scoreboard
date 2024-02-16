package dao;

import entity.Matches;
import entity.Players;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class MatchesDAO {

    public void create(Matches match) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(match);
            transaction.commit();
        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
            e.printStackTrace();
        }
    }
}
