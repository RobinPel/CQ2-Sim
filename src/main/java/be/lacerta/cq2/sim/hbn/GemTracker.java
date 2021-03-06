package be.lacerta.cq2.sim.hbn;

// Generated 7-jul-2009 14:07:40 by Hibernate Tools 3.2.4.GA

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 * GemTracker generated by hbm2java
 */
public class GemTracker extends HbnObject implements java.io.Serializable {

	private Integer id;
	private User user;
	private Mage mage;
	private String gem;
	private Integer percentage;
	private Date submitDate;
	private Date expectedEndDate;

	public GemTracker() {
	}

	public GemTracker(User user, Mage mage, Integer percentage,
			Date submitDate, Date expectedEndDate) {
		this.user = user;
		this.mage = mage;
		this.percentage = percentage;
		this.submitDate = submitDate;
		this.expectedEndDate = expectedEndDate;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Mage getMage() {
		return this.mage;
	}

	public void setMage(Mage mage) {
		this.mage = mage;
	}

	public String getGem() {
		return gem;
	}

	public void setGem(String gem) {
		this.gem = gem;
	}

	public Integer getPercentage() {
		return this.percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

	public Date getSubmitDate() {
		return this.submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public Date getExpectedEndDate() {
		return this.expectedEndDate;
	}

	public void setExpectedEndDate(Date expectedEndDate) {
		this.expectedEndDate = expectedEndDate;
	}
	
	public static GemTracker loadByMage(User u, String mage) {
		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			tx = session.getTransaction();
			Criteria c = session.createCriteria(GemTracker.class);
			c.add(Restrictions.eq("user", u));
			c.add(Restrictions.eq("mage", Mage.getOrCreateMage(mage)));
			c.setMaxResults(1);
			return (GemTracker)c.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
		}
		return null;
	}
	
	public static List<GemTracker> getList(User u) {
		Transaction tx = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			tx = session.getTransaction();
			Criteria c = session.createCriteria(GemTracker.class);
			c.add(Restrictions.eq("user", u));
			c.addOrder(Order.asc("expectedEndDate"));
			return c.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null && tx.isActive())
				tx.rollback();
		}
		return null;
	}
}
