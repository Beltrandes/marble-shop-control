package br.com.marmoraria.marmoraria.modules.company.errors;


public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(String message) {
        super(message);
    }
}
