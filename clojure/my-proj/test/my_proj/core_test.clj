(ns my-proj.core-test
  (:require [clojure.test :refer :all]
            [my-proj.core :refer :all]))

(deftest fizzbuzzwith1returns1 
  (testing "fizzbuzz with 1 gives 1"
  (is (= (fizzbuzz 1) 1))))

(deftest fizzbuzzwith2returns2
  (testing "fizzbuzz with 2 gives 2"
  (is (= (fizzbuzz 2) 2))))

(deftest fizzbuzzwith3returnsfizz
  (testing "fizzbuzz with 3 gives 'fizz'"
  (is (= (fizzbuzz 3) "fizz"))))

(deftest fizzbuzzwith9returnsfizz
  (testing "fizzbuzz with 9 gives 'fizz'"
  (is (= (fizzbuzz 9) "fizz"))))

(deftest fizzbuzzwith5returnsbuzz
  (testing "fizzbuzz with 5 gives 'buzz'"
  (is (= (fizzbuzz 5) "buzz"))))

(deftest fizzbuzzwith10returnsbuzz
  (testing "fizzbuzz with 10 gives 'buzz'"
  (is (= (fizzbuzz 10) "buzz"))))

(deftest fizzbuzzwith15returnsfizzbuzz
  (testing "fizzbuzz with 15 gives 'fizzbuzz'"
  (is (= (fizzbuzz 15) "fizzbuzz"))))

(deftest fizzbuzz1tonwith1returns1
  (testing "fizzbuzz1ToN with 1 gives [1]"
  (is (= (fizzbuzz1ToN 1) [1]))))

(deftest fizzbuzz1tonwith2returns12
  (testing "fizzbuzz1ToN with 2 gives [1, 2]"
  (is (= (fizzbuzz1ToN 2) [1 2]))))

(deftest fizzbuzz1tonwith3returns12fizz
  (testing "fizzbuzz1ToN with 2 gives [1, 2, fizz]"
  (is (= (fizzbuzz1ToN 3) [1 2 "fizz"]))))

(deftest fizzbuzz1tonwith5returns12fizz4buzz
  (testing "fizzbuzz1ToN with 2 gives [1, 2, fizz, 4, buzz]"
  (is (= (fizzbuzz1ToN 5) [1 2 "fizz" 4 "buzz"]))))

(deftest fizzbuzz1tonwith15
  (testing "fizzbuzz1ToN with 15 gives [1, 2, fizz, 4, buzz, .... 13 14 fizzbuzz]"
  (is (= (fizzbuzz1ToN 15) [1 2 "fizz" 4 "buzz" "fizz" 7 8 "fizz" "buzz" 11 "fizz" 13 14 "fizzbuzz"]))))

