package ru.inbox.savinov_vu.service.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.entity.User;
import ru.inbox.savinov_vu.config.HibernateUtil;

import ru.inbox.savinov_vu.service.DAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skorpion on 19.07.16.
 */
@Service
public class UserServiceImpl implements DAO {

    private final int NUMBER_USERS_ON_PAGE = 20;
    private List<User> list = new ArrayList<>();

    public int countPages() {
        if ((list.size() % NUMBER_USERS_ON_PAGE) == 0) {
            return list.size() / NUMBER_USERS_ON_PAGE;
        } else
            return (list.size() / NUMBER_USERS_ON_PAGE) + 1;
    }


    @Override
    public User getById(int id) {
        Session session = HibernateUtil.getSingletonSession();
        session.beginTransaction();
        User user = (User) session.load(User.class, id);
        session.getTransaction().commit();
        List<User> list = new ArrayList<>();
        list.add(user);
        return user;
    }


    @Override
    public void addUser(User user) {
        Session session = HibernateUtil.getSingletonSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        User user = getById(id);
        Session session = HibernateUtil.getSingletonSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
    }


    @Override
    public List<User> getByName(String name, int numberOfPage) {


        Session session = HibernateUtil.getSingletonSession();
        session.beginTransaction();
        Criteria userCriteria = session.createCriteria(User.class);
        userCriteria.add(Restrictions.eq("name", name));
        list = userCriteria.list();
        session.getTransaction().commit();
        return getListforPagingMapping(numberOfPage, list);


    }

    @Override
    public void editUser(User user) {
        Session session = HibernateUtil.getSingletonSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }


    @Override
    public List<User> getAll(int numberOfPage) {

        Session session = HibernateUtil.getSingletonSession();
        session.beginTransaction();
        list = session.createQuery("from User").list();
        session.getTransaction().commit();
        return getListforPagingMapping(numberOfPage, list);

    }

    /* формирования листа для отображения пользователей на странице с пейджингом*/
    private List<User> getListforPagingMapping(int numberOfPage, List<User> allUsers) {
        int startNumber = (numberOfPage * NUMBER_USERS_ON_PAGE) - NUMBER_USERS_ON_PAGE;
        int endNumber = (numberOfPage * NUMBER_USERS_ON_PAGE);
        ArrayList<User> resultList = new ArrayList<>();


        for (int i = startNumber; i < endNumber; i++) {
            if (i < allUsers.size()) {
                resultList.add(allUsers.get(i));
            }


        }
        return resultList;

    }

}