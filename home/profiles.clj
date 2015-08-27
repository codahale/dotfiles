{:user {:plugins [[lein-ritz "0.7.0"]
                  [lein-kibit "0.1.2"]
                  [lein-try "0.4.3"]
                  [lein-nodisassemble "0.1.3"]
                  [cider/cider-nrepl "0.10.0-SNAPSHOT"]]
        :dependencies [[ritz/ritz-nrepl-middleware "0.7.0"]
                       [ritz/ritz-debugger "0.7.0"]
                       [ritz/ritz-repl-utils "0.7.0"]
                       [org.clojure/tools.namespace "0.2.11"]]
        :repl-options {:nrepl-middleware
                       [ritz.nrepl.middleware.javadoc/wrap-javadoc
                        ritz.nrepl.middleware.simple-complete/wrap-simple-complete]
                       :init (require '[clojure.tools.namespace.repl
                                        :refer [refresh]])}}
 :hooks [ritz.add-sources]}
