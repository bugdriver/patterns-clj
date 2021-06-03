(ns basic-Functions-test
  (:require [clojure.test :refer [deftest testing are]]
            [basic-Functions :as b]))

(deftest ^:implemented fib-test
  (testing "Returns the nth fibonacci number"
    (are [x y] (= y (b/fib x))
      0 1
      1 1
      2 2
      3 3
      4 5
      5 8)))

(deftest ^:implemented prime?-test
  (testing "Returns if given number is prime or not"
    (are [x y] (= y (b/prime? x))
      1 true
      2 true
      3 true
      4 false
      5 true
      7 true
      9 false
      )))
    
(deftest ^:implemented reverse-list-test
  (testing "Returns reverse of given list"
    (are [x y] (= y (b/reverse-list x))
      [1 2 3] '(3 2 1)
      '(:a :b :c) '(:c :b :a)
      [:a :b :c] '(:c :b :a)
      '(1 2) '(2 1))
    )
  )
    