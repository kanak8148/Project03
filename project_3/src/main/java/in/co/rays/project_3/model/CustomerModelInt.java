package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.CustomerDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.exception.RecordNotFoundException;

public interface CustomerModelInt {
	public long add(CustomerDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(CustomerDTO dto)throws ApplicationException;
	public void update(CustomerDTO dto)throws ApplicationException,DuplicateRecordException;
	public CustomerDTO findByPK(long pk)throws ApplicationException;
	public CustomerDTO findByLogin(String login)throws ApplicationException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(CustomerDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public List search(CustomerDTO dto)throws ApplicationException;
	public boolean changePassword(long id,String newPassword,String oldPassword)throws ApplicationException, RecordNotFoundException;
	public CustomerDTO authenticate(String login,String password)throws ApplicationException;
	public boolean forgetPassword(String login)throws ApplicationException, RecordNotFoundException;
	public boolean resetPassword(CustomerDTO dto)throws ApplicationException,RecordNotFoundException;
	public long registerUser(CustomerDTO dto)throws ApplicationException,DuplicateRecordException;
	public List getRoles(CustomerDTO dto)throws ApplicationException;

}
