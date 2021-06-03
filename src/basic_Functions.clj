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
    (if (zero? (count lt))
      rl
      (recur (rest lt) (conj rl (first lt))))))