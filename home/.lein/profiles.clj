{:user {:plugins [[lein-ritz "0.7.0"]       ; debugger
                  [lein-try "0.4.3"]        ; try libraries in a repl
                  [lein-kibit "0.1.2"]      ; lint common problems
                  [lein-ancient "0.6.7"]    ; find old deps
                  [jonase/eastwood "0.2.1"] ; more linting
                  [lein-bikeshed "0.2.0"]   ; picky linting
                  [lein-cloverage "1.0.6"]  ; code coverage
                  ;; [lein-nodisassemble "0.1.3"]
                  [cider/cider-nrepl "0.10.0-SNAPSHOT"]]
        :dependencies [[ritz/ritz-nrepl-middleware "0.7.0"]
                       [ritz/ritz-debugger "0.7.0"]
                       [ritz/ritz-repl-utils "0.7.0"]
                       [org.clojure/tools.namespace "0.2.11"]
                       [slamhound "1.5.5"]]
        :repl-options {:nrepl-middleware
                       [ritz.nrepl.middleware.javadoc/wrap-javadoc
                        ritz.nrepl.middleware.simple-complete/wrap-simple-complete]
                       :init (require '[clojure.tools.namespace.repl
                                        :refer [refresh]])}
        :aliases {"analyze" ["do" ["clean"]
                             ["with-profile" "production" "deps" ":tree"]
                             ["ancient"]
                             ["kibit"]
                             ["bikeshed"]]
                  "slamhound" ["run" "-m" "slam.hound"]}}
 :hooks [ritz.add-sources]}
