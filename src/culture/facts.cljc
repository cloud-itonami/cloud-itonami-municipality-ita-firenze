(ns culture.facts
  "Regional-culture catalog for Florence (Comune di Firenze) -- local dishes,
  protected products, beverages, festivals and heritage sites, piggybacked
  onto this municipality compliance repo per ADR-2607171400
  (cloud-itonami-municipality-culture-catalog, in com-junkawasaki/root),
  sibling namespace to `ordinance.facts` (ADR-2607141700).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "municipality-slug -> vector of culture entries."
  {"firenze"
   [{:culture/id "firenze.dish.bistecca-alla-fiorentina"
     :culture/name "Bistecca alla fiorentina"
     :culture/municipality "firenze"
     :culture/country "ITA"
     :culture/kind :dish
     :culture/summary "Loin steak on the bone from young Chianina-breed cattle, grilled rare; one of the most famous dishes of Tuscan cuisine, named Florentine-style."
     :culture/url "https://en.wikipedia.org/wiki/Bistecca_alla_fiorentina"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "firenze.dish.lampredotto"
     :culture/name "Lampredotto"
     :culture/municipality "firenze"
     :culture/country "ITA"
     :culture/kind :dish
     :culture/summary "Typical Florentine dish made from the abomasum of cattle, slow-cooked in vegetable broth and served in a bread roll; a traditional street food of Florence."
     :culture/url "https://en.wikipedia.org/wiki/Lampredotto"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "firenze.dish.ribollita"
     :culture/name "Ribollita"
     :culture/municipality "firenze"
     :culture/country "ITA"
     :culture/kind :dish
     :culture/summary "Tuscan bread soup of peasant origin made with bread, cannellini beans, lacinato kale, cabbage and inexpensive vegetables, often from leftovers."
     :culture/url "https://en.wikipedia.org/wiki/Ribollita"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "firenze.dish.schiacciata-alla-fiorentina"
     :culture/name "Schiacciata alla fiorentina"
     :culture/municipality "firenze"
     :culture/country "ITA"
     :culture/kind :dish
     :culture/summary "Typical Florentine sweet cake traditionally made during the Carnival period, soft and no more than about 3 cm high, dusted with powdered sugar."
     :culture/url "https://it.wikipedia.org/wiki/Schiacciata_alla_fiorentina"
     :culture/url-provenance :wikipedia-it
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "firenze.product.finocchiona"
     :culture/name "Finocchiona"
     :culture/municipality "firenze"
     :culture/country "ITA"
     :culture/kind :product
     :culture/summary "Salami variety typical of Florence characterized by the use of fennel, which grew wild in the Tuscan countryside; an Italian protected-designation product with Renaissance-era origins."
     :culture/url "https://en.wikipedia.org/wiki/Finocchiona"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "firenze.beverage.chianti"
     :culture/name "Chianti"
     :culture/municipality "firenze"
     :culture/country "ITA"
     :culture/kind :beverage
     :culture/summary "Italian red wine produced in the Chianti region of central Tuscany, principally from the Sangiovese grape; the Chianti Classico DOCG heartland lies between Florence and Siena."
     :culture/url "https://en.wikipedia.org/wiki/Chianti"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "firenze.festival.scoppio-del-carro"
     :culture/name "Scoppio del Carro"
     :culture/municipality "firenze"
     :culture/country "ITA"
     :culture/kind :festival
     :culture/summary "Florentine folk tradition held on Easter Sunday in which a cart packed with fireworks is lit in front of the cathedral in Piazza del Duomo; its present form dates to the end of the 15th century."
     :culture/url "https://en.wikipedia.org/wiki/Scoppio_del_carro"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "firenze.festival.calcio-fiorentino"
     :culture/name "Calcio fiorentino"
     :culture/name-local "Calcio storico fiorentino"
     :culture/municipality "firenze"
     :culture/country "ITA"
     :culture/kind :festival
     :culture/summary "Early form of football still played in Piazza Santa Croce, Florence, during the celebrations of St. John the Baptist, with the final held annually on 24 June."
     :culture/url "https://en.wikipedia.org/wiki/Calcio_fiorentino"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "firenze.heritage.centro-storico"
     :culture/name "Historic Centre of Florence"
     :culture/name-local "Centro storico di Firenze"
     :culture/municipality "firenze"
     :culture/country "ITA"
     :culture/kind :heritage
     :culture/summary "Florence's historic centre, a UNESCO World Heritage Site since 1982, containing the cathedral of Santa Maria del Fiore, the Church of Santa Croce, the Uffizi and the Pitti Palace."
     :culture/url "https://en.wikipedia.org/wiki/Historic_Centre_of_Florence"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

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
      :note (str "cloud-itonami-municipality-ita-firenze culture catalog "
                 "(ADR-2607171400): " (count (get catalog "firenze"))
                 " Firenze entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [muni kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis muni)))
