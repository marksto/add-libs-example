;; 1. Run the REPL with `:alpha/hotload-libs` alias
(require '[clojure.tools.deps.alpha.repl :refer [add-libs]])

;; 2. Hotload the libraries required for the server
(add-libs
  '{http-kit/http-kit {:mvn/version "2.7.0-alpha1"}})
;; => (http-kit/http-kit)

;; 3. Require the namespace from the `http-kit` lib
(require '[org.httpkit.server :as app-server])

;; Git deps using the GitHub path (not the usual Maven group/artifact)
(require '[clojure.tools.gitlibs :as gitlibs])
(defn load-master [lib]
  (let [git (str "https://github.com/" lib ".git")]
    (add-libs lib {:git/url git :sha (gitlibs/resolve git "master")})))
(load-master 'clojure/tools.trace)
