(ns patterns-test
  (:require [clojure.test :refer [deftest testing are]]
            [patterns :as p]))


(deftest ^:implemented filled-line-test
  (testing "Returns the coll with given number of rows and symbol"
    (are [x y z] (= x (p/filled-line y z))
      '() 0 "*"
      '("*") 1 "*"
      '("*" "*" "*" "*") 4 "*" 
      '("-" "-" "-" "-") 4 "-" 
      ))
  )