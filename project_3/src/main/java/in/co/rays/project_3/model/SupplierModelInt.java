package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.SupplierDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.exception.RecordNotFoundException;

public interface SupplierModelInt  {
	
public long add(SupplierDTO dto)throws ApplicationException,DuplicateRecordException;
public void delete(SupplierDTO dto)throws ApplicationException;
public void update(SupplierDTO dto)throws ApplicationException,DuplicateRecordException;
public SupplierDTO findByPK(long pk)throws ApplicationException;
public SupplierDTO findByLogin(String login)throws ApplicationException;
public List list()throws ApplicationException;
public List list(int pageNo,int pageSize)throws ApplicationException;
public List search(SupplierDTO dto,int pageNo,int pageSize)throws ApplicationException;
public List search(SupplierDTO dto)throws ApplicationException;
public boolean changePassword(long id,String newPassword,String oldPassword)throws ApplicationException, RecordNotFoundException;
public SupplierDTO authenticate(String login,String password)throws ApplicationException;
public boolean forgetPassword(String login)throws ApplicationException, RecordNotFoundException;
public boolean resetPassword(SupplierDTO dto)throws ApplicationException,RecordNotFoundException;
public long registerUser(SupplierDTO dto)throws ApplicationException,DuplicateRecordException;
public List getRoles(SupplierDTO dto)throws ApplicationException;


}
