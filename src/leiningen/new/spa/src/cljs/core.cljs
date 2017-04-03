(ns {{ns-name}}.core
  (:require
   [reagent.core :as r :refer [atom cursor]]))

(when js/goog.DEBUG
  (enable-console-print!))

(def state (atom 0))

(defn app []
  [:div
   [:p [:code "Button has been clicked "] @state [:code " times."]]
   [:input {:type "button" :value "Click me"
            :on-click #(swap! state inc)}]])

(defn ^:export main []
  (r/render
    [app] (.getElementById js/document "app")))
