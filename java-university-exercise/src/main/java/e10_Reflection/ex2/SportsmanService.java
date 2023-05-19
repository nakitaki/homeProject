package e10_Reflection.ex2;

import java.time.LocalDate;

public interface SportsmanService {
    double paymentValue(Sportsman sportsman);
    Sportsman sportsmanWithGreaterPayment(Sportsman sportsman1, Sportsman sportsman2);

}
