;; Copyright © 2014 Matthew Jaoudi
(ns leiningen.new.spa
  (:require
   [leiningen.core.main :as main]
   [leiningen.new.options.base :as base]
   [leiningen.new.options.cider :as cider]
   [leiningen.new.options.test :as test]
   [leiningen.new.options.sass :as sass]
   [leiningen.new.options.helpers :as helpers]
   [clojure.set :as set])
  (:use [leiningen.new.templates :only [name-to-path sanitize-ns ->files]]))

;; Files & Data for Template
(defn app-files
  "Create a list of application files based on the user-provided options"
  [data options]
  (let [sass? (helpers/option? sass/option options)
        test? (helpers/option? test/option options)]
    (concat
      (base/files data)
      (when sass? (sass/files data))
      (when test? (test/files data))
      )))

(defn template-data
  [name options]
  {:name      name
   :ns-name   (sanitize-ns name)
   :sanitized (name-to-path name)
   :cider?    (helpers/invoke-option cider/option options)
   :test?    (helpers/invoke-option cider/option options)
   :sass?     (helpers/invoke-option sass/option options)})

;; Check Options
(def available-set
  #{cider/option
    sass/option})


(defn check-available [options]
  (let [options-set (into #{} options)
        abort? (not (set/superset? available-set options-set))]
    (when abort?
      (main/abort "\nError: invalid profile(s)\n"))))

(defn check-options
  "Check the user-provided options"
  [options]
  (doto options
    check-available
    ))

;; Main
(defn spa [name & options]
  (let [data (template-data name options)]
    (check-options options)
    (main/info "\nGenerating single page application template...")
    (apply ->files data
           (app-files data options))))
