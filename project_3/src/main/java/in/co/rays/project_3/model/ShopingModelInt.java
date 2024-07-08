package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.ShopingDTO;
import in.co.rays.project_3.dto.UserDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.exception.RecordNotFoundException;

public interface ShopingModelInt {
	
		public long add(ShopingDTO dto)throws ApplicationException,DuplicateRecordException;
		public void delete(ShopingDTO dto)throws ApplicationException;
		public void update(ShopingDTO dto)throws ApplicationException,DuplicateRecordException;
		public ShopingDTO findByPK(long pk)throws ApplicationException;
		public ShopingDTO findByLogin(String login)throws ApplicationException;
		public List list()throws ApplicationException;
		public List list(int pageNo,int pageSize)throws ApplicationException;
		public List search(ShopingDTO dto,int pageNo,int pageSize)throws ApplicationException;
		public List search(ShopingDTO dto)throws ApplicationException;
		public boolean changePassword(long id,String newPassword,String oldPassword)throws ApplicationException, RecordNotFoundException;
		public  ShopingDTO  authenticate(String login,String password)throws ApplicationException;
		public boolean forgetPassword(String login)throws ApplicationException, RecordNotFoundException;
		public boolean resetPassword( ShopingDTO  dto)throws ApplicationException,RecordNotFoundException;
		public long registerUser(ShopingDTO dto)throws ApplicationException,DuplicateRecordException;
		public List getRoles(ShopingDTO dto)throws ApplicationException;

}
