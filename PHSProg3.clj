(ns phs-assignment3.core)

;; Philip Sayre
;; 12.8.2016
;; CSC410

(def fib-seq
  "creates a lazy sequence of the Fibonacci series"
  (lazy-cat [0 1] (map + (rest fib-seq) fib-seq)))


(defn sorter [x y]
  "sorts two elements in ascending order"
  (if (> x y)
    [y x]
    [x y]))

(defn merger [L R]
  "merges two vectors in ascending sort"
  (cond
    (empty? L) R
    (empty? R) L
    :else
    (let [x (first L)
          y (first R)]
      (if (> x y)
        (cons y (merger (rest R) L))
        (cons x (merger (rest L) R))))))

(defn merge-sort [seq]
  "runs the merge sort on a given vector"
  (cond 
    (< (count seq) 2) seq
    (= (count seq) 2) (apply sorter seq)
    :else
    (let [[a b] (split-at (/ (count seq) 2) seq)]
      (merger (merge-sort a) (merge-sort b)))))