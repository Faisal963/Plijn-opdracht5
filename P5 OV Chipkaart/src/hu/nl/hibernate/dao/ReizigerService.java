package hu.nl.hibernate.dao;

import java.util.List;
import hu.nl.hibernate.Reiziger;

public class ReizigerService {
    private static ReizigerService reizigerService;
    private ReizigerDao reizigerDao;

    public static ReizigerService getInstance() {
        if (reizigerService == null)
            reizigerService = new ReizigerService();
        return reizigerService;
    }

    public ReizigerService() {
        reizigerDao = new ReizigerDao();
    }

    public Reiziger findById(int id) {
        reizigerDao.openCurrentSession();
        Reiziger reiziger = reizigerDao.findById(id);
        if (reiziger == null) {
        	System.out.print("\nReiziger nummer " + id + " is niet gevonden.");
        } else {
        	System.out.print("\nReiziger nummer " + id + " is gevonden.");
        }
        reizigerDao.closeCurrentSession();
        return reiziger;
    }

    public List<Reiziger> findAll() {
        reizigerDao.openCurrentSession();
        List<Reiziger> reizigers = reizigerDao.findAll();
        reizigerDao.closeCurrentSession();
        return reizigers;
    }

    public void save(Reiziger reizigerTabel) {
        reizigerDao.openCurrentSessionwithTransaction();
        reizigerDao.save(reizigerTabel);
        reizigerDao.closeCurrentSessionwithTransaction();
        System.out.print("\nReiziger is opgeslagen.");
    }

    public void update(Reiziger reizigerTabel) {
        reizigerDao.openCurrentSessionwithTransaction();
        reizigerDao.update(reizigerTabel);
        reizigerDao.closeCurrentSessionwithTransaction();
        System.out.print("\nReiziger is gewijzigd.");
    }

    public void delete(int id) {
        reizigerDao.openCurrentSessionwithTransaction();
        Reiziger reiziger = reizigerDao.findById(id);
        reizigerDao.delete(reiziger);
        reizigerDao.closeCurrentSessionwithTransaction();
        System.out.print("\nReiziger is verwijderd.");
    }

    public void delete(Reiziger reiziger) {
        reizigerDao.openCurrentSessionwithTransaction();
        reizigerDao.delete(reiziger);
        reizigerDao.closeCurrentSessionwithTransaction();
        System.out.print("\nReiziger is verwijderd.");
    }

    public void deleteAll() {
        reizigerDao.openCurrentSessionwithTransaction();
        reizigerDao.deleteAll();
        reizigerDao.closeCurrentSessionwithTransaction();
    }

    public ReizigerDao getReizigerDao() {
        return reizigerDao;
    }
}
