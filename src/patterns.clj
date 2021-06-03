(ns patterns)

(defn filled-line
  [length symbol]
  (repeat length symbol))

(defn hollow-line
  [border-width length symbol]
  (concat (repeat border-width symbol)
        (when (> length border-width) (repeat (- length (* 2 border-width)) " "))
        (when (> length border-width) (repeat border-width symbol))))

(defn filled-rectangle
  [m n symbol]
  (->> symbol
       (filled-line m)
       (repeat n)))

(defn hollow-rectangle
  [m n symbol border-width]
  (concat
   (repeat border-width (filled-line m symbol))
   (repeat (- n (* 2 border-width)) (hollow-line border-width m symbol))
   (repeat border-width (filled-line m symbol))))

(defn alternate-rectangle
  [m n symbol1 symbol2]
  (->> [symbol1 symbol2]
       cycle
       (map (partial filled-line m))
       (take n)))

(defn filled-triangle
  [size symbol]
  (->> (inc size)
       (range 1)
       (map #(filled-line %1 symbol))))

(defn to-str
  [pattern]
  (->> pattern
       (interpose "\n")
       (mapcat identity)
       (apply str)))

(defn print-pattern
  [pattern]
  (->> pattern
       (to-str)
       (println)))