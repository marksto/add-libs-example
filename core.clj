;; 1. Run REPL with `:lib/hotload` alias turned on
(require '[clojure.tools.deps.repl :refer [add-libs]])

;; 2. Hotload any libraries required for the server
(add-libs
  '{http-kit/http-kit {:mvn/version "2.7.0-alpha1"}})
;; => (http-kit/http-kit)

;; 3. Require & eval the ns from the hotloaded lib
(require '[org.httpkit.server :as app-server])


;; Git deps using the GitHub path (not the usual Maven group/artifact)
(require '[clojure.tools.gitlibs :as gitlibs])
(defn load-master [lib]
  (let [git (str "https://github.com/" lib ".git")]
    (add-libs lib {:git/url git :sha (gitlibs/resolve git "master")})))
(load-master 'clojure/tools.trace)
