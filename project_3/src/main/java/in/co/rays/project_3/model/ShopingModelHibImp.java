package in.co.rays.project_3.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.co.rays.project_3.dto.ShopingDTO;
import in.co.rays.project_3.dto.UserDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.exception.RecordNotFoundException;
import in.co.rays.project_3.util.HibDataSource;

public class ShopingModelHibImp implements ShopingModelInt {

	@Override
	public long add(ShopingDTO dto) throws ApplicationException, DuplicateRecordException {

		ShopingDTO existDto = null;
		existDto = findByLogin(dto.getLogin());
		if (existDto != null) {
			throw new DuplicateRecordException("login id already exist");
		}
		Session session = HibDataSource.getSession();
		Transaction tx = null;
		try {

			int pk = 0;
			tx = session.beginTransaction();

			System.out.println("trac1");
			session.save(dto);
			System.out.println("trac2");
			tx.commit();
			System.out.println("trac3");
		} catch (HibernateException e) {
			e.printStackTrace();
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();

			}
			throw new ApplicationException("Exception in User Add " + e.getMessage());
		} finally {
			session.close();
		}
		/* log.debug("Model add End"); */
		return dto.getId();

	}

	@Override
	public void delete(ShopingDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		try {
			session = HibDataSource.getSession();
			tx = session.beginTransaction();
			session.delete(dto);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new ApplicationException("Exception in User Delete" + e.getMessage());
		} finally {
			session.close();
		}

	}

	@Override
	public void update(ShopingDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction tx = null;
		ShopingDTO existDto = findByLogin(dto.getLogin());
		// Check if updated LoginId already exist
		if (existDto != null && existDto.getId() != dto.getId()) {
			// throw new DuplicateRecordException("LoginId is already exist");
		}

		try {
			session = HibDataSource.getSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(dto);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new ApplicationException("Exception in User update" + e.getMessage());
		} finally {
			session.close();
		}

	}

	@Override
	public ShopingDTO findByPK(long pk) throws ApplicationException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		Session session = null;
		ShopingDTO dto = null;
		try {
			session = HibDataSource.getSession();
			dto = (ShopingDTO) session.get(UserDTO.class, pk);

		} catch (HibernateException e) {
			throw new ApplicationException("Exception : Exception in getting User by pk");
		} finally {
			session.close();

			return dto;

		}
	}

	@Override
	public ShopingDTO findByLogin(String login) throws ApplicationException {
		Session session = null;
		ShopingDTO dto = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(ShopingDTO.class);
			criteria.add(Restrictions.eq("login", login));
			List list = criteria.list();
			if (list.size() == 1) {
				dto = (ShopingDTO) list.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("application>>>>>>>>>>>>");
			throw new ApplicationException("Exception in getting User by Login " + e.getMessage());

		} finally {
			session.close();
		}

		return dto;
	}

	@Override
	public List list() throws ApplicationException {
		// TODO Auto-generated method stub
		return list(0, 0);
	}

	@Override
	public List list(int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List search(ShopingDTO dto, int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List search(ShopingDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean changePassword(long id, String newPassword, String oldPassword)
			throws ApplicationException, RecordNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ShopingDTO authenticate(String login, String password) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean forgetPassword(String login) throws ApplicationException, RecordNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean resetPassword(ShopingDTO dto) throws ApplicationException, RecordNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long registerUser(ShopingDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List getRoles(ShopingDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

}
