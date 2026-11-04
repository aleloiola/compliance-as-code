package com.loiola.compliance.engine.dmn;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class IrpfRetentionGoldenTest {

    private final IrpfRetentionService service = new IrpfRetentionService();

    @ParameterizedTest(name = "annualIncome {0} -> {1}%")
    @CsvFileSource(resources = "/golden/irpf-retencion.csv", numLinesToSkip = 1)
    void goldenCases(BigDecimal annualIncome, BigDecimal expectedRate) {
        assertThat(service.retentionRate(annualIncome)).isEqualByComparingTo(expectedRate);
    }
}