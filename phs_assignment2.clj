(ns phs-assignment2.core)

;; Philip Sayre
;; 10.14.2016
;; CSC410

(defn member? [userlist, x]
  "checks if a given element is a member of a list"
  (loop [userlist userlist
         x x]
    (if (= x (first userlist))
      true
      
      (if (empty? userlist)
        false
        
        (recur (pop userlist) x)))))


(defn nodupls [userlist]
  "removes duplicates from a list"
  
  (if (empty? userlist)
    userlist
    
    (if (member? (rest userlist) (peek userlist))
      (nodupls (rest userlist))
      (if (or (= 1 (count userlist)) (empty? userlist))
        userlist
        (cons (peek userlist) (nodupls (rest userlist)))))))