

(def my-client-id (str (random-uuid)))
(def topic "our-topic-2384623874623746238428376234")
(def my-name (str "Henrik (chat-app) " my-client-id))
(def mqtt-uri "wss://mqtt.eclipseprojects.io/mqtt")

(declare client)

(defn append-message-to-html-body [text]
  (let [el (js/document.createElement "div")]
    (aset el "innerHTML" text)
    (.appendChild js/document.body el)))

(defn on-connect []
  (println "*** connected!")
  (.subscribe client topic)
  (println "*** subscibed!"))

(defn on-message-arrived [msg]
  (let [text (-> msg (aget "payloadString"))]
    (append-message-to-html-body text)
    (println "*** received from" text)))

(defonce client
  (doto (js/Paho.MQTT.Client. mqtt-uri my-client-id)
    (.connect (clj->js {:onSuccess on-connect}))
    (aset "onMessageArrived" #(on-message-arrived %))))

(defn publish [text]
  (if-not (.isConnected client)
    (do
      (println (str "*** delay '" text "' because not connected yet!"))
      (js/setTimeout #(publish text) 1000))
    (let [msg (js/Paho.MQTT.Message. (str my-name ": " text))]
      (aset msg "destinationName" topic)
      (.send client msg))))

(defonce grettings! (publish "Hallo hier bin ich!"))

(publish "Blablabla")