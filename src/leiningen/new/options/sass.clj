(ns leiningen.new.options.sass
  (:require [leiningen.new.options.helpers :as helpers]))

(def option "+sass")

(defn files [data]
  [["src/sass/styles.scss" 
    (helpers/render "src/sass/styles.scss" data)]
   ["resources/public/css/styles.css" 
    (helpers/render "resources/public/css/styles.css" data)] ])
