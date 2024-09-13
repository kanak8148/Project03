package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.CartDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.exception.RecordNotFoundException;

public interface CartModelInt {
	
public long add(CartDTO dto)throws ApplicationException,DuplicateRecordException;
public void delete(CartDTO dto)throws ApplicationException;
public void update(CartDTO dto)throws ApplicationException,DuplicateRecordException;
public CartDTO findByPK(long pk)throws ApplicationException;
public CartDTO findByLogin(String login)throws ApplicationException;
public List list()throws ApplicationException;
public List list(int pageNo,int pageSize)throws ApplicationException;
public List search(CartDTO dto,int pageNo,int pageSize)throws ApplicationException;
public List search(CartDTO dto)throws ApplicationException;
public boolean changePassword(long id,String newPassword,String oldPassword)throws ApplicationException, RecordNotFoundException;
public CartDTO authenticate(String login,String password)throws ApplicationException;
public boolean forgetPassword(String login)throws ApplicationException, RecordNotFoundException;
public boolean resetPassword(CartDTO dto)throws ApplicationException,RecordNotFoundException;
public long registerUser(CartDTO dto)throws ApplicationException,DuplicateRecordException;
public List getRoles(CartDTO dto)throws ApplicationException;

}



