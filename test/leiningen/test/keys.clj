(ns leiningen.test.keys
  (:require [clojure.test :refer :all]))

(def df (java.text.SimpleDateFormat. "yyyy-MM-dd"))

(deftest technomancy-gpg-key
  (let [month-before-key-expiry (.parse df "2017-05-14")]
    (is (< (System/currentTimeMillis) (.getTime month-before-key-expiry))
        "If this fails, yell at technomancy to generate a new key!")))

(deftest clojars-ssl-cert
  (let [month-before-cert-expiry (.parse df "2016-07-12")]
    (is (< (System/currentTimeMillis) (.getTime month-before-cert-expiry))
        "If this fails, yell at _ato to get a new SSL cert.")))
