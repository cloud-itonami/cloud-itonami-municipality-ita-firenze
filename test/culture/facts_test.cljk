(ns culture.facts-test
  (:require [clojure.edn :as edn]
            [kotoba.lang.text :as str]
            [clojure.test :refer [deftest is]]
            [culture.facts :as facts]))

(deftest firenze-has-culture-basis
  (let [sb (facts/spec-basis "firenze")]
    (is (= 9 (count sb)))
    (is (= (count sb) (count (set (map :culture/id sb)))))
    (is (every? #(str/starts-with? (:culture/url %) "https://") sb))
    (is (every? #(= "firenze" (:culture/municipality %)) sb))
    (is (every? #(= "ITA" (:culture/country %)) sb))
    (is (every? #(seq (:culture/summary %)) sb))
    (is (every? #(string? (:culture/retrieved-at %)) sb))))

(deftest unknown-municipality-has-no-basis
  (is (nil? (facts/spec-basis "roma")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["firenze" "roma"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["roma"] (:missing-municipalities c)))))

(deftest by-kind-filters
  (is (= 4 (count (facts/by-kind "firenze" :dish))))
  (is (= ["firenze.beverage.chianti"]
         (mapv :culture/id (facts/by-kind "firenze" :beverage))))
  (is (empty? (facts/by-kind "firenze" :craft)))
  (is (empty? (facts/by-kind "roma" :dish))))

(deftest tx-file-matches-catalog
  (let [tx (edn/read-string (slurp "data/culture-tx.edn"))
        flat (mapcat val (sort-by key facts/catalog))]
    (is (= (vec flat) (vec tx)))))
