package printingHouse;

import java.math.BigDecimal;

public interface FinanceService {
    BigDecimal totalIncome();
    BigDecimal totalExpenses();
    BigDecimal netIncome();
    BigDecimal salaryExpenses();
    BigDecimal paperExpenses();
}
