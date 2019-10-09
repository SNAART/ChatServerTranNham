interface MessageObserverable {
    fun registerObserver(observer: MessageObserver)
    fun deregisterObserver(observer: MessageObserver)
    fun notifyObservers(message: ChatConsole)
}