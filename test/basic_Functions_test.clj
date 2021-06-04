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
    
(deftest ^:implemented my-map-test
  (testing "Returns the new list with elements mapped with given function"
    (are [x y z] (= x (b/my-map y z))
      [2 3 4] inc [1 2 3]
      [1 2 3] identity [1 2 3]
      [1 2 nil]  #{1 2}   [1 2 3]
      [1 2 3] :a [{:a 1 :b 2} {:a 2 :c 3} {:d 4 :a 3}]
      ))
  )

(deftest ^:implemented my-filter-test
  (testing "Returns the new filtered list with given predicate"
    (are [x y z] (= x (b/my-filter y z))
      [2 4] even? [1 2 3 4]
      [1 3] odd? [1 2 3]
      [1 2]  #{1 2}   [1 2 3]
      [{:a 2}] :a [{:b 2} {:a 2} {:d 4}]
      ))
  )

(deftest ^:implemented my-reduce-test
  (testing "Returns the reduced result with given reducer and context"
    (are [p q r s] (= p (b/my-reduce q r s))
      10 + 0 [1 2 3 4]
      6 * 1 [1 2 3]
      '(3 2 1) conj '() [1 2 3]
  )))