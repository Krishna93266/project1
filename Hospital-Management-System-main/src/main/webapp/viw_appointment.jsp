<%@page import="com.entity.User"%>
<%@page import="com.entity.Doctor"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.entity.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.AppointmentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Appointment List</title>
    <%@include file="component/allcss.jsp"%>
    <style>
        .paint-card {
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
            border-radius: 8px;
            overflow: hidden;
        }
        .backImg {
            background: linear-gradient(rgba(0, 0, 0, 0.4), rgba(0, 0, 0, 0.4)),
                url("img/bg1.png") center/cover no-repeat;
            height: 20vh;
            width: 100%;
        }
        .img-responsive {
            width: 100%;
            height: auto;
            border-radius: 8px;
        }
    </style>
</head>
<body>
    <!-- Redirect to login if userObj is null -->
    <c:if test="${empty userObj}">
        <c:redirect url="user_login.jsp"/>
    </c:if>

    <%@include file="component/navbar.jsp"%>

    <!-- Banner Section -->
    <div class="container-fluid backImg d-flex align-items-center justify-content-center">
        <p class="text-center fs-2 text-white fw-bold">Appointment Management</p>
    </div>

    <!-- Main Content Section -->
    <div class="container py-4">
        <div class="row">
            <div class="col-lg-9 col-md-8 col-sm-12 mb-4">
                <div class="card paint-card">
                    <div class="card-body">
                        <p class="fs-4 fw-bold text-center text-success">Appointment List</p>
                        <div class="table-responsive">
                            <table class="table table-hover table-striped">
                                <thead class="table-light">
                                    <tr>
                                        <th>Full Name</th>
                                        <th>Gender</th>
                                        <th>Age</th>
                                        <th>Appointment Date</th>
                                        <th>Diseases</th>
                                        <th>Doctor Name</th>
                                        <th>Status</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        User user = (User) session.getAttribute("userObj");
                                        if (user != null) {
                                            AppointmentDao appointmentDao = new AppointmentDao(DBConnect.getConn());
                                            DoctorDao doctorDao = new DoctorDao(DBConnect.getConn());
                                            List<Appointment> appointments = appointmentDao.getAllAppointmentByLoginUser(user.getId());
                                            
                                            if (appointments != null && !appointments.isEmpty()) {
                                                for (Appointment ap : appointments) {
                                                    Doctor doctor = doctorDao.getDoctorById(ap.getDoctorId());
                                    %>
                                    <tr>
                                        <td><%= ap.getFullName() %></td>
                                        <td><%= ap.getGender() %></td>
                                        <td><%= ap.getAge() %></td>
                                        <td><%= ap.getAppoinDate() %></td>
                                        <td><%= ap.getDiseases() %></td>
                                        <td>
                                            <%= (doctor != null) ? doctor.getFullname() : "Doctor not found" %>
                                        </td>
                                        <td>
                                            <%
                                                if ("Pending".equalsIgnoreCase(ap.getStatus())) {
                                            %>
                                                <span class="badge bg-warning text-dark">Pending</span>
                                            <%
                                                } else {
                                            %>
                                                <span class="badge bg-success text-white"><%= ap.getStatus() %></span>
                                            <%
                                                }
                                            %>
                                        </td>
                                    </tr>
                                    <%
                                                }
                                            } else {
                                    %>
                                    <tr>
                                        <td colspan="7" class="text-center text-danger">
                                            No Appointments Found
                                        </td>
                                    </tr>
                                    <%
                                            }
                                        } else {
                                    %>
                                    <tr>
                                        <td colspan="7" class="text-center text-danger">
                                            Invalid Session. Please log in again.
                                        </td>
                                    </tr>
                                    <%
                                        }
                                    %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Sidebar -->
            <div class="col-lg-3 col-md-4 col-sm-12">
                <img alt="Doctor" src="img/doct.jpg" class="img-responsive">
            </div>
        </div>
    </div>
</body>
</html>
