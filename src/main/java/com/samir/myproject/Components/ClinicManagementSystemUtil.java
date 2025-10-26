package com.samir.myproject.Components;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component public class ClinicManagementSystemUtil {
    private final static Set<String> VALID_STATUSES= Set.of("SCHEDULED", "COMPLETED", "CANCELLED", "IN_PROGRESS");
    public boolean isCorrectStatus(String status){
        return VALID_STATUSES.contains(status);
    }
}
