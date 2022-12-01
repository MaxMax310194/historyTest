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
import dao.daoTest;
import model.Test;



@Repository
@Transactional
public class DaoImplTest implements daoTest {

	Session session = null;
	Transaction transaction = null;
	List<Test>tests = new ArrayList<>();
	
	SessionFactory sf;
	
	public DaoImplTest(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	@Override
	public List<Test> getAllTest() {
		session=sf.openSession();
		transaction=session.beginTransaction();
		CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
		CriteriaQuery<Test>query=criteriaBuilder.createQuery(Test.class);
		Root<Test>root=query.from(Test.class);
		query.select(root);
		Query<Test>resQuery=session.createQuery(query);
		tests.clear();
		tests=resQuery.getResultList();
		transaction.commit();
		return tests;
	}

	@Override
	public void addTest(Test test) {
		session=sf.openSession();
		transaction=session.beginTransaction();
		session.save(test);
		transaction.commit();

	}

	@Override
	public void delTest(Test test) {
		session=sf.openSession();
		transaction=session.beginTransaction();
		session.delete(test);
		transaction.commit();

	}

	@Override
	public void upTest(Test test) {
		session=sf.openSession();
		transaction=session.beginTransaction();
		session.update(test);
		transaction.commit();

	}

	@Override
	public Test getTestByQuestion(String question) {
		session=sf.openSession();
		transaction=session.beginTransaction();
		CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
		CriteriaQuery<Test>query=criteriaBuilder.createQuery(Test.class);
		Root<Test>root=query.from(Test.class);
		query.select(root).where(criteriaBuilder.equal(root.get("questions"), question));
		Query<Test>resQuery=session.createQuery(query);
		tests.clear();
		tests=resQuery.getResultList();
		transaction.commit();
		if (tests.size()!=0) {
			return tests.get(0);
		}else {
			return null;
		}
	}

}
