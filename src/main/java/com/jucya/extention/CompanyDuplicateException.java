package com.jucya.extention;

/**
 * Thrown when the source inn and ogrn
 * matches the source inn and ogrn
 * to being already imported.
 */
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
