package in.co.rays.project_3.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.project_3.dto.AtmDTO;
import in.co.rays.project_3.dto.BaseDTO;

import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.AtmModelInt;
import in.co.rays.project_3.model.ModelFactory;

import in.co.rays.project_3.util.DataUtility;
import in.co.rays.project_3.util.DataValidator;
import in.co.rays.project_3.util.PropertyReader;
import in.co.rays.project_3.util.ServletUtility;

@WebServlet(urlPatterns = { "/ctl/AtmCtl" })
public class AtmCtl extends BaseCtl {
	
	
	@Override
	protected void preload(HttpServletRequest request) {
		AtmModelInt model = ModelFactory.getInstance().getAtmModel();

		
		Map<Integer , String>map =new HashMap<Integer, String>();
		map.put(1,"near");
		map.put(2,"along");
		request.setAttribute("prolist", map);
		
		Map<Integer , String>map1 =new HashMap<Integer, String>();
		map1.put(1,"good");
		map.put(2,"bad");
		request.setAttribute("prolist1", map1);
		
	}
	
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		if (DataValidator.isNull(request.getParameter("location"))) {
			request.setAttribute("location", PropertyReader.getValue("error.require", "location"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("location"))) {
			request.setAttribute("location", "location must contain alphabets only");
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("cashavailable"))) {
			request.setAttribute("cashavailable", PropertyReader.getValue("error.require", "cashavailable"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("dob"))) {
			request.setAttribute("dob", PropertyReader.getValue("error.require", "dob"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("remark"))) {
			request.setAttribute("remark", PropertyReader.getValue("error.require", "remark"));
			pass = false;

		}
		return pass;
	}

	protected BaseDTO populateDTO(HttpServletRequest request) {
		AtmDTO dto = new AtmDTO();
		dto.setLocation(request.getParameter("location"));
		dto.setCashavailable(DataUtility.getDouble(request.getParameter("cashavailable")));
		dto.setDob(DataUtility.getDate(request.getParameter("dob")));
		dto.setRemark(request.getParameter("remark"));

		populateBean(dto, request);
		return dto;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String op = request.getParameter("operation");
		long id = DataUtility.getLong(request.getParameter("id"));
		AtmModelInt model = ModelFactory.getInstance().getAtmModel();
		if (id > 0 || op != null) {
			AtmDTO dto;
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

		System.out.println("in project dopost method");

		String op = request.getParameter("operation");
		long id = DataUtility.getLong(request.getParameter("id"));

		AtmModelInt model = ModelFactory.getInstance().getAtmModel();

		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {

			AtmDTO dto = (AtmDTO) populateDTO(request);

			try {
				if (id > 0) {
					dto.setId(id);
					model.update(dto);
					ServletUtility.setDto(dto, request);

					ServletUtility.setSuccessMessage("Record Successfully Updated", request);

				} else {
					System.out.println("college add" + dto + "id...." + id);
					// long pk
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
			ServletUtility.redirect(ORSView.ATM_CTL, request, response);
			return;
		} else if (OP_CANCEL.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.ATM_LIST_CTL, request, response);
			return;

		}
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.ATM_VIEW;
	}

}
