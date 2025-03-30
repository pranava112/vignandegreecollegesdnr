package com.vdc.vignan.degree.college.Entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.List;

@Converter
public class TransactionsConverter implements AttributeConverter<List<TransactionDetails>, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<TransactionDetails> transactions) {
        try {
            return objectMapper.writeValueAsString(transactions);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting list of transactions to JSON", e);
        }
    }

    @Override
    public List<TransactionDetails> convertToEntityAttribute(String json) {
        try {
            return objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, TransactionDetails.class));
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting JSON to list of transactions", e);
        }
    }
}
