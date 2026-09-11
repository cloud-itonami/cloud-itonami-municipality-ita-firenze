# cloud-itonami-municipality-ita-firenze

Municipal-ordinance compliance catalog for **Florence** (Comune di
Firenze) — a Wave 1b addition per ADR-2607171400 addendum 2, joining the
`cloud-itonami-municipality-*` compliance-fact family of ADR-2607141700
(`cloud-itonami-compliance-fact-federation`, in `com-junkawasaki/root`;
see e.g.
[`cloud-itonami-municipality-ita-roma`](https://github.com/cloud-itonami/cloud-itonami-municipality-ita-roma)
and
[`cloud-itonami-municipality-fra-paris`](https://github.com/cloud-itonami/cloud-itonami-municipality-fra-paris)).
Part of the [`cloud-itonami`](https://github.com/cloud-itonami)
compliance-fact family.

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on the Comune di
Firenze's behalf.

Coverage is reported honestly (see `ordinance.facts/coverage`): a
municipality not in `catalog` has **no spec-basis**, full stop — never
fabricate one.

## Data

- `src/ordinance/facts.cljk` — the catalog, source of truth.
- `schema/ordinance.edn` — DataScript schema.
- `data/datascript-tx.edn` — derived DataScript tx-data (query this
  alongside other `cloud-itonami`/`etzhayyim` compliance-fact sources via
  `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljs`).

Both entries were verified on 2026-07-17 by downloading each source PDF
from official Comune di Firenze domains and directly reading the PDF
text: the **Regolamento Edilizio** (Deliberazione Consiglio Comunale
2025/C/00035 del 10/06/2025) and the **Regolamento del Consiglio
Comunale** (Deliberazione del Consiglio comunale n. 60 del 26/10/2015,
con successive modifiche; the day/month of the latest 2025 amendment is
typographically ambiguous in the source PDF and is recorded by year
only).

## Culture catalog

Alongside the ordinance catalog, this repo carries a **regional-culture
catalog** (ADR-2607171400, `cloud-itonami-municipality-culture-catalog`
in `com-junkawasaki/root`) — local dishes, protected products, beverages,
festivals and heritage sites for Florence:

- `src/culture/facts.cljk` — the catalog, source of truth.
- `schema/culture.edn` — DataScript schema.
- `data/culture-tx.edn` — derived DataScript tx-data (regenerated from
  the catalog, never hand-edited).

Same provenance discipline as the ordinance catalog: every entry cites a
source URL that was actually fetched and read on `:culture/retrieved-at`;
summaries state only what the cited source confirms. An item not in
`culture.facts/catalog` has no spec-basis — never fabricate one.

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention). Ordinance text
itself remains the Comune di Firenze's; this repo stores only citation
metadata (id/title/url/dates), not full text.
