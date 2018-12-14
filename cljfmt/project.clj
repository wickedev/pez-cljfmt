(defproject pez/cljfmt "0.0.3-SNAPSHOT"
  :description "An adapted cljfmt used by Calva Formatter"
  :url "https://github.com/PEZ/cljfmt"
  :scm {:dir ".."}
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/tools.cli "0.3.7"]
                 [org.clojure/tools.reader "1.2.2"]
                 [com.googlecode.java-diff-utils/diffutils "1.3.0"]
                 [rewrite-clj "0.6.0"]
                 [pez/rewrite-cljs "0.4.4-SNAPSHOT"]]
  :plugins [[lein-cljsbuild "1.1.7"]]
  :hooks [leiningen.cljsbuild]
  :cljsbuild {:builds
              {"dev" {:source-paths ["src" "test"]
                      :compiler {:main cljfmt.test-runner
                                 :output-to "target/out/tests.js"
                                 :output-dir "target/out"
                                 :target :nodejs
                                 :optimizations :none}}}
              :test-commands
              {"dev" ["node" "target/out/tests.js"]}}
  :profiles
  {:provided {:dependencies [[org.clojure/clojurescript "1.10.339"]]}})
