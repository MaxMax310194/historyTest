package daoImpl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import dao.daoUser;
import model.UserHib;


@Repository
@Transactional
public class DaoImplUser implements daoUser {
	
	
	Session session = null;
	Transaction transaction = null;
	List<UserHib>users = new ArrayList<>();
	
	SessionFactory sf;
	public DaoImplUser(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	@Override
	public List<UserHib> getAllUser() {
		session=sf.openSession();
		transaction=session.beginTransaction();
		CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
		CriteriaQuery<UserHib>query=criteriaBuilder.createQuery(UserHib.class);
		Root<UserHib>root=query.from(UserHib.class);
		query.select(root);
		Query<UserHib>resQuery=session.createQuery(query);
		users.clear();
		users=resQuery.getResultList();
		transaction.commit();
		return users;
	}

	@Override
	public void addUser(UserHib user) {
		session=sf.openSession();
		transaction=session.beginTransaction();
		session.save(user);
		transaction.commit();
		

	}

	@Override
	public void delUser(UserHib user) {
		session=sf.openSession();
		transaction=session.beginTransaction();
		session.delete(user);
		transaction.commit();

	}

	@Override
	public void upUser(UserHib user) {
		session=sf.openSession();
		transaction=session.beginTransaction();
		session.update(user);
		transaction.commit();


	}

	@Override
	public UserHib getUserByName(String name) {
	
		session=sf.openSession();
		transaction=session.beginTransaction();
		CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
		CriteriaQuery<UserHib>query=criteriaBuilder.createQuery(UserHib.class);
		Root<UserHib>root=query.from(UserHib.class);
		query.select(root).where(criteriaBuilder.equal(root.get("name"), name));
		Query<UserHib>resQuery=session.createQuery(query);
		users.clear();
		users=resQuery.getResultList();
		transaction.commit();
		if (users.size()!=0) {
			return users.get(0);
		}else {
			return null;
		}
	}

	@Override
	public UserHib getUserByNameAndPassword(String name, String password) {
		session=sf.openSession();
		transaction=session.beginTransaction();
		CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
		CriteriaQuery<UserHib>query=criteriaBuilder.createQuery(UserHib.class);
		Root<UserHib>root=query.from(UserHib.class);
		query.select(root).where(criteriaBuilder.equal(root.get("name"), name)).where(criteriaBuilder.equal(root.get("password"),password));
		Query<UserHib>resQuery=session.createQuery(query);
		users.clear();
		users=resQuery.getResultList();
		transaction.commit();
		session.close();
		if (users.size()!=0) {
			return users.get(0);
		}else {
			return null;
		}
	}

}
