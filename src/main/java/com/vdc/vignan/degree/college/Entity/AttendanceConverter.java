package com.vdc.vignan.degree.college.Entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Map;
import java.util.Date;

@Converter
public class AttendanceConverter implements AttributeConverter<Map<Date, Map<String, String>>, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map<Date, Map<String, String>> attendanceRecords) {
        try {
            return attendanceRecords == null ? null : objectMapper.writeValueAsString(attendanceRecords);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting attendance records to JSON", e);
        }
    }

    @Override
    public Map<Date, Map<String, String>> convertToEntityAttribute(String attendanceRecordsJson) {
        try {
            return attendanceRecordsJson == null ? null : objectMapper.readValue(attendanceRecordsJson,
                    objectMapper.getTypeFactory().constructMapType(Map.class, Date.class, Map.class));
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting JSON to attendance records", e);
        }
    }
}
