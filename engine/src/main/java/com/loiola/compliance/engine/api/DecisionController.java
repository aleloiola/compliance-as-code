package com.loiola.compliance.engine.api;

import java.math.BigDecimal;
import com.loiola.compliance.engine.dmn.IrpfRetentionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/decisions")
public class DecisionController {

    private final IrpfRetentionService service;

    public DecisionController(IrpfRetentionService service) {
        this.service = service;
    }

    public record IrpfRequest(BigDecimal annualIncome) {}
    public record IrpfResponse(BigDecimal annualIncome, BigDecimal retentionRate, String decision) {}

    @PostMapping("/irpf-retention")
    public IrpfResponse irpf(@RequestBody IrpfRequest req) {
        return new IrpfResponse(req.annualIncome(), service.retentionRate(req.annualIncome()), "irpfRetention");
    }
}