# Compliance as Code - Statutory rules as a versioned rule set, outside the product core
Several weeks, even months are necessary to update the product when a new law is published. Every legal change triggers a full release cycle, which slows the business down.
## What we already have in place
- IRPF official table in DMN
- REST endpoints
- 7 Golden tests
## How to run
```bash
cd engine
./mvnw test
./mvnw spring-boot:run
```
## Folder structure
- engine/ - Spring-Boot + Drools DMN Service
- rules/ - DMN rule set files
- infra/ - terraform files
- genai/ - RAG over legislation, MCP server, rule-change agent (planned)
- docs/ - Architecture decisions and C4 diagrams
## Decisions
[ADR-001 — IaC: Terraform over CDK](docs/adr/ADR-001-iac.md)
## Roadmap
- Deploy on AWS Fargate -> event-driven rule publication pipelines -> audit trail -> RAG over legislation - agent that proposes rule changes, human-approved 
## Cost
- Hard cap: €30/month. Every lab ends with a teardown.
## What this is not
- Payroll or accounting product. It contains no real data.
## Author
Alexandre Loiola