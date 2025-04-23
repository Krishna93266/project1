package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AppointmentDao;
import com.db.DBConnect;
import com.entity.Appointment;

@WebServlet("/appAppointment")
public class AppointmentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        try {
            // Fetch form data
            int userId = Integer.parseInt(req.getParameter("userId"));
            int doctorId = Integer.parseInt(req.getParameter("doctorId"));
            String fullname = req.getParameter("fullname");
            String gender = req.getParameter("gender");
            String age = req.getParameter("age");
            String appoint_date = req.getParameter("appoint_date");
            String email = req.getParameter("email");
            String phno = req.getParameter("phno");
            String diseases = req.getParameter("diseases");
            String address = req.getParameter("address");

            // Create Appointment object
            Appointment ap = new Appointment(userId, fullname, gender, age, appoint_date, email, phno, diseases, doctorId, address, "Pending");

            // Call DAO to save appointment
            AppointmentDao dao = new AppointmentDao(DBConnect.getConn());

            if (dao.addAppointment(ap)) {
                session.setAttribute("succMsg", "Appointment successfully booked.");
            } else {
                session.setAttribute("errorMsg", "Something went wrong on the server.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("errorMsg", "Invalid data! Please try again.");
        }

        // Redirect to the user appointment page
        resp.sendRedirect("user_appointment.jsp");
    }
}
