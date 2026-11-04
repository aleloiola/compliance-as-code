package com.loiola.compliance.engine.dmn;

import java.math.BigDecimal;
import org.kie.dmn.api.core.DMNContext;
import org.kie.dmn.api.core.DMNModel;
import org.kie.dmn.api.core.DMNResult;
import org.kie.dmn.api.core.DMNRuntime;
import org.kie.dmn.core.internal.utils.DMNRuntimeBuilder;
import org.springframework.stereotype.Service;

@Service
public class IrpfRetentionService {

    private static final String DECISION = "irpfRetention";
    private final DMNRuntime runtime;
    private final DMNModel model;

    public IrpfRetentionService() {
        this.runtime = DMNRuntimeBuilder.fromDefaults()
                .buildConfiguration()
                .fromClasspathResource("/dmn/retencion-irpf.dmn", IrpfRetentionService.class)
                .getOrElseThrow(e -> new IllegalStateException("DMN load failed", e));
        this.model = runtime.getModels().get(0);
    }

    public BigDecimal retentionRate(BigDecimal annualIncome) {
        DMNContext ctx = runtime.newContext();
        ctx.set("annualIncome", annualIncome);
        DMNResult result = runtime.evaluateByName(model, ctx, DECISION);
        if (result.hasErrors()) {
            throw new IllegalStateException(result.getMessages().toString());
        }
        return (BigDecimal) result.getDecisionResultByName(DECISION).getResult();
    }
}