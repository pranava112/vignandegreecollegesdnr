package com.vdc.vignan.degree.college.Entity;

import java.util.Date;
import java.util.Map;

public class AttendanceRequest {
    private Date date;
    private Map<String, Map<String, Integer>> attendanceRecords;

    // Getters and Setters
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<String, Map<String, Integer>> getAttendanceRecords() {
        return attendanceRecords;
    }

    public void setAttendanceRecords(Map<String, Map<String, Integer>> attendanceRecords) {
        this.attendanceRecords = attendanceRecords;
    }
}
