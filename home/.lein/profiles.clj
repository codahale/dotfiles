{:repl {:plugins [[refactor-nrepl "2.0.0-SNAPSHOT"]
                  [cider/cider-nrepl "0.10.0-SNAPSHOT"
                   :exclusions [org.clojure/tools.nrepl]]]
        :dependencies [[org.clojure/tools.nrepl "0.2.12"]
                       [org.clojure/tools.namespace "0.2.11"]
                       [acyclic/squiggly-clojure "0.1.4"]]
        :repl-options {:init (require '[clojure.tools.namespace.repl
                                        :refer [refresh]])}}
 :user {:plugins [[org.clojure/clojure "1.8.0-RC2"]
                  [lein-try "0.4.3"] ; try libraries in a repl
                  [lein-kibit "0.1.2"] ; lint common problems
                  [lein-ancient "0.6.8"]    ; find old deps
                  [jonase/eastwood "0.2.2"] ; more linting
                  [lein-bikeshed "0.2.0"]   ; picky linting
                  [lein-cloverage "1.0.6"]  ; code coverage
                  [lein-cljfmt "0.3.0"]]
        :dependencies [[pjstadig/humane-test-output "0.7.0"]
                       [slamhound "1.5.5"]]
        :injections [(require 'pjstadig.humane-test-output)
                     (pjstadig.humane-test-output/activate!)]
        :aliases {"analyze" ["do" ["clean"]
                             ["with-profile" "production" "deps" ":tree"]
                             ["ancient"]
                             ["kibit"]
                             ["bikeshed"]]
                  "slamhound" ["run" "-m" "slam.hound"]}}}
