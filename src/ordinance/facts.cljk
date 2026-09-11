(ns ordinance.facts
  "Municipal-ordinance compliance catalog for Florence (Comune di Firenze) --
  a Wave 1b addition per ADR-2607171400 addendum 2, joining the
  cloud-itonami-municipality-* compliance-fact family of ADR-2607141700
  (cloud-itonami-compliance-fact-federation).

  Every entry cites an OFFICIAL Comune di Firenze PDF (comune.fi.it /
  comune.firenze.it) -- never fabricated. An ordinance not in this table
  has NO spec-basis, full stop; extend `catalog`, do not invent an
  id/url/number.

  Both entries below were verified on 2026-07-17 by downloading each
  source PDF from official Comune di Firenze domains (the 'Atti generali'
  index on amministrazionetrasparente.comune.firenze.it, and the Edilizia
  urbanistica section on ediliziaurbanistica.comune.fi.it) and directly
  reading the PDF text via the Read tool: each title, deliberation number
  and date stated here appears on the title page of the cited PDF. The
  Regolamento del Consiglio Comunale title page also lists a 2025
  amendment (Del. n. 55) whose day/month is typographically ambiguous in
  the source, so it is recorded here by year only.")

(def catalog
  "municipality-slug -> vector of ordinance entries."
  {"firenze"
   [{:ordinance/id "firenze.regolamento-edilizio-2025"
     :ordinance/title "Regolamento Edilizio — Comune di Firenze"
     :ordinance/municipality "firenze"
     :ordinance/country "ITA"
     :ordinance/kind :ordinance
     :ordinance/number "Deliberazione Consiglio Comunale 2025/C/00035 del 10/06/2025"
     :ordinance/url "https://ediliziaurbanistica.comune.fi.it/export/sites/ediliziaurbanistica/materiali/RegolamentoEdilizio_2025C00035.pdf"
     :ordinance/url-provenance :official-comune-fi-it
     :ordinance/enacted-date "2025-06-10"
     :ordinance/retrieved-at "2026-07-17"
     :ordinance/topic #{:building :urban-planning}}
    {:ordinance/id "firenze.regolamento-consiglio-comunale-2015"
     :ordinance/title "Regolamento del Consiglio Comunale"
     :ordinance/municipality "firenze"
     :ordinance/country "ITA"
     :ordinance/kind :ordinance
     :ordinance/number "Deliberazione del Consiglio comunale n. 60 del 26/10/2015, modificato con Del. n. 13 del 16/04/2018, Del. n. 52 del 29/10/2018, Del. n. 11 del 28/03/2022, Del. n. 5 del 06/03/2023 e Del. n. 55 del 2025"
     :ordinance/url "https://amministrazionetrasparente.comune.firenze.it/system/files/2025-09/06092025_Regolamento%20del%20Consiglio%20Comunale_0.pdf"
     :ordinance/url-provenance :official-comune-firenze-it
     :ordinance/enacted-date "2015-10-26"
     :ordinance/retrieved-at "2026-07-17"
     :ordinance/topic #{:governance :municipal-council}}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-ita-firenze Wave 1b (ADR-2607171400 "
                 "addendum 2 / family ADR-2607141700): "
                 (count (get catalog "firenze")) " Firenze entries seeded with "
                 "official Comune di Firenze citations. Extend "
                 "`ordinance.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [muni topic]
  (filterv #(contains? (:ordinance/topic %) topic) (spec-basis muni)))
