package org.socialnetworking.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.socialnetworking.dao.IUserDAO;
import org.socialnetworking.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDAO")
@Transactional
@EnableTransactionManagement
public class UserDAOImpl implements IUserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public List<User> getAllUsers() {
		return sessionFactory.getCurrentSession().createQuery("FROM User", User.class).getResultList();
	}
	
	public List<User> getDUsers() {
		return sessionFactory.getCurrentSession().createQuery("FROM User u where u.isOnline='false'", User.class).getResultList();
	}
	
	public List<User> getAUsers() {
		return sessionFactory.getCurrentSession().createQuery("FROM User u where u.isOnline='true'", User.class).getResultList();
	}

	public User getUser(int id) {
		return sessionFactory.getCurrentSession().get(User.class, Integer.valueOf(id));
	}

	public boolean updateUser(User u) {
		try {
			sessionFactory.getCurrentSession().update(u);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean deleteUser(int id) {
		try {
			sessionFactory.getCurrentSession().delete(getUser(id));
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean addUser(User u) {
		try {
			sessionFactory.getCurrentSession().persist(u);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public User getUserByUserName(String userName) {
		String selectUser = "from User where userName=:userName";
		return (User) sessionFactory.getCurrentSession().createQuery(selectUser, User.class)
				.setParameter("userName", userName).getSingleResult();
	}

	@Override
	public boolean activateUser(int id) {
		try {
			User user=getUser(id);
			user.setIsOnline("true");
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

}
