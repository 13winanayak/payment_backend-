package com.paymetrust.backend.entity;

/**
 * Enum representing the different types of accounts in the system.
 */
public enum AccountType {
    CUSTOMER("customer"),
    MERCHANT("merchant"),
    SYSTEM("system");
    
    private final String value;
    
    AccountType(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
    /**
     * Convert a string value to the corresponding AccountType enum.
     * 
     * @param value the string value to convert
     * @return the corresponding AccountType or null if not found
     */
    public static AccountType fromValue(String value) {
        for (AccountType type : AccountType.values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        return null;
    }
}