package in.co.rays.project_3.controller;

/**
 * ORS View Provide Loose Coupling
 * 
 * @author Kanak Soni
 *
 */
public interface ORSView {
	public String APP_CONTEXT = "/project_3";

	public String PAGE_FOLDER = "/jsp";

	public String JAVA_DOC_VIEW = APP_CONTEXT + "/doc/index.html";

	public String ERROR_VIEW = PAGE_FOLDER + "/ErrorView404.jsp";

	public String MARKSHEET_VIEW = PAGE_FOLDER + "/MarksheetView.jsp";

	public String MARKSHEET_LIST_VIEW = PAGE_FOLDER + "/MarksheetListView.jsp";
	public String GET_MARKSHEET_VIEW = PAGE_FOLDER + "/GetMarksheetView.jsp";
	public String USER_VIEW = PAGE_FOLDER + "/UserView.jsp";
	public String USER_LIST_VIEW = PAGE_FOLDER + "/UserListView.jsp";
	public String COLLEGE_VIEW = PAGE_FOLDER + "/CollegeView.jsp";
	public String COLLEGE_LIST_VIEW = PAGE_FOLDER + "/CollegeListView.jsp";
	public String STUDENT_VIEW = PAGE_FOLDER + "/StudentView.jsp";
	public String STUDENT_LIST_VIEW = PAGE_FOLDER + "/StudentListView.jsp";
	public String ROLE_VIEW = PAGE_FOLDER + "/RoleView.jsp";
	public String ROLE_LIST_VIEW = PAGE_FOLDER + "/RoleListView.jsp";
	public String USER_REGISTRATION_VIEW = PAGE_FOLDER + "/UserRegistrationView.jsp";
	public String LOGIN_VIEW = PAGE_FOLDER + "/LoginView.jsp";
	public String WELCOME_VIEW = PAGE_FOLDER + "/Welcome.jsp";
	public String CHANGE_PASSWORD_VIEW = PAGE_FOLDER + "/ChangePasswordView.jsp";
	public String MY_PROFILE_VIEW = PAGE_FOLDER + "/MyProfileView.jsp";
	public String FORGET_PASSWORD_VIEW = PAGE_FOLDER + "/ForgetPasswordView.jsp";
	public String MARKSHEET_MERIT_LIST_VIEW = PAGE_FOLDER + "/MarksheetMeritListView.jsp";

	public String FACULTY_VIEW = PAGE_FOLDER + "/FacultyView.jsp";
	public String FACULTY_LIST_VIEW = PAGE_FOLDER + "/FacultyListView.jsp";
	public String COURSE_VIEW = PAGE_FOLDER + "/CourseView.jsp";
	public String COURSE_LIST_VIEW = PAGE_FOLDER + "/CourseListView.jsp";
	public String TIMETABLE_VIEW = PAGE_FOLDER + "/TimeTableView.jsp";
	public String TIMETABLE_LIST_VIEW = PAGE_FOLDER + "/TimeTableListView.jsp";
	public String SUBJECT_VIEW = PAGE_FOLDER + "/SubjectView.jsp";
	public String SUBJECT_LIST_VIEW = PAGE_FOLDER + "/SubjectListView.jsp";
	public String PRODUCT_VIEW = PAGE_FOLDER + "/ProductView.jsp";
	public String PRODUCT_LIST_VIEW = PAGE_FOLDER + "/ProductListView.jsp";
	public String SHOPING_VIEW = PAGE_FOLDER + "/ShopingView.jsp";
	public String SHOPING_LIST_VIEW = PAGE_FOLDER + "/ShopingListView.jsp";
	public String ORDER_VIEW = PAGE_FOLDER + "/OrderView.jsp";
	public String ORDER_LIST_VIEW = PAGE_FOLDER + "/OrderListView.jsp";
	public String PROJECT_VIEW = PAGE_FOLDER + "/ProjectView.jsp";
	public String PROJECT_LIST_VIEW = PAGE_FOLDER + "/ProjectListView.jsp";
	public String BUS_VIEW = PAGE_FOLDER + "/BusView.jsp";
	public String BUS_LIST_VIEW = PAGE_FOLDER + "/BusListView.jsp";
	public String ATM_VIEW = PAGE_FOLDER + "/AtmView.jsp";
	public String ATM_LIST_VIEW = PAGE_FOLDER + "/AtmListView.jsp";
	public String STOCK_VIEW = PAGE_FOLDER + "/StockView.jsp";
	public String STOCK_LIST_VIEW = PAGE_FOLDER + "/StockListView.jsp";
	public String CUSTOMER_VIEW = PAGE_FOLDER + "/CustomerView.jsp";
	public String CUSTOMER_LIST_VIEW= PAGE_FOLDER + "/CustomerListView.jsp";




	public String ERROR_CTL = APP_CONTEXT + "/ErrorCtl";

	public String MARKSHEET_CTL = APP_CONTEXT + "/ctl/MarksheetCtl";
	public String MARKSHEET_LIST_CTL = APP_CONTEXT + "/ctl/MarksheetListCtl";
	public String USER_CTL = APP_CONTEXT + "/ctl/UserCtl";
	public String USER_LIST_CTL = APP_CONTEXT + "/ctl/UserListCtl";
	public String COLLEGE_CTL = APP_CONTEXT + "/ctl/CollegeCtl";
	public String COLLEGE_LIST_CTL = APP_CONTEXT + "/ctl/CollegeListCtl";
	public String STUDENT_CTL = APP_CONTEXT + "/ctl/StudentCtl";
	public String STUDENT_LIST_CTL = APP_CONTEXT + "/ctl/StudentListCtl";
	public String ROLE_CTL = APP_CONTEXT + "/ctl/RoleCtl";
	public String ROLE_LIST_CTL = APP_CONTEXT + "/ctl/RoleListCtl";
	public String USER_REGISTRATION_CTL = APP_CONTEXT + "/UserRegistrationCtl";
	public String LOGIN_CTL = APP_CONTEXT + "/LoginCtl";
	public String WELCOME_CTL = APP_CONTEXT + "/WelcomeCtl";

	public String FACULTY_CTL = APP_CONTEXT + "/ctl/FacultyCtl";
	public String FACULTY_LIST_CTL = APP_CONTEXT + "/ctl/FacultyListCtl";
	public String COURSE_CTL = APP_CONTEXT + "/ctl/CourseCtl";
	public String COURSE_LIST_CTL = APP_CONTEXT + "/ctl/CourseListCtl";
	public String SUBJECT_CTL = APP_CONTEXT + "/ctl/SubjectCtl";
	public String SUBJECT_LIST_CTL = APP_CONTEXT + "/ctl/SubjectListCtl";
	public String TIMETABLE_CTL = APP_CONTEXT + "/ctl/TimeTableCtl";
	public String TIMETABLE_LIST_CTL = APP_CONTEXT + "/ctl/TimeTableListCtl";

	public String GET_MARKSHEET_CTL = APP_CONTEXT + "/ctl/GetMarksheetCtl";
	public String CHANGE_PASSWORD_CTL = APP_CONTEXT + "/ctl/ChangePasswordCtl";
	public String MY_PROFILE_CTL = APP_CONTEXT + "/ctl/MyProfileCtl";
	public String FORGET_PASSWORD_CTL = APP_CONTEXT + "/ForgetPasswordCtl";
	public String MARKSHEET_MERIT_LIST_CTL = APP_CONTEXT + "/ctl/MarksheetMeritListCtl";
	public String PRODUCT_CTL = APP_CONTEXT + "/ctl/ProductCtl";
	public String PRODUCT_LIST_CTL = APP_CONTEXT + "/ctl/ProductListCtl";
	public String SHOPING_CTL = APP_CONTEXT + "/ctl/ShopingCtl";
	public String SHOPING_LIST_CTL = APP_CONTEXT + "/ctl/ShopingListCtl";
	public String ORDER_CTL = APP_CONTEXT + "/ctl/OrderCtl";
	public String ORDER_LIST_CTL = APP_CONTEXT + "/ctl/OrderListCtl";
	public String PROJECT_CTL = APP_CONTEXT + "/ctl/ProjectCtl";
	public String PROJECT_LIST_CTL = APP_CONTEXT + "/ctl/ProjectListCtl";
	public String BUS_CTL = APP_CONTEXT + "/ctl/BusCtl";
	public String BUS_LIST_CTL = APP_CONTEXT + "/ctl/BusListCtl";
	public String ATM_CTL = APP_CONTEXT + "/ctl/AtmCtl";
	public String ATM_LIST_CTL = APP_CONTEXT + "/ctl/AtmListCtl";
	public String STOCK_CTL = APP_CONTEXT + "/ctl/StockCtl";
	public String STOCK_LIST_CTL = APP_CONTEXT + "/StockListCtl";
	public String CUSTUMER_CTL = APP_CONTEXT + "/ctl/CustomerCtl";
	public String CUSTOMER_LIST_CTL = APP_CONTEXT + "/ctl/CustomerListCtl";
}
