(ns my-proj.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn fizzbuzz [n] 
    (condp = 0
        (mod n 15) "fizzbuzz"
        (mod n 3) "fizz"
        (mod n 5) "buzz"
        n
    )
)

(defn fizzbuzz1ToN [n]
    (for [ x (range 1 (+ n 1))] (fizzbuzz x)))
