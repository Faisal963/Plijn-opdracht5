package hu.nl.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hu.nl.hibernate.HibernateUtil;
import hu.nl.hibernate.OV_Chipkaart;

import java.util.List;

public class OV_ChipkaartDao {
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

	public OV_Chipkaart findById(int id) {
		return getCurrentSession().get(OV_Chipkaart.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<OV_Chipkaart> findAll() {
		return (List<OV_Chipkaart>) getCurrentSession().createQuery("from OV_CHIPKAART").list();
	}

	public void save(OV_Chipkaart kaartTabel) {
		getCurrentSession().save(kaartTabel);
	}

	public void update(OV_Chipkaart kaartTabel) {
		getCurrentSession().update(kaartTabel);
	}
	
	public void delete(OV_Chipkaart kaartTabel) {
		getCurrentSession().delete(kaartTabel);
	}

	public void deleteAll() {
		List<OV_Chipkaart> kaarten = findAll();
		for (OV_Chipkaart kaart : kaarten) {
			delete(kaart);
		}
	}
}
