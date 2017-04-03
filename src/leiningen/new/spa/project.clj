(defproject {{ns-name}} "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.229"]
                 [reagent "0.6.0"]
                 {{#routes?}}[secretary "1.2.3"]{{/routes?}}
                 {{#devcards?}}[devcards "0.2.2" :exclusions [cljsjs/react]]{{/devcards?}}]

  :min-lein-version "2.5.3"

  :source-paths ["src/clj"]

  :plugins [[lein-cljsbuild "1.1.4"]
            {{#sass?}}[yogthos/lein-sass "0.1.1"]{{/sass?}}]
  :clean-targets ^{:protect false} ["resources/public/js/compiled"
                                    "target"]

  :figwheel {:css-dirs ["resources/public/css"]}
  {{#sass?}}
  :sass {:source "src/sass"
         :target  "resources/public/css"}{{/sass?}}
  {{#cider?}}
  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
  {{/cider?}}
  :profiles
  {:dev
   {:dependencies [{{#cider?}}
                   [figwheel-sidecar "0.5.8"]
                   [com.cemerick/piggieback "0.2.1"]{{/cider?}}]

    :plugins      [[lein-figwheel "0.5.8"]{{#test?}}
                   [lein-doo "0.1.7"]{{/test?}}{{#cider?}}
                   [cider/cider-nrepl "0.13.0"]{{/cider?}}]
    }}

  :cljsbuild
  {:builds
   [{:id           "dev"
     :source-paths ["src/cljs"]
     :figwheel     {:on-jsload "{{name}}.core/reload"}
     :compiler     {:main                 {{name}}.core
                    :optimizations        :none
                    :output-to            "resources/public/js/compiled/app.js"
                    :output-dir           "resources/public/js/compiled/dev"
                    :asset-path           "js/compiled/dev"
                    :source-map-timestamp true}}
    {:id           "min"
     :source-paths ["src/cljs"]
     :compiler     {:main            {{name}}.core
                    :optimizations   :advanced
                    :output-to       "resources/public/js/compiled/app.js"
                    :output-dir      "resources/public/js/compiled/min"
                    :closure-defines {goog.DEBUG false}
                    :pretty-print    false}}
    {{#test?}}
    {:id           "test"
     :source-paths ["src/cljs" "test/cljs"]
     :compiler     {:output-to     "resources/public/js/compiled/test.js"
                    :output-dir    "resources/public/js/compiled/test"
                    :main          {{name}}.runner
                    :optimizations :none}}{{/test?}}
    ]})
