package in.co.rays.project_3.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.co.rays.project_3.dto.StockDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.exception.RecordNotFoundException;
import in.co.rays.project_3.util.HibDataSource;

public class StockModelHibImpl implements StockModelInt {
	public long add(StockDTO dto) throws ApplicationException, DuplicateRecordException {
		Session session = null;
		Transaction tx = null;
//		ProductDTO duplicateCollegeName = fingByName(dto.getProductName());
//		if (duplicateCollegeName != null) {
//			throw new DuplicateRecordException("college name already exist");
//		}
		try {
			session = HibDataSource.getSession();
			tx = session.beginTransaction();
			session.save(dto);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();

			}
			throw new ApplicationException("Exception in college Add " + e.getMessage());
		} finally {
			session.close();
		}
		return dto.getId();
	}

	@Override
	public void delete(StockDTO dto) throws ApplicationException {
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
			throw new ApplicationException("Exception in college Delete" + e.getMessage());
		} finally {
			session.close();
		}

	}

	@Override
	public void update(StockDTO dto) throws ApplicationException, DuplicateRecordException {
		Session session = null;
		Transaction tx = null;

		try {
			session = HibDataSource.getSession();
			tx = session.beginTransaction();
			System.out.println("before update");

			session.saveOrUpdate(dto);
			System.out.println("after update");
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			throw new ApplicationException("Exception in college update" + e.getMessage());
		} finally {
			session.close();
		}

	}

	@Override
	public List list() throws ApplicationException {
		return list(0, 0);
	}

	@Override
	public List list(int pageNo, int pageSize) throws ApplicationException {
		Session session = null;
		List list = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(StockDTO.class);
			if (pageSize > 0) {
				pageNo = ((pageNo - 1) * pageSize) + 1;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);
			}
			list = criteria.list();

		} catch (HibernateException e) {

			throw new ApplicationException("Exception : Exception in  College list");
		} finally {
			session.close();
		}

		return list;
	}

	
	public List search(StockDTO dto) throws ApplicationException {
		return search(dto, 0, 0);

	}

	
	public List search(StockDTO dto, int pageNo, int pageSize) throws ApplicationException {
		Session session = null;
		List list = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(StockDTO.class);
			if (dto.getId() != null && dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));

			}
			/*if (dto.getOrderName() != null && dto.getOrderName().length() > 0) {
				criteria.add(Restrictions.like("orderName", dto.getOrderName() + "%"));
			}
			if (dto.getCategory() != null && dto.getCategory().length() > 0) {
				criteria.add(Restrictions.like("Category", dto.getCategory() + "%"));
				System.out.println("okay done -----"+dto.getCategory());
			}
			if (dto.getPrice() != null && dto.getPrice().length() > 0) {
				criteria.add(Restrictions.like("price", dto.getPrice() + "%"));
			}*/
			if (pageSize > 0) {
				criteria.setFirstResult((pageNo - 1) * pageSize);
				criteria.setMaxResults(pageSize);

			}
			list = criteria.list();
			System.out.println("list ==== > " + list.size());
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new ApplicationException("Exception in college search");
		} finally {
			session.close();
		}
		return list;
	}

	
	public StockDTO findByPK(long pk) throws ApplicationException {
		System.out.println("======" + pk + "----------------------------------");
		Session session = null;
		StockDTO dto = null;
		try {
			session = HibDataSource.getSession();

			dto = (StockDTO) session.get(StockDTO.class, pk);
			System.out.println(dto);
		} catch (HibernateException e) {

			throw new ApplicationException("Exception : Exception in getting course by pk");
		} finally {
			session.close();
		}
		System.out.println("++++" + dto);
		return dto;
	}

	public StockDTO findByLogin(String login) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean changePassword(long id, String newPassword, String oldPassword)
			throws ApplicationException, RecordNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	
	public StockDTO authenticate(String login, String password) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean forgetPassword(String login) throws ApplicationException, RecordNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean resetPassword(StockDTO dto) throws ApplicationException, RecordNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	
	public long registerUser(StockDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public List getRoles(StockDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

}



