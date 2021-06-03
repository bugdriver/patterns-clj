(ns patterns-test
  (:require [clojure.test :refer [deftest testing is are]]
            [patterns :as p]))


(deftest ^:implemented filled-line-test
  (testing "Returns the list of symbols of given length"
    (are [x y z] (= x (p/filled-line y z))
      '() 0 "*"
      '("*") 1 "*"
      '("*" "*" "*" "*") 4 "*" 
      '("-" "-" "-" "-") 4 "-" 
      ))
  )

(deftest ^:implemented hollow-line-test
  (testing "Returns the empty list when length and border-width is 0"
    (is (= '() (p/hollow-line 0 0 "*"))))
  (testing "Returns the list of symbols with spaces in between and given border-width"
    (are [a b c d] (= a (p/hollow-line b c d))
      '("*") 1 1 "*"
      '("*" " " " " "*") 1 4 "*" 
      '("-" " " " " "-") 1 4 "-" 
      ))
  )

(deftest ^:implemented filled-rectangle-test
  (testing "Returns the empty list when length and width of rectangle is 0"
    (is (= '() (p/filled-rectangle 0 0 "*"))))
  (testing "Returns the list of rows with given length and symbol"
    (are [a b c d] (= a (p/filled-rectangle b c d))
      '(("*")) 1 1 "*"
      '(("*") ("*") ("*") ("*")) 1 4 "*" 
      '(("-" "-") ("-" "-") ("-" "-") ("-" "-")) 2 4 "-" 
      ))
  )

(deftest ^:implemented hollow-rectangle-test
  (testing "Returns the empty list when length and width of rectangle is 0"
    (is (= '() (p/hollow-rectangle 0 0 "*" 0))))
  (testing "Returns the list of rows with given length and symbol with spaces in middle"
    (are [a b c d e] (= a (p/hollow-rectangle b c d e))
      '(("*") ("*")) 1 1 "*" 1
      '(("*" "*" "*") ("*" " " "*") ("*" " " "*") ("*" "*" "*")) 3 4 "*" 1
      '(("*" "*" "*" "*") ("*" " " " " "*") ("*" " " " " "*") ("*" "*" "*" "*")) 4 4 "*" 1
      ))
  )

(deftest ^:implemented alternate-rectangle-test
  (testing "Returns the empty list when length and width of rectangle is 0"
    (is (= '() (p/alternate-rectangle 0 0 "*" "-"))))
  (testing "Returns the list of rows with given length and alternate symbols"
    (are [a b c d e] (= a (p/alternate-rectangle b c d e))
      '(("*")) 1 1 "*" "-"
      '(("*") ("-") ("*") ("-")) 1 4 "*" "-"
      '(("-" "-") ("*" "*") ("-" "-") ("*" "*")) 2 4 "-" "*"
      ))
  )

(deftest ^:implemented filled-triangle-test
  (testing "Returns the empty list when size of triangle is 0"
    (is (= '() (p/filled-triangle 0 "*"))))
  (testing "Returns the list of rows with given size and symbol"
    (are [a b c] (= a (p/filled-triangle b c))
      '(("*")) 1 "*"
      '(("*") ("*" "*") ("*" "*" "*") ("*" "*" "*" "*")) 4 "*" 
      '(("-") ("-" "-") ("-" "-" "-") ("-" "-" "-" "-")) 4 "-" 
      ))
  )

(deftest ^:implemented to-str-test
  (testing "Returns the empty string when size of list is 0"
    (is (= "" (p/to-str '()))))
  (testing "Returns string representation of pattern with seperated by \n"
    (are [a b] (= a (p/to-str b))
      "*" '(("*"))
      "*\n*\n*\n*" '(("*") ("*") ("*") ("*")) 
      "-\n--\n---\n----" '(("-") ("-" "-") ("-" "-" "-") ("-" "-" "-" "-"))
      ))
  )