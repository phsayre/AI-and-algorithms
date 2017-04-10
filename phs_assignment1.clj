(ns phs-assignment1.core)

;; Philip Sayre
;; 9.24.2016
;; CSC410


(defn double1 [userlist]
  (if (= 0 (count userlist))
    (print "The list is empty!")
    (let [genlist (repeat 2 (last userlist))]
      (let [userlist (drop-last userlist)]
        (loop [userlist userlist
               genlist genlist]
          (if (= 0 (count userlist))
            genlist
            
            (recur (drop-last userlist) (cons (last userlist) (cons (last userlist) (list genlist))))))))))

;; below is my second version of double1
(defn double1-ec [userlist]
  (if (= 0 (count userlist))
    (print "The list is empty!")
    (let [genlist (repeat 2 (last userlist))]
      (let [userlist (drop-last userlist)]
        (loop [userlist userlist
               genlist genlist]
          (if (= 0 (count userlist))
            genlist
            
            (recur (drop-last userlist) (concat (list (last userlist)) (cons (last userlist) (list genlist))))))))))
;; double1-ec recurrence concats a list to genlist, whereas double1 recurrence uses the cons macro to achieve the same result


(defn double2 [userlist]
  (if (= 0 (count userlist))
    (print "The list is empty!")
    (let [genlist (repeat 2 (last userlist))]
      (let [userlist (drop-last userlist)]
        (loop [userlist userlist
               genlist genlist]
          (if (= 0 (count userlist))
            genlist
            
            (recur (drop-last userlist) (cons (last userlist) (into genlist [(last userlist)])))))))))

;; below is my second version of double2
(defn double2-ec [userlist]
  (if (= 0 (count userlist))
    (print "The list is empty!")
    (let [genlist (repeat 2 (last userlist))]
      (let [userlist (drop-last userlist)]
        (loop [userlist userlist
               genlist genlist]
          (if (= 0 (count userlist))
            genlist
            
            (recur (drop-last userlist) (concat (list (last userlist)) (into genlist [(last userlist)])))))))))
;; double2-ec recurrence concats a list to genlist, whereas double2 recurrence uses the cons macro to achieve the same result