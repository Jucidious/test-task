package com.jucya.exception;

public class CompanyDuplicateException extends RuntimeException {

    private final String companyName;

    public CompanyDuplicateException(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String getMessage() {
        return "This \"" + companyName + "\" company already exists";
    }
}
