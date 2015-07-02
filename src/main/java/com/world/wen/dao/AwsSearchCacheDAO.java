package com.world.wen.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.world.wen.model.AwsSearchCache;

/**
 * A data access object (DAO) providing persistence and search support for
 * AwsSearchCache entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.world.wen.model.AwsSearchCache
 * @author MyEclipse Persistence Tools
 */
public class AwsSearchCacheDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AwsSearchCacheDAO.class);
	// property constants
	public static final String HASH = "hash";
	public static final String DATA = "data";
	public static final String TIME = "time";

	public void save(AwsSearchCache transientInstance) {
		log.debug("saving AwsSearchCache instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AwsSearchCache persistentInstance) {
		log.debug("deleting AwsSearchCache instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AwsSearchCache findById(java.lang.Integer id) {
		log.debug("getting AwsSearchCache instance with id: " + id);
		try {
			AwsSearchCache instance = (AwsSearchCache) getSession().get(
					"com.world.wen.AwsSearchCache", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AwsSearchCache instance) {
		log.debug("finding AwsSearchCache instance by example");
		try {
			List results = getSession()
					.createCriteria("com.world.wen.AwsSearchCache")
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
		log.debug("finding AwsSearchCache instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AwsSearchCache as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByHash(Object hash) {
		return findByProperty(HASH, hash);
	}

	public List findByData(Object data) {
		return findByProperty(DATA, data);
	}

	public List findByTime(Object time) {
		return findByProperty(TIME, time);
	}

	public List findAll() {
		log.debug("finding all AwsSearchCache instances");
		try {
			String queryString = "from AwsSearchCache";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AwsSearchCache merge(AwsSearchCache detachedInstance) {
		log.debug("merging AwsSearchCache instance");
		try {
			AwsSearchCache result = (AwsSearchCache) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AwsSearchCache instance) {
		log.debug("attaching dirty AwsSearchCache instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AwsSearchCache instance) {
		log.debug("attaching clean AwsSearchCache instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}