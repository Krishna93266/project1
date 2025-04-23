package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Appointment;

public class AppointmentDao {

    private Connection conn;

    public AppointmentDao(Connection conn) {
        this.conn = conn;
    }

    public boolean addAppointment(Appointment ap) {
        boolean isSuccess = false;

        try {
            String sql = "INSERT INTO appointment (userId, fullname, gender, age, appoint_date, email, phno, diseases, doctorId, address, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ap.getUserId());
            ps.setString(2, ap.getFullName());
            ps.setString(3, ap.getGender());
            ps.setInt(4, Integer.parseInt(ap.getAge())); // Ensure age is passed as an integer
            ps.setString(5, ap.getAppoinDate());
            ps.setString(6, ap.getEmail());
            ps.setString(7, ap.getPhNo());
            ps.setString(8, ap.getDiseases());
            ps.setInt(9, ap.getDoctorId());
            ps.setString(10, ap.getAddress());
            ps.setString(11, ap.getStatus());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected == 1) {
                isSuccess = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
    public List<Appointment>  getAllAppointmentByLoginUser(int userId){
    	List<Appointment> list= new ArrayList<Appointment>();
    	Appointment ap=null;
    	try {
    		String sql= "select *from appointment where userId=?";
    		PreparedStatement ps=conn.prepareStatement(sql);
    		ps.setInt(1, userId);
    		
    		ResultSet rs= ps.executeQuery();
    		while(rs.next()) {
    			ap = new Appointment();
                ap.setId(rs.getInt(1)); // id
                ap.setUserId(rs.getInt(2)); // userId
                ap.setDoctorId(rs.getInt(3)); // doctorId
                ap.setFullName(rs.getString(4)); // fullname
                ap.setGender(rs.getString(5)); // gender
                ap.setAge(String.valueOf(rs.getInt(6))); // age
                ap.setAppoinDate(rs.getString(7)); // appoint_date
                ap.setEmail(rs.getString(8)); // email
                ap.setPhNo(rs.getString(9)); // phno
                ap.setDiseases(rs.getString(10)); // diseases
                ap.setAddress(rs.getString(11)); // address
                ap.setStatus(rs.getString(12)); // status
                list.add(ap);
    		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return list;
    }
    public List<Appointment> getAllAppointmentByDoctorLogin(int doctorId) {
        List<Appointment> list = new ArrayList<>();
        Appointment ap = null;

        try {
            String sql = "SELECT * FROM appointment WHERE doctorId = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, doctorId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ap = new Appointment();
                ap.setId(rs.getInt("id"));
                ap.setUserId(rs.getInt("userId"));
                ap.setDoctorId(rs.getInt("doctorId"));
                ap.setFullName(rs.getString("fullname"));
                ap.setGender(rs.getString("gender"));
                ap.setAge(String.valueOf(rs.getInt("age")));
                ap.setAppoinDate(rs.getString("appoint_date"));
                ap.setEmail(rs.getString("email"));
                ap.setPhNo(rs.getString("phno"));
                ap.setDiseases(rs.getString("diseases"));
                ap.setAddress(rs.getString("address"));
                ap.setStatus(rs.getString("status"));

                list.add(ap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public Appointment getAppointmentById(int id) {

		Appointment ap = null;

		try {

			String sql = "select * from appointment where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt("id"));
                ap.setUserId(rs.getInt("userId"));
                ap.setDoctorId(rs.getInt("doctorId"));
                ap.setFullName(rs.getString("fullname"));
                ap.setGender(rs.getString("gender"));
                ap.setAge(String.valueOf(rs.getInt("age")));
                ap.setAppoinDate(rs.getString("appoint_date"));
                ap.setEmail(rs.getString("email"));
                ap.setPhNo(rs.getString("phno"));
                ap.setDiseases(rs.getString("diseases"));
                ap.setAddress(rs.getString("address"));
                ap.setStatus(rs.getString("status"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ap;
	}
    public boolean updateCommentStatus(int id, int doctorId, String comm) {
		boolean f = false;
		try {
			String sql = "update appointment set status=? where id=? and doctorId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, comm);
			ps.setInt(2, id);
			ps.setInt(3, doctorId);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<Appointment> getAllAppointment() {
		List<Appointment> list = new ArrayList<Appointment>();
		Appointment ap = null;

		try {

			String sql = "select * from appointment order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt("id"));
                ap.setUserId(rs.getInt("userId"));
                ap.setDoctorId(rs.getInt("doctorId"));
                ap.setFullName(rs.getString("fullname"));
                ap.setGender(rs.getString("gender"));
                ap.setAge(String.valueOf(rs.getInt("age")));
                ap.setAppoinDate(rs.getString("appoint_date"));
                ap.setEmail(rs.getString("email"));
                ap.setPhNo(rs.getString("phno"));
                ap.setDiseases(rs.getString("diseases"));
                ap.setAddress(rs.getString("address"));
                ap.setStatus(rs.getString("status"));
				list.add(ap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
