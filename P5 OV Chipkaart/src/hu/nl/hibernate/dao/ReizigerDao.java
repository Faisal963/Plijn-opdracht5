package hu.nl.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hu.nl.hibernate.HibernateUtil;
import hu.nl.hibernate.Reiziger;

import java.util.List;

public class ReizigerDao {

	private Session currentSession;
	private Transaction currentTransaction;

	public Session openCurrentSession() {
		currentSession = HibernateUtil.getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = HibernateUtil.getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	public void closeCurrentSession() {
		currentSession.close();
	}

	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}
	
	public Reiziger findById(int id) {
		Reiziger reiziger = getCurrentSession().get(Reiziger.class, id);
		return reiziger;
	}

	@SuppressWarnings("unchecked")
	public List<Reiziger> findAll() {
		return (List<Reiziger>) getCurrentSession().createQuery("from REIZIGER").list();
	}

	public void save(Reiziger reizigerTabel) {
		getCurrentSession().save(reizigerTabel);
	}

	public void update(Reiziger reizigerTabel) {
		getCurrentSession().update(reizigerTabel);
	}

	public void delete(Reiziger reizigerTabel) {
		getCurrentSession().delete(reizigerTabel);
	}

	public void deleteAll() {
		List<Reiziger> reizigers = findAll();
		for (Reiziger reiziger : reizigers) {
			delete(reiziger);
		}
	}
}
