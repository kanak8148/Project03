package in.co.rays.project_3.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.project_3.dto.BaseDTO;
import in.co.rays.project_3.dto.CustomerDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.model.CustomerModelInt;
import in.co.rays.project_3.model.ModelFactory;
import in.co.rays.project_3.model.RoleModelInt;
import in.co.rays.project_3.util.DataUtility;
import in.co.rays.project_3.util.PropertyReader;
import in.co.rays.project_3.util.ServletUtility;

@WebServlet(name = "CustomerListCtl", urlPatterns = { "/ctl/CustomerListCtl" })

public class CustomerListCtl extends BaseCtl {
	
	protected void preload(HttpServletRequest request) {

		CustomerModelInt model = ModelFactory.getInstance().getCustomerModel();

		Map<Integer, String> map = new HashMap<Integer, String>();

		map.put(1, "High");
		map.put(2, "Medium");
		map.put(3, "Low");

		request.setAttribute("prolist", map);

	}

	

	@Override
	protected BaseDTO populateDTO(HttpServletRequest request) {
		CustomerDTO dto = new CustomerDTO();
		dto.setClintName(request.getParameter("clintName"));
		dto.setLocation(request.getParameter("location"));
		dto.setContactNumber(DataUtility.getLong(request.getParameter("contactNumber")));
		dto.setImportance(request.getParameter("importance"));
		populateBean(dto, request);
		return dto;
	}

	/**
	 * Contains Display logics
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List list;
		List next;
		int pageNo = 1;
		int pageSize = DataUtility.getInt(PropertyReader.getValue("page.size"));
		System.out.println("==========" + pageSize);
		CustomerDTO dto = (CustomerDTO) populateDTO(request);
		// get the selected checkbox ids array for delete list
		CustomerModelInt model = ModelFactory.getInstance().getCustomerModel();
		try {
			System.out.println("in ctllllllllll search");
			list = model.search(dto, pageNo, pageSize);

			ArrayList<CustomerDTO> a = (ArrayList<CustomerDTO>) list;

			for (CustomerDTO udto1 : a) {
			}

			System.out.println(list + "----------------------------------------------------------");
			System.out.println(list.indexOf(3));
			next = model.search(dto, pageNo + 1, pageSize);
			ServletUtility.setList(list, request);
			if (list == null || list.size() == 0) {
				ServletUtility.setErrorMessage("No record found ", request);
			}
			if (next == null || next.size() == 0) {
				request.setAttribute("nextListSize", 0);

			} else {
				request.setAttribute("nextListSize", next.size());
			}
			ServletUtility.setList(list, request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			ServletUtility.forward(getView(), request, response);
		} catch (ApplicationException e) {
			ServletUtility.handleException(e, request, response);
			return;
		} catch (Exception e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List list = null;
		List next = null;
		int pageNo = DataUtility.getInt(request.getParameter("pageNo"));
		int pageSize = DataUtility.getInt(request.getParameter("pageSize"));

		pageNo = (pageNo == 0) ? 1 : pageNo;
		pageSize = (pageSize == 0) ? DataUtility.getInt(PropertyReader.getValue("page.size")) : pageSize;
		CustomerDTO dto = (CustomerDTO) populateDTO(request);
		String op = DataUtility.getString(request.getParameter("operation"));
		System.out.println("op---->" + op);

// get the selected checkbox ids array for delete list
		String[] ids = request.getParameterValues("ids");
		CustomerModelInt model = ModelFactory.getInstance().getCustomerModel();
		try {

			if (OP_SEARCH.equalsIgnoreCase(op) || "Next".equalsIgnoreCase(op) || "Previous".equalsIgnoreCase(op)) {

				if (OP_SEARCH.equalsIgnoreCase(op)) {
					pageNo = 1;
				} else if (OP_NEXT.equalsIgnoreCase(op)) {
					pageNo++;
				} else if (OP_PREVIOUS.equalsIgnoreCase(op) && pageNo > 1) {
					pageNo--;
				}

			} else if (OP_NEW.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.CUSTUMER_CTL, request, response);
				return;
			} else if (OP_RESET.equalsIgnoreCase(op)) {

				ServletUtility.redirect(ORSView.CUSTOMER_LIST_CTL, request, response);
				return;
			} else if (OP_DELETE.equalsIgnoreCase(op)) {
				pageNo = 1;
				if (ids != null && ids.length > 0) {
					CustomerDTO deletedto = new CustomerDTO();
					for (String id : ids) {
						deletedto.setId(DataUtility.getLong(id));
						model.delete(deletedto);
						ServletUtility.setSuccessMessage("Data Successfully Deleted!", request);
					}
				} else {
					ServletUtility.setErrorMessage("Select atleast one record", request);
				}
			}
			if (OP_BACK.equalsIgnoreCase(op)) {
				ServletUtility.redirect(ORSView.CUSTOMER_LIST_CTL, request, response);
				return;
			}
			dto = (CustomerDTO) populateDTO(request);

			list = model.search(dto, pageNo, pageSize);
			ServletUtility.setDto(dto, request);
			next = model.search(dto, pageNo + 1, pageSize);

			ServletUtility.setList(list, request);
			ServletUtility.setList(list, request);
			if (list == null || list.size() == 0) {
				if (!OP_DELETE.equalsIgnoreCase(op)) {
					ServletUtility.setErrorMessage("No record found", request);
				}
			}
			if (next == null || next.size() == 0) {
				request.setAttribute("nextListSize", 0);

			} else {
				request.setAttribute("nextListSize", next.size());
			}
			ServletUtility.setList(list, request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			ServletUtility.forward(getView(), request, response);

		} catch (ApplicationException e) {
			ServletUtility.handleException(e, request, response);
			return;
		} catch (Exception e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.CUSTOMER_LIST_VIEW;
	}

}
