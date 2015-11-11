{:user {:plugins [[org.clojure/clojure "1.8.0-RC1"]
                  [lein-try "0.4.3"] ; try libraries in a repl
                  [lein-kibit "0.1.2"] ; lint common problems
                  [lein-ancient "0.6.8"]    ; find old deps
                  [jonase/eastwood "0.2.1"] ; more linting
                  [lein-bikeshed "0.2.0"]   ; picky linting
                  [lein-cloverage "1.0.6"]  ; code coverage
                  [lein-difftest "2.0.0"]   ; humane test output
                  [lein-hiera "0.9.0"]      ; graphviz of dependencies
                  [com.aphyr/prism "0.1.3"] ; continuous testing
                  [lein-cljfmt "0.3.0"]
                  [refactor-nrepl "2.0.0-SNAPSHOT"]
                  [cider/cider-nrepl "0.10.0-SNAPSHOT"
                   :exclusions [org.clojure/tools.nrepl]]]
        :dependencies [[org.clojure/tools.nrepl "0.2.12"]
                       [org.clojure/tools.namespace "0.2.11"]
                       [pjstadig/humane-test-output "0.7.0"]
                       [slamhound "1.5.5"]]
        :injections [(require 'pjstadig.humane-test-output)
                     (pjstadig.humane-test-output/activate!)]
        :repl-options {:init (require '[clojure.tools.namespace.repl
                                        :refer [refresh]])}
        :aliases {"analyze" ["do" ["clean"]
                             ["with-profile" "production" "deps" ":tree"]
                             ["ancient"]
                             ["kibit"]
                             ["bikeshed"]]
                  "slamhound" ["run" "-m" "slam.hound"]}}}
