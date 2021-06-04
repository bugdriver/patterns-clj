(ns basic-Functions)

(defn fib [n]
  (loop [x 1 a 1 n n]
    (if (< n 2)
      a
      (recur a (+ x a) (dec n)))))

(defn prime? [number]
  (not-any? #(zero? (rem number %1)) (range 2 number)))

(defn reverse-list [list]
  (loop [lt list
         rl '()]
    (if (empty? lt)
      rl
      (recur (rest lt) (conj rl (first lt))))))


(defn my-map [func list]
  (loop [l list
         nl []]
    (if (empty? l)
      nl
      (recur (rest l) 
             (conj nl (func (first l)))))))

(defn my-filter [func list]
  (loop [l list
         nl []]
    (if (empty? l)
      nl
      (recur (rest l)
             (if (func (first l))
               (conj nl (first l))
               nl)))))

(defn my-reduce [reducer context list]
  (loop [l list
         r context]
    (if (empty? l)
      r
      (recur (rest l) (reducer r (first l))))))