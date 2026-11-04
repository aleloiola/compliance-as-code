# ADR-001 · IaC: <Terraform|CDK TypeScript>
Data: 2026-11-04 · Status: aceito
Contexto: 10 labs em conta AWS própria; alvo EA multi-cloud (ADP) e SA AWS.
Decisão: <ferramenta>. Alternativa descartada: <a outra>, porque <1 linha>.
Consequência: uma stack por lab; destroy = teardown. Risco: cobertura de AgentCore/S3 Vectors na S7–S8 → fallback CLI/SDK.
