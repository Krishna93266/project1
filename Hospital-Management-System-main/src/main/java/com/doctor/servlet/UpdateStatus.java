package com.doctor.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dao.AppointmentDao;
import com.db.DBConnect;

@WebServlet("/updateStatus")
public class UpdateStatus extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// Get parameters as strings
			String idParam = req.getParameter("id");
			String doctorIdParam = req.getParameter("doctorId");
			String comm = req.getParameter("comm");

			// Validate that parameters are not null or empty
			if (idParam == null || doctorIdParam == null || idParam.isEmpty() || doctorIdParam.isEmpty()) {
				throw new IllegalArgumentException("Missing required parameters");
			}

			// Convert to integers
			int id = Integer.parseInt(idParam);
			int doctorId = Integer.parseInt(doctorIdParam);

			// Create the DAO object
			AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
			HttpSession session = req.getSession();

			// Perform the database update
			if (dao.updateCommentStatus(id, doctorId, comm)) {
				session.setAttribute("succMsg", "Comment Updated");
				resp.sendRedirect("doctor/patient.jsp");
			} else {
				session.setAttribute("errorMsg", "Something went wrong on server");
				resp.sendRedirect("doctor/patient.jsp");
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
			// Handle invalid number format (if parameters are not valid integers)
			req.setAttribute("errorMsg", "Invalid ID or Doctor ID format");
			req.getRequestDispatcher("doctor/patient.jsp").forward(req, resp);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			// Handle missing or empty parameters
			req.setAttribute("errorMsg", "Required parameters are missing");
			req.getRequestDispatcher("doctor/patient.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			// Handle general exceptions
			req.setAttribute("errorMsg", "Something went wrong, please try again");
			req.getRequestDispatcher("doctor/patient.jsp").forward(req, resp);
		}
	}
}
