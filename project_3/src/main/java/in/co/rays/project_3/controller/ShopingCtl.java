package in.co.rays.project_3.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.co.rays.project_3.dto.BaseDTO;
import in.co.rays.project_3.dto.RoleDTO;
import in.co.rays.project_3.dto.ShopingDTO;
import in.co.rays.project_3.dto.UserDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.ModelFactory;
import in.co.rays.project_3.model.RoleModelInt;
import in.co.rays.project_3.model.ShopingModelInt;
import in.co.rays.project_3.model.UserModelInt;
import in.co.rays.project_3.util.DataUtility;
import in.co.rays.project_3.util.DataValidator;
import in.co.rays.project_3.util.PropertyReader;
import in.co.rays.project_3.util.ServletUtility;

@WebServlet(urlPatterns = { "/ctl/ShopingCtl" })
public class ShopingCtl extends BaseCtl {
	protected void preload(HttpServletRequest request) {
		RoleModelInt model = ModelFactory.getInstance().getRoleModel();
		try {
			List list = model.list();
			Iterator it = list.iterator();
			while (it.hasNext()) {
				RoleDTO dto = (RoleDTO) it.next();
				System.out.println(dto.getId());
				System.out.println(dto.getName());
				System.out.println(dto.getDescription());

			}

			request.setAttribute("roleList", list);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		System.out.println("-------------validate started-------------");

		if (DataValidator.isNull(request.getParameter("Name"))) {
			request.setAttribute("Name", PropertyReader.getValue("error.require", "Name"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("Name"))) {
			request.setAttribute("Name", "please enter correct Name");
			pass = false;

		}
		if (DataValidator.isNull(request.getParameter("Price"))) {
			request.setAttribute("Price", PropertyReader.getValue("error.require", "Price"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("Price"))) {
			request.setAttribute("Price", "please enter correct Price");
			pass = false;

		}
		if (DataValidator.isNull(request.getParameter("dob"))) {
			request.setAttribute("dob", PropertyReader.getValue("error.require", "dob"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("dob"))) {
			request.setAttribute("dob", "please enter correct Dob");
			pass = false;

		}
		if (DataValidator.isNull(request.getParameter("description"))) {
			request.setAttribute("dob", PropertyReader.getValue("error.require", "description"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("description"))) {
			request.setAttribute("description", "please enter correct description");
			pass = false;

		}
		return pass;
	}

	protected BaseDTO populateDTO(HttpServletRequest request) {
		ShopingDTO dto = new ShopingDTO();

		System.out.println(request.getParameter("dob"));
		System.out.println("Populate end " + "................" + request.getParameter("id"));
		System.out.println("-------------------------------------------" + request.getParameter("password"));
		System.out.println(request.getParameter("confirmPassword"));

		dto.setId(DataUtility.getLong(request.getParameter("id")));
		dto.setProductName(DataUtility.getString(request.getParameter("Name")));
		dto.setProductPrice(DataUtility.getString(request.getParameter("Price")));
		dto.setDate(DataUtility.getDate(request.getParameter("dob")));
		dto.setDescription(DataUtility.getString(request.getParameter("description")));

		/*
		 * dto.setRoleId(DataUtility.getLong(request.getParameter("role")));
		 * dto.setDob(DataUtility.getDate(request.getParameter("dob")));
		 * dto.setFirstName(DataUtility.getString(request.getParameter("firstName")));
		 * 
		 * dto.setLastName(DataUtility.getString(request.getParameter("lastName")));
		 * 
		 * dto.setLogin(DataUtility.getString(request.getParameter("emailId")));
		 * 
		 * dto.setPassword(DataUtility.getString(request.getParameter("password")));
		 * 
		 * dto.setConfirmPassword(DataUtility.getString(request.getParameter(
		 * "confirmPassword")));
		 * 
		 * dto.setGender(DataUtility.getString(request.getParameter("gender")));
		 * dto.setMobileNo(DataUtility.getString(request.getParameter("mobileNo")));
		 */
		populateBean(dto, request);

		/*
		 * System.out.println(request.getParameter("dob")+"......."+dto.getDob());
		 */

		return dto;

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String op = DataUtility.getString(request.getParameter("operation"));
		// get model
		UserModelInt model = ModelFactory.getInstance().getUserModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		if (id > 0 || op != null) {
			System.out.println("in id > 0  condition");
			UserDTO dto = null;
			try {
				dto = model.findByPK(id);
				ServletUtility.setDto(dto, request);
			} catch (Exception e) {
				e.printStackTrace();

				ServletUtility.handleException(e, request, response);
				return;
			}
		}
		ServletUtility.forward(getView(), request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String op = DataUtility.getString(request.getParameter("operation"));

		ShopingModelInt model = ModelFactory.getInstance().getShopingModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {
			ShopingDTO dto = (ShopingDTO) populateDTO(request);
			System.out.println(" in do post method jkjjkjk++++++++" + dto.getId());
			try {
				if (id > 0) {
					model.update(dto);
					ServletUtility.setSuccessMessage("Data is successfully Updated", request);
				} else {

					try {
						model.add(dto);
						ServletUtility.setSuccessMessage("Data is successfully saved", request);
					} catch (ApplicationException e) {

						ServletUtility.handleException(e, request, response);
						return;
					} catch (DuplicateRecordException e) {
						ServletUtility.setDto(dto, request);
						ServletUtility.setErrorMessage("Login id already exists", request);
					}

				}
				ServletUtility.setDto(dto, request);

			} catch (ApplicationException e) {

				ServletUtility.handleException(e, request, response);
				return;
			} catch (DuplicateRecordException e) {
				ServletUtility.setDto(dto, request);
				ServletUtility.setErrorMessage("Login id already exists", request);
			}
		} else if (OP_DELETE.equalsIgnoreCase(op)) {

			ShopingDTO dto = (ShopingDTO) populateDTO(request);
			try {
				model.delete(dto);
				ServletUtility.redirect(ORSView.USER_LIST_CTL, request, response);
				return;
			} catch (ApplicationException e) {

				ServletUtility.handleException(e, request, response);
				return;
			}

		} else if (OP_CANCEL.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.USER_LIST_CTL, request, response);
			return;
		} else if (OP_RESET.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.SHOPING_CTL, request, response);
			return;
		}
		ServletUtility.forward(getView(), request, response);

	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.SHOPING_VIEW;
	}

}
