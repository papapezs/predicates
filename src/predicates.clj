(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-key]
  (fn [a-set] (if (nil? a-set) (some nil? a-key) (a-key a-set))))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (every? whitespace? string) (empty? string) (nil? string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [awards-match (filter (fn [x] (has-award? book x)) awards)]
    (= (count awards-match) (count awards))))

(defn my-some [pred a-seq]
  (if (nil? (some pred a-seq)) false (some pred a-seq)))

(defn my-every? [pred a-seq]
  (every? pred a-seq))

(defn prime? [n]
  (let [pred (fn [x] (= 0 (mod n x)))]
    (not (some pred (range 2 n)))))
;^^
