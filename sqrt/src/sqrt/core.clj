(ns sqrt.core)

(defn weather-judge
  "Given weather in degree Celsius, amounts of temp"
  [temp]
  (cond 
    (< temp 20) "It's cold"
    (> temp 25) "It's hot"
    :else "It's comfortable"))

(defn abs
  "calculates the absolute value"
  [n]
  (if (< n 0)
    (* -1 n)
    n))

(defn avg
  "calculates avg"
  [a b]
  (/ (+ a b) 2))

(defn good-enough?
  "Test if a guess is close enough"
  [guess number]
  (let [diff (- (* guess guess) number)]
    (if (< (abs diff) 0.01)
      true
      false)))

(defn sqrt
  "returns the squareroot"
  ([number] (sqrt number 1))
  ([number guess]
    (if (good-enough? number guess)
      guess
      (sqrt number (avg guess (/ number guess))))))
