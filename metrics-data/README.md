# Data for the 47 metrics

Each metric below has repo data meant to exercise it. Paths are relative to the repo root.
Java classes are in `src/main/java/com/pramora/testable/metrics/` with matching tests in
`src/test/java/com/pramora/testable/metrics/` unless another folder is named.

| Technique | Metric | Data |
|---|---|---|
| Cyclomatic Complexity (4) | Decision Coverage | `ComplexityLab` branches, `ComplexityLabTest` covers every outcome |
| | Condition Coverage | `ComplexityLab.eligibleForDiscount` and `decisionScore` compound conditions |
| | Logic Coverage Metric | `ComplexityLabTest.decisionScoreCoversFullTruthTable` (all 8 combinations) |
| | Maintainability Analysis | small methods in `ComplexityLab` |
| Cognitive Complexity (4) | Risk Detection | `CognitiveLab.scoreMatrix` (deep nesting) |
| | Code Review Support | `CognitiveLab.findFirstPair` (labelled break) |
| | Testing Effort Prioritization | `CognitiveLab` methods ranked by nesting |
| | Code Understandability Analysis | `CognitiveLab.collatzSteps` (recursion with ternary) |
| Code Duplication (3) | Refactoring Opportunity Detection | `analysis/DuplicateProcessorA`, `B` and `C` |
| | Risk-Based Testing Prioritization | the three near-identical processors |
| | Maintainability Testing | `DuplicateProcessorTest`, `DuplicateProcessorCTest` |
| Lint / Rule Violations (10) | Unused Variable Detection | `LintLab.Compute_total` (`unusedValue`) |
| | Naming Convention Validation | `LintLab.max_items`, `LintLab.Compute_total` |
| | Code Style Rule Validation | `LintLab` spacing and missing braces |
| | Complexity Rule Detection | `LintLab.describe` (complexity 12) |
| | Multiple Violations Detection | several violations in `LintLab` |
| | False Positive Prevention | `LintLab.usedDespiteName` must not be flagged |
| | Custom Rule Validation | `metrics-data/lint/custom-ruleset.xml` |
| | Configuration File Handling | `metrics-data/lint/checkstyle-extra.xml`, `checkstyle-suppressions.xml` |
| | CI/CD Integration Validation | `.github/workflows/ci.yml` |
| | Violation Reporting Validation | `metrics-data/lint/expected-violations.csv` |
| Dependency Risk / SCA (6) | Transitive Dependency Analysis | `pom.xml` dependencies |
| | License Compliance Testing | `metrics-data/sca/THIRD-PARTY-LICENSES.md` |
| | Supply Chain Security Analysis | `pom.xml` pinned versions |
| | Dependency Health Monitoring | `pom.xml` (old pinned versions) |
| | Risk Prioritization | `metrics-data/sca/vulnerability-priorities.md` |
| | Vulnerability Dependency Detection | `pom.xml` (commons-text 1.9, snakeyaml 1.30 and others) |
| Statement Coverage (1) | Test Completeness Evaluation | `LogicLab`, `LogicLabTest` |
| Branch Coverage (1) | Logic Error Detection | `LogicLab` boundaries asserted exactly |
| Path Coverage (8) | Partial Path Coverage Detection | `PathLab.process` (not every path tested on purpose in `neverTrue`) |
| | Nested Condition Path Testing | `PathLab.nested` |
| | Loop Path Detection | `PathLab.loopPaths` |
| | Unreachable Path Detection | `PathLab.neverTrue` (contradictory condition) |
| | Exception Path Handling | `PathLab.safeDivide`, `process(null)` |
| | Multi-Function Path Tracking | `PathLab.process` calls three helpers |
| | CI/CD Integration Test | `.github/workflows/ci.yml` |
| | Path Execution Tracking | JaCoCo run through `mvn verify` |
| Mutation Score (1) | Code Logic Validation | `LogicLabTest` boundary assertions |
| Coverage Delta (1) | Test Suite Effectiveness Tracking | `metrics-data/coverage/baseline.json` |
| All Definition Coverage (3) | Definition-Use Mapping | `DefUseLab` |
| | Edge Case Handling | `DefUseLabTest` |
| | Reporting Validation | `metrics-data/defuse/expected-defuse-report.json` |
| All Uses Coverage (5) | Definition-Use Pair Identification | `DefUseLab.definitions` |
| | Partial Uses Coverage Detection | `DefUseLab.loopUse` |
| | Multiple Definitions Handling | `DefUseLab.multipleDefs` |
| | Unreachable Use Detection | `DefUseLab.unusedDefinition` (`dead` is never used) |
| | Coverage Reporting Validation | JaCoCo report plus `defuse/expected-defuse-report.json` |
