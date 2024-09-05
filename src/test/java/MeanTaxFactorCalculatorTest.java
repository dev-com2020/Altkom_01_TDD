import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
public class MeanTaxFactorCalculatorTest {
    static final double TAX_FACTOR = 10;

    @Mock
    TaxService taxService;

    @InjectMocks
    MeanTaxFactorCalculator systemUnderTest;

    @Test
    public void should_calculate_mean_tax_factor(){
//        given
        given(taxService.getCurrentTaxFactorFor(any(Person.class))).willReturn(TAX_FACTOR);
//        when
        double meanTaxFactor = systemUnderTest.calculateMeanTaxFactorFor(new Person());
//        then
        then(meanTaxFactor).isEqualTo(TAX_FACTOR);
    }
}
