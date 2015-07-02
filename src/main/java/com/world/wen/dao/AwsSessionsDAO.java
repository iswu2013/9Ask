package com.world.wen.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.world.wen.model.AwsSessions;

/**
 * A data access object (DAO) providing persistence and search support for
 * AwsSessions entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.world.wen.model.AwsSessions
 * @author MyEclipse Persistence Tools
 */
public class AwsSessionsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AwsSessionsDAO.class);
	// property constants
	public static final String MODIFIED = "modified";
	public static final String DATA = "data";
	public static final String LIFETIME = "lifetime";

	public void save(AwsSessions transientInstance) {
		log.debug("saving AwsSessions instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AwsSessions persistentInstance) {
		log.debug("deleting AwsSessions instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AwsSessions findById(java.lang.String id) {
		log.debug("getting AwsSessions instance with id: " + id);
		try {
			AwsSessions instance = (AwsSessions) getSession().get(
					"com.world.wen.AwsSessions", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AwsSessions instance) {
		log.debug("finding AwsSessions instance by example");
		try {
			List results = getSession()
					.createCriteria("com.world.wen.AwsSessions")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding AwsSessions instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from AwsSessions as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByModified(Object modified) {
		return findByProperty(MODIFIED, modified);
	}

	public List findByData(Object data) {
		return findByProperty(DATA, data);
	}

	public List findByLifetime(Object lifetime) {
		return findByProperty(LIFETIME, lifetime);
	}

	public List findAll() {
		log.debug("finding all AwsSessions instances");
		try {
			String queryString = "from AwsSessions";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AwsSessions merge(AwsSessions detachedInstance) {
		log.debug("merging AwsSessions instance");
		try {
			AwsSessions result = (AwsSessions) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AwsSessions instance) {
		log.debug("attaching dirty AwsSessions instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AwsSessions instance) {
		log.debug("attaching clean AwsSessions instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}