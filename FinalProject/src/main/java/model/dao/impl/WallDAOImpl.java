package model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.WallBean;
import model.dao.WallDAO;

@Repository
public class WallDAOImpl implements WallDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<WallBean> selectAll() {
		return this.getSession().createQuery("FROM WallBean", WallBean.class).list();
	}

	@Override
	public WallBean selectById(int id) {
		return this.getSession().get(WallBean.class, id);
	}
	@Override
	public List<WallBean> selectBySrc(String src) {
		return this.getSession().createQuery("From WallBean WHERE photosrc = :src and statu = 'on'", WallBean.class)
				.setParameter("src", src).list();
	}

	@Override
	public List<WallBean> selectNeedPhoto() {
		return this.getSession().createQuery("FROM WallBean Where seq >=: seq and statu = 'on' Order By seq", WallBean.class)
				.setParameter("seq", 0).list();
	}
	
	
	@Override
	public List<WallBean> selectNeedPhoto2() {
		return this.getSession().createQuery("FROM WallBean Where seq < : seq and statu = 'on' ", WallBean.class)
				.setParameter("seq", 0).list();
	}
	
	@Override
	public WallBean insert(WallBean bean) {
		if (bean != null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}


	@Override
	public boolean update(WallBean bean) {
		if (bean != null) {
			WallBean temp = this.getSession().get(WallBean.class, bean.getWallid());
			if (temp != null) {
				try {
					temp.setPhotosrc(bean.getPhotosrc());
					temp.setStatu(bean.getStatu());
					temp.setSeq(bean.getSeq());
					this.getSession().flush();
					return true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	@Override
	public boolean updateSeqBySrc(Integer seq, String src) {
		List<WallBean> result = this.selectBySrc(src);
		if (result != null && !result.isEmpty()) {
			try {
				result.get(0).setSeq(seq);
				this.getSession().flush();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	@Override
	public boolean updateNoSeqBySrc(String src) {
		List<WallBean> result = this.selectBySrc(src);
		if (result != null && !result.isEmpty()) {
			try {
				result.get(0).setSeq(-1);
				this.getSession().flush();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
