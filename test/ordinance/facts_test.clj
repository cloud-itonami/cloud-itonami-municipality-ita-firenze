(ns ordinance.facts-test
  (:require [clojure.edn :as edn]
            [clojure.test :refer [deftest is]]
            [ordinance.facts :as facts]))

(deftest firenze-has-spec-basis
  (let [sb (facts/spec-basis "firenze")]
    (is (= 2 (count sb)))
    (is (every? #(re-find #"^https://[a-z]+\.comune\.(fi|firenze)\.it/" (:ordinance/url %)) sb))))

(deftest unknown-municipality-has-no-spec-basis
  (is (nil? (facts/spec-basis "roma")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["firenze" "roma"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["roma"] (:missing-municipalities c)))))

(deftest by-topic-filters
  (is (= ["firenze.regolamento-edilizio-2025"]
         (mapv :ordinance/id (facts/by-topic "firenze" :building))))
  (is (empty? (facts/by-topic "firenze" :labor)))
  (is (empty? (facts/by-topic "roma" :governance))))

(deftest tx-file-matches-catalog
  (let [tx (edn/read-string (slurp "data/datascript-tx.edn"))
        flat (mapcat val (sort-by key facts/catalog))]
    (is (= (vec flat) (vec tx)))))
