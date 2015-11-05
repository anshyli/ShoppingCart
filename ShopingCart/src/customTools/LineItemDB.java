package customTools;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.*;

public class LineItemDB {

	public static void insert(Lineitem item) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(item);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void update(Lineitem item) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(item);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static void delete(Lineitem item) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(item));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
    //may not need this one
	public static List<Lineitem> getCartItems(int cartId) {  //cart id is actually shopper id
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		List<Lineitem> tList = new ArrayList<Lineitem>();
		String qString = "select e from Lineitem e where e.shopper_id = :cartId";
		TypedQuery<Lineitem> q = (TypedQuery<Lineitem>) em.createQuery(qString, Lineitem.class);
		List<Lineitem> items = null;
		try {
			items = q.getResultList();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
		return items;
	}
	
	public static Lineitem selectLineitem(int lineitemId) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		String qString = "select e from Lineitem e where e.id = :lineitemId";
		TypedQuery<Lineitem> q = (TypedQuery<Lineitem>) em.createQuery(qString, Lineitem.class);
		Lineitem item = null;
		try {
			item = q.getSingleResult();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
		return item;
	}

}
