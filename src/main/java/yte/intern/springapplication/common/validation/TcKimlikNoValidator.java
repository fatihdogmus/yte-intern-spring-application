package yte.intern.springapplication.common.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TcKimlikNoValidator implements ConstraintValidator<TcKimlikNo, String> {

    @Override
    public void initialize(final TcKimlikNo constraint) {
    }

    @Override
    public boolean isValid(final String tcKimlikNo, final ConstraintValidatorContext context) {
        if (tcKimlikNo == null || tcKimlikNo.length() != 11) {
            return false;
        }

        int sumAllNumbers = 0;
        int sumOdd = 0;
        int sumEven = 0;

        Integer[] numbers = new Integer[11];
        for (int i = 0; i < 11; i++) {
            try {
                numbers[i] = Integer.parseInt(tcKimlikNo.substring(i, i + 1));
            } catch (final NumberFormatException e) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            sumAllNumbers = sumAllNumbers + numbers[i];
            if (i % 2 != 0) {
                sumEven = sumEven + numbers[i];
            } else {
                sumOdd = sumOdd + numbers[i];
            }
        }

        if ((sumAllNumbers + numbers[9]) % 10 != numbers[10]) {
            return false;
        }
        if ((sumOdd * 7 + sumEven * 9) % 10 != numbers[9]) {
            return false;
        }
        return ((sumOdd) * 8) % 10 == numbers[10];
    }
}
