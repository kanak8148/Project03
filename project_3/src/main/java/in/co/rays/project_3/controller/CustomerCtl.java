package in.co.rays.project_3.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.project_3.dto.BaseDTO;
import in.co.rays.project_3.dto.CustomerDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.CustomerModelInt;
import in.co.rays.project_3.model.ModelFactory;
import in.co.rays.project_3.util.DataUtility;
import in.co.rays.project_3.util.DataValidator;
import in.co.rays.project_3.util.PropertyReader;
import in.co.rays.project_3.util.ServletUtility;

@WebServlet(urlPatterns = { "/ctl/CustomerCtl" })

public class CustomerCtl extends BaseCtl {
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		if (DataValidator.isNull(request.getParameter("clintName"))) {
			request.setAttribute("clintName", PropertyReader.getValue("error.require", "clintName"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("location"))) {
			request.setAttribute("location", PropertyReader.getValue("error.require", "location"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("contactNumber"))) {
			request.setAttribute("contactNumber", PropertyReader.getValue("error.require", "contactNumber"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("importance"))) {
			request.setAttribute("importance", PropertyReader.getValue("error.require", "importance"));
			pass = false;
		}

		return pass;
	}

	protected void preload(HttpServletRequest request) {

		CustomerModelInt model = ModelFactory.getInstance().getCustomerModel();

		Map<Integer, String> map = new HashMap<Integer, String>();

		map.put(1, "High");
		map.put(2, "Medium");
		map.put(3, "Low");

		request.setAttribute("prolist", map);

	}

	protected BaseDTO populateDTO(HttpServletRequest request) {
		CustomerDTO dto = new CustomerDTO();
		dto.setClintName(request.getParameter("clintName"));
		dto.setLocation(request.getParameter("location"));
		dto.setContactNumber(DataUtility.getLong(request.getParameter("contactNumber")));
		dto.setImportance(request.getParameter("importance"));

		populateBean(dto, request);
		return dto;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("in get method............");
		String op = request.getParameter("operation");
		long id = DataUtility.getLong(request.getParameter("id"));
		CustomerModelInt model = ModelFactory.getInstance().getCustomerModel();
		if (id > 0 || op != null) {
			CustomerDTO dto;
			try {
				dto = model.findByPK(id);

				ServletUtility.setDto(dto, request);

			} catch (ApplicationException e) {

				ServletUtility.handleException(e, request, response);
				return;
			}

		}
		ServletUtility.forward(getView(), request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String op = request.getParameter("operation");
		long id = DataUtility.getLong(request.getParameter("id"));

		CustomerModelInt model = ModelFactory.getInstance().getCustomerModel();

		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {

			CustomerDTO dto = (CustomerDTO) populateDTO(request);

			try {
				if (id > 0) {
					dto.setId(id);
					model.update(dto);
					ServletUtility.setDto(dto, request);

					ServletUtility.setSuccessMessage("Record Successfully Updated", request);

				} else {
					System.out.println("college add" + dto + "id...." + id);

					model.add(dto);
					ServletUtility.setSuccessMessage("Record Successfully Saved", request);
				}
				ServletUtility.setDto(dto, request);
			} catch (ApplicationException e) {
				e.printStackTrace();

				ServletUtility.handleException(e, request, response);
				return;
			} catch (DuplicateRecordException e) {
				ServletUtility.setDto(dto, request);
				ServletUtility.setErrorMessage("ProductName Already Exists", request);
			}
		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.CUSTUMER_CTL, request, response);
			return;
		} else if (OP_CANCEL.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.CUSTOMER_LIST_CTL, request, response);
			return;

		}
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.CUSTOMER_VIEW;
	}

}
