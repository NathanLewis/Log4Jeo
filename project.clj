(defproject log4jeo "0.1.0-SNAPSHOT"
  :description ""
  :url "https://github.com/W12-Clojure-Group/Log4Jeo"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.8"]
                 [hiccup "1.0.5"]
                 [incanter "1.5.5"]
                 [clj-time "0.7.0"]
                 [com.datomic/datomic-free "0.9.4752"]
                 ]
  :plugins [[lein-ring "0.8.10"]
            [lein-datomic "0.2.0"]
            [lein-cljsbuild "1.0.3"]]
  :ring {:handler log4jeo.handler/app}
  :profiles {
      :dev {
        :dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]
                        [alembic "0.1.1"]]
        :datomic {
             :config "resources/transactor.properties"
             :db-uri "datomic:free://localhost:4334/log4jeo"}
        }
   }
  :datomic {:schemas ["resources/schemas" ["geo-ip-schema.edn" ]]}
  :cljsbuild {:builds
              [{:source-paths ["src-cljs"],
                :compiler
                {:pretty-print true,
                 :output-to "resources/js/script.js",
                 :optimizations :whitespace}}]}
  )
