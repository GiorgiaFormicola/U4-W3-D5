package GiorgiaFormicola.exceptions;

import java.time.LocalDate;

public class AllLoansReturnedException extends RuntimeException {
    public AllLoansReturnedException() {
        super("All loans are returned by today (" + LocalDate.now() + ")");
    }
}
