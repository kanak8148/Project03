package in.co.rays.project_3.model;

import java.util.List;

import in.co.rays.project_3.dto.StockDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.exception.RecordNotFoundException;

public interface StockModelInt {
	public long add(StockDTO dto)throws ApplicationException,DuplicateRecordException;
	public void delete(StockDTO dto)throws ApplicationException;
	public void update(StockDTO dto)throws ApplicationException,DuplicateRecordException;
	public StockDTO findByPK(long pk)throws ApplicationException;
	public StockDTO findByLogin(String login)throws ApplicationException;
	public List list()throws ApplicationException;
	public List list(int pageNo,int pageSize)throws ApplicationException;
	public List search(StockDTO dto,int pageNo,int pageSize)throws ApplicationException;
	public List search(StockDTO dto)throws ApplicationException;
	public boolean changePassword(long id,String newPassword,String oldPassword)throws ApplicationException, RecordNotFoundException;
	public StockDTO authenticate(String login,String password)throws ApplicationException;
	public boolean forgetPassword(String login)throws ApplicationException, RecordNotFoundException;
	public boolean resetPassword(StockDTO dto)throws ApplicationException,RecordNotFoundException;
	public long registerUser(StockDTO dto)throws ApplicationException,DuplicateRecordException;
	public List getRoles(StockDTO dto)throws ApplicationException;

}
